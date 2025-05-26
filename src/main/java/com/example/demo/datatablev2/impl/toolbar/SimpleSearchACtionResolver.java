package com.example.demo.datatablev2.impl.toolbar;

import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.dto.toolbaractions.simplesearch.SimpleSearch;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("SIMPLE_SEARCH")
public class SimpleSearchACtionResolver implements ToolbarActionResolver{
    @Override
    public ToolbarAction resolveAction(Map<String, Object> action) {
        return new SimpleSearch();
    }
}
