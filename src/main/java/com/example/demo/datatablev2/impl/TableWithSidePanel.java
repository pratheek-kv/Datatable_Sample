package com.example.demo.datatablev2.impl;

import com.example.demo.datatablev2.TableBuilder;
import com.example.demo.datatablev2.dto.TableMetadata;
import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.impl.toolbar.ToolbarActionResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("tableWithSidePanel")
public class TableWithSidePanel extends TableBuilder {

    private final ApplicationContext applicationContext;

    public TableWithSidePanel(MessageSource messageSource, ApplicationContext applicationContext) {
        super(messageSource);
        this.applicationContext = applicationContext;
    }


    @Override
    public TableMetadata buildTable(Map<String, Object> yamlData) {
        TableMetadata tableMetadata = new TableMetadata();
        List<Map<String, Object>> fields = (List<Map<String, Object>>) yamlData.get("fields");

        tableMetadata.setColumns(this.getColumns(fields));

        List<Map<String, Object>> toolbarActions = (List<Map<String, Object>>) yamlData.get("toolbarActions");

        List<ToolbarAction> toolbarActionList = new ArrayList<>();
        for (Map<String, Object> toolbarAction : toolbarActions) {
            try {
                ToolbarActionResolver toolbarResolver = applicationContext.getBean((String) toolbarAction.get("actionType"), ToolbarActionResolver.class);
                toolbarActionList.add(toolbarResolver.resolveAction(toolbarAction));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        tableMetadata.setToolbarActions(toolbarActionList);

        return tableMetadata;
    }
}
