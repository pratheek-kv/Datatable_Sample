package com.example.demo.datatablev2;

import com.example.demo.datatablev2.dto.TableMetadata;
import com.example.demo.datatablev2.dto.fields.ColumnDetails;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.*;

public abstract class TableBuilder {

    protected final MessageSource messageSource;

    public TableBuilder(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public abstract TableMetadata buildTable(Map<String, Object> yamlData);

   protected List<ColumnDetails> getColumns(List<Map<String, Object>> fields) {
       ArrayList<ColumnDetails> columnDetailsList = new ArrayList<>();
       Locale locale = LocaleContextHolder.getLocale();


       for (Map<String, Object> field : fields) {
           ColumnDetails column = new ColumnDetails();
           String labelKey = (String) field.get("label");
           if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
               String extracted = labelKey.substring(1, labelKey.length() - 1);
               String translated = messageSource.getMessage(extracted, null, extracted, locale);
               column.setTitle(translated);
           }else{
               column.setTitle(labelKey);
           }

           column.setField((String) field.get("name"));
           column.setAlign((String) field.get("align"));
           boolean sortable = Optional.ofNullable((Boolean) field.get("sortable")).orElse(false);
           column.setSortable(sortable);



           column.setHeaderCellProps((Map<String, String>)field.get("headerCellProps"));
           columnDetailsList.add(column);
       }


       return columnDetailsList;
   }
}
