package com.example.demo.datatablev2;

import com.example.demo.datatablev2.annotation.DataTableColumn;
import com.example.demo.datatablev2.annotation.DataTableEntity;
import com.example.demo.datatablev2.dto.TableMetadata;
import com.example.demo.datatablev2.dto.fields.ColumnDetails;
import com.example.demo.dto.QualityNotification;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
public class AnnotationTableBuilder {

    protected final MessageSource messageSource;

    public AnnotationTableBuilder(MessageSource messageSource) {
       this.messageSource = messageSource;
    }

    public TableMetadata buildTableMetadata(String tableName) {
        TableMetadata tableMetadata = new TableMetadata();
        List<Class<?>> candidates = Arrays.asList(QualityNotification.class);

        Class<?> entityClass = findEntityByName(tableName, candidates);
        List<ColumnDetails> columns = this.getColumnsFromEntity(entityClass);
        tableMetadata.setColumns(columns);
        return tableMetadata;
    }

    public Class<?> findEntityByName(String name, List<Class<?>> candidates) {
        for (Class<?> clazz : candidates) {
            DataTableEntity annotation = clazz.getAnnotation(DataTableEntity.class);
            if (annotation != null && annotation.name().equals(name)) {
                return clazz;
            }
        }
        throw new IllegalArgumentException("No entity found with name: " + name);
    }


    private List<ColumnDetails> getColumnsFromEntity(Class<?> entityClass) {
        List<ColumnDetails> columns = new ArrayList<>();
        Locale locale = LocaleContextHolder.getLocale();

        for (Field field : entityClass.getDeclaredFields()) {
            DataTableColumn annotation = field.getAnnotation(DataTableColumn.class);
            if (annotation != null) {
                ColumnDetails column = new ColumnDetails();
                String labelKey = annotation.label();
                if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
                    String extracted = labelKey.substring(1, labelKey.length() - 1);
                    String translated = this.messageSource.getMessage(extracted, null, extracted, locale);
                    column.setTitle(translated);
                } else {
                    column.setTitle(labelKey);
                }
                column.setField(field.getName());
                column.setAlign(annotation.align());
                column.setSortable(annotation.sortable());
                // headerCellProps handling omitted for brevity
                columns.add(column);
            }
        }
        return columns;
    }
}