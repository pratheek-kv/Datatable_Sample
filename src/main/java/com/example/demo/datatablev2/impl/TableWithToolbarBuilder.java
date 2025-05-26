package com.example.demo.datatablev2.impl;

import com.example.demo.datatablev2.TableBuilder;
import com.example.demo.datatablev2.dto.TableMetadata;
import com.example.demo.datatablev2.dto.fields.ColumnDetails;
import com.example.demo.datatablev2.enums.ActionType;
import com.example.demo.datatablev2.impl.toolbar.ToolbarActionResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("tableWithToolbar")
public class TableWithToolbarBuilder extends TableBuilder {

    private final ApplicationContext applicationContext;

    public TableWithToolbarBuilder(MessageSource messageSource, ApplicationContext applicationContext) {
        super(messageSource);
        this.applicationContext = applicationContext;
    }


    public TableMetadata buildTable(Map<String, Object> yamlData) {
        TableMetadata tableMetadata = new TableMetadata();
        List<Map<String, Object>> fields = (List<Map<String, Object>>) yamlData.get("fields");

        tableMetadata.setColumns(this.getColumns(fields));

        List<Map<String, Object>> toolbarActions = (List<Map<String, Object>>) yamlData.get("toolbarActions");

        if(toolbarActions != null && !toolbarActions.isEmpty()) {
            for(Map<String, Object> toolbarAction : toolbarActions) {
                String actionTypeString = (String) toolbarAction.get("actionType");
                ToolbarActionResolver actionResolver = applicationContext.getBean(actionTypeString, ToolbarActionResolver.class);

            }
        }

        return tableMetadata;
    }





//    private List<ToolbarAction> getToolbarActions(List<Map<String, Object>> toolbarActions) {
//        List<ToolbarAction> toolbarActionsList = new ArrayList<>();
//        for (Map<String, Object> action : toolbarActions) {
//            ToolbarAction toolbarAction = new ToolbarAction() {
//            };
//            toolbarAction.setActionType((String) action.get("actionType"));
//            toolbarAction.setEnableGrouping((Boolean) action.get("enableGrouping"));
//            toolbarAction.setEnableMatching((Boolean) action.get("enableMatching"));
//            toolbarAction.setFilterByCondition((Map<String, Object>) action.get("filterByCondition"));
//            toolbarActionsList.add(toolbarAction);
//        }
//        return toolbarActionsList;
//    }

}