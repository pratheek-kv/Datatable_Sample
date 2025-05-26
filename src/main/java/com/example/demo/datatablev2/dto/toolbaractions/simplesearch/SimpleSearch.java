package com.example.demo.datatablev2.dto.toolbaractions.simplesearch;

import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleSearch extends ToolbarAction {
    public SimpleSearch() {
        super(ActionType.SIMPLE_SEARCH);
    }
}
