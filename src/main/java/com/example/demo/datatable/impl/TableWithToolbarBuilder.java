package com.example.demo.datatable.impl;

import com.example.demo.datatable.TableBuilder;
import com.example.demo.datatable.model.ColumnDetails;
import com.example.demo.datatable.model.TableMetadata;
import com.example.demo.datatable.model.ToolbarAction;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.*;


@Component("tableWithToolbar")
public class TableWithToolbarBuilder implements TableBuilder {

    private MessageSource messageSource;

    public TableWithToolbarBuilder(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public TableMetadata buildTable(Map<String, Object> yamlData) {
        TableMetadata tableMetadata = new TableMetadata();
        List<Map<String, Object>> fields = (List<Map<String, Object>>) yamlData.get("fields");

        tableMetadata.setColumns(this.getColumns(fields));

        List<Map<String, Object>> toolbarActions = (List<Map<String, Object>>) yamlData.get("toolbarActions");

        if(toolbarActions != null && !toolbarActions.isEmpty()) {
            tableMetadata.setToolbarActions(this.getToolbarActions(toolbarActions));
        }

        return tableMetadata;
    }


    private List<ColumnDetails> getColumns(List<Map<String, Object>> fields) {
        ArrayList<ColumnDetails> columnDetailsList = new ArrayList<>();
        Locale locale = LocaleContextHolder.getLocale();


        for (Map<String, Object> field : fields) {
            ColumnDetails column = new ColumnDetails();
            String labelKey = (String) field.get("label");
            if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
                String extracted = labelKey.substring(1, labelKey.length() - 1);
                String translated = messageSource.getMessage(extracted, null, extracted, locale);
                column.setTitle(translated);
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


    private List<ToolbarAction> getToolbarActions(List<Map<String, Object>> toolbarActions) {
        List<ToolbarAction> toolbarActionsList = new ArrayList<>();
        for (Map<String, Object> action : toolbarActions) {
            ToolbarAction toolbarAction = new ToolbarAction();
            toolbarAction.setActionType((String) action.get("actionType"));
            toolbarActionsList.add(toolbarAction);
        }
        return toolbarActionsList;
    }

}
