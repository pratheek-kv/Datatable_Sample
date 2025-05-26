package com.example.demo.datatablev2.dto.toolbaractions.viewdropdown;

import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewDropdown extends ToolbarAction {

    private Props props;

    public ViewDropdown( ) {
        super(ActionType.VIEW_DROPDOWN);
    }

    public ViewDropdown(Props props) {
        super(ActionType.VIEW_DROPDOWN);
        this.props = props;
    }

    public Props getProps() {
        return props;
    }

    public void setProps(Props props) {
        this.props = props;
    }
}
