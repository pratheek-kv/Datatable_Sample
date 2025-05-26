package com.example.demo.datatablev2.dto.toolbaractions;

import com.example.demo.datatablev2.enums.ActionType;

public abstract class ToolbarAction {

    ActionType actionType;

    public ToolbarAction(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }


}
