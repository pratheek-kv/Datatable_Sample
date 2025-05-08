package com.example.demo.datatable.model;

import java.util.Map;

public class ColumnDetails {

    private String field;
    private Map<String, String> headerCellProps;
    private boolean sortable;
    private String title;
    private String align;

    public ColumnDetails(String field, Map<String, String> headerCellProps, boolean sortable, String title, String align) {
        this.field = field;
        this.headerCellProps = headerCellProps;
        this.sortable = sortable;
        this.title = title;
        this.align = align;
    }

    public ColumnDetails() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Map<String, String> getHeaderCellProps() {
        return headerCellProps;
    }

    public void setHeaderCellProps(Map<String, String> headerCellProps) {
        this.headerCellProps = headerCellProps;
    }

    public boolean isSortable() {
        return sortable;
    }

    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}
