package com.example.demo.datatablev2.dto.filtercriteria;


import com.example.demo.datatablev2.serializers.AdvancedFilterValueDeserializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedSearch {
    private String filterBy;
    private String filterClause;
    @JsonDeserialize(using = AdvancedFilterValueDeserializer.class)
    private FilterValue filterValue;

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public String getFilterClause() {
        return filterClause;
    }

    public void setFilterClause(String filterClause) {
        this.filterClause = filterClause;
    }

    public FilterValue getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(FilterValue filterValue) {
        this.filterValue = filterValue;
    }
}
