package com.example.demo.datatablev2.dto;

import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.dto.fields.ColumnDetails;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableMetadata {
    private List<ColumnDetails> columns;
    private List<ToolbarAction> toolbarActions;

    public TableMetadata() {
    }

    public List<ColumnDetails> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDetails> columns) {
        this.columns = columns;
    }

    public List<ToolbarAction> getToolbarActions() {
        return toolbarActions;
    }

    public void setToolbarActions(List<ToolbarAction> toolbarActions) {
        this.toolbarActions = toolbarActions;
    }
}
