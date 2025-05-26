package com.example.demo.datatablev2.impl.toolbar;

import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;

import java.util.Map;

public interface ToolbarActionResolver {

    ToolbarAction resolveAction(Map<String, Object> action);
}
