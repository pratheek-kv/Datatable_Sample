package com.example.demo.datatablev2.impl.toolbar;

import com.example.demo.datatablev2.constants.ActionToolbarConstants;
import com.example.demo.datatablev2.dto.toolbaractions.ToolbarAction;
import com.example.demo.datatablev2.dto.toolbaractions.advancedsearch.*;
import com.example.demo.datatablev2.enums.FieldType;
import com.example.demo.datatablev2.utils.StringUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


import java.util.*;

@Component("ADVANCED_SEARCH")
public class AdvancedSearchActionResolver implements ToolbarActionResolver{
    private final MessageSource messageSource;

    public AdvancedSearchActionResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public ToolbarAction resolveAction(Map<String, Object> action) {
        AdvancedSearch advancedSearch = new AdvancedSearch();
        advancedSearch.setEnableAddOnlyOnLastRow((Boolean) action.get(ActionToolbarConstants.ENABLE_ADD_ONLY_ON_LAST_ROW));
        advancedSearch.setEnableGrouping((Boolean) action.get(ActionToolbarConstants.ENABLE_GROUPING));
        advancedSearch.setEnableMatching((Boolean) action.get(ActionToolbarConstants.ENABLE_MATCHING));
        advancedSearch.setMaxGroups((Integer) action.get(ActionToolbarConstants.MAX_GROUPS));

        CommonCondition commonConditions = extractCommonConditions((List<Map<String, Object>>) action.get(ActionToolbarConstants.COMMON_CONDITIONS));


        advancedSearch.setCommonConditions(commonConditions);
        FilterByCondition filterByCondition = extractFilterByCondition((Map<String, Object>) action.get(ActionToolbarConstants.FILTER_BY_CONDITION));
        advancedSearch.setFilterByCondition(filterByCondition);

        return advancedSearch;
    }

    private CommonCondition extractCommonConditions(List<Map<String,Object>> conditions){
        if(conditions == null || conditions.isEmpty()){
            return null;
        }
        CommonCondition commonCondition = new CommonCondition();
        for (Map<String, Object> condition : conditions) {
            String key = (String) condition.get(ActionToolbarConstants.NAME);
            RelatedField relatedField = new RelatedField();
            relatedField.setEnableFreeForm((Boolean) condition.get(ActionToolbarConstants.ENABLE_FREE_FORM));

            String labelKey = (String) condition.get(ActionToolbarConstants.FIELD_LABEL);
            relatedField.setFieldLabel(StringUtil.getStringOrDefault(labelKey, messageSource));

            relatedField.setFieldName((String) condition.get(ActionToolbarConstants.FIELD_NAME));
            relatedField.setFieldType(FieldType.fromString((String) condition.get(ActionToolbarConstants.FIELD_TYPE)));
            relatedField.setLookupUrl((String) condition.get(ActionToolbarConstants.LOOKUP_URL));
            relatedField.setDefaultOption((String) condition.get(ActionToolbarConstants.DEFAULT_OPTION));
            relatedField.setFieldOptions(extractFieldOptions((List<Map<String,Object>>) condition.get(ActionToolbarConstants.FIELD_OPTIONS)));
            commonCondition.addClause(key, relatedField);
        }
        return commonCondition;
    }

    private FilterByCondition extractFilterByCondition(Map<String,Object> filterCondition){
        FilterByCondition filterByCondition = new FilterByCondition();

        filterByCondition.setDefaultOption(filterCondition.get(ActionToolbarConstants.DEFAULT_OPTION).toString());

        String labelKey = (String) filterCondition.get(ActionToolbarConstants.FIELD_LABEL);
        filterByCondition.setFieldLabel(StringUtil.getStringOrDefault(labelKey, messageSource));

        filterByCondition.setFieldName((String) filterCondition.get(ActionToolbarConstants.FIELD_NAME));
        filterByCondition.setFieldType(FieldType.fromString((String) filterCondition.get(ActionToolbarConstants.FIELD_TYPE)));

        filterByCondition.setFieldOptions(extractFieldOptions((List<Map<String,Object>>) filterCondition.get(ActionToolbarConstants.FIELD_OPTIONS)));
        return filterByCondition;
    }

    private List<FieldOption> extractFieldOptions(List<Map<String,Object>> fieldOptions){
        List<FieldOption> fieldOptionList = new ArrayList<>();
        for (Map<String, Object> fieldOption : fieldOptions) {
            FieldOption option = new FieldOption();
            option.setId((String) fieldOption.get(ActionToolbarConstants.ID));
            String name = StringUtil.getStringOrDefault((String) fieldOption.get(ActionToolbarConstants.NAME), messageSource);
            option.setName(name);

            List<RelatedField> relatedFields = new ArrayList<>();
            List<Map<String, Object>> relatedFieldList = (List<Map<String, Object>>) fieldOption.get(ActionToolbarConstants.RELATED_FIELDS);
           if(relatedFieldList != null) {
               for (Map<String, Object> relatedField : relatedFieldList) {
                   RelatedField rf = new RelatedField();
                   rf.setEnableFreeForm((Boolean) relatedField.get(ActionToolbarConstants.ENABLE_FREE_FORM));

                   String labelKey = (String) relatedField.get(ActionToolbarConstants.FIELD_LABEL);
                   rf.setFieldLabel(StringUtil.getStringOrDefault(labelKey, messageSource));

                   rf.setFieldName((String) relatedField.get(ActionToolbarConstants.FIELD_NAME));
                   rf.setFieldType(FieldType.fromString((String) relatedField.get(ActionToolbarConstants.FIELD_TYPE)));
                   rf.setLookupUrl((String) relatedField.get(ActionToolbarConstants.LOOKUP_URL));
                   rf.setDefaultOption((String) relatedField.get(ActionToolbarConstants.DEFAULT_OPTION));

                   if(relatedField.get(ActionToolbarConstants.FIELD_OPTIONS) != null) {
                       List<FieldOption> fo =   extractFieldOptions((List<Map<String, Object>>) relatedField.get(ActionToolbarConstants.FIELD_OPTIONS));
                       rf.setFieldOptions(fo);
                   }
                   relatedFields.add(rf);
               }
               option.setRelatedFields(relatedFields);
           }
            fieldOptionList.add(option);
        }
        return fieldOptionList;
    }

}
