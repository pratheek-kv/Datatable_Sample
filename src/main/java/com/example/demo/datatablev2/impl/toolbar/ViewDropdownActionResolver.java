package com.example.demo.datatablev2.impl.toolbar;

import com.example.demo.datatablev2.constants.ActionToolbarConstants;
import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.dto.toolbaractions.viewdropdown.Props;
import com.example.demo.datatablev2.dto.toolbaractions.viewdropdown.SelectOption;
import com.example.demo.datatablev2.dto.toolbaractions.viewdropdown.ViewDropdown;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("VIEW_DROPDOWN")
public class ViewDropdownActionResolver implements  ToolbarActionResolver{
    @Override
    public ToolbarAction resolveAction(Map<String, Object> action) {
        ViewDropdown viewdropdown = new ViewDropdown();
        Map<String, Object> actionProps = (Map<String, Object>) action.get(ActionToolbarConstants.PROPS);
        Props props = new Props();
        props.setAllowCreate((Boolean) actionProps.get(ActionToolbarConstants.ALLOW_CREATE));
        props.setCreateViewUrl((String) actionProps.get(ActionToolbarConstants.CREATE_VIEW_URL));
        props.setEditViewUrl((String) actionProps.get(ActionToolbarConstants.EDIT_VIEW_URL));
        props.setRecordExistsUrl((String) actionProps.get(ActionToolbarConstants.RECORD_EXISTS_URL));
        props.setSelectOptions((List<SelectOption>) actionProps.get(ActionToolbarConstants.SELECT_OPTIONS));

        viewdropdown.setProps(props);

        return viewdropdown;
    }
}
