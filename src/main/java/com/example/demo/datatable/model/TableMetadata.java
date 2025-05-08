package com.example.demo.datatable.model;

import java.util.List;

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
