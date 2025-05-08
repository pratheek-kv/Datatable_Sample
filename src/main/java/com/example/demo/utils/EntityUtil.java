package com.example.demo.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityUtil {

    public static Map<String, Class<?>> getEntityFields(Class<?> entityClass) {
        Map<String, Class<?>> fieldsMap = new LinkedHashMap<>();

        for (Field field : entityClass.getDeclaredFields()) {
            fieldsMap.put(field.getName(), field.getType());
        }

        return fieldsMap;
    }
}
