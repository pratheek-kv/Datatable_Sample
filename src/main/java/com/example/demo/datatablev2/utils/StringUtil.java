package com.example.demo.datatablev2.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class StringUtil {
    public static String getStringOrDefault(String labelKey, MessageSource messageSource) {
        if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
            String extracted = labelKey.substring(1, labelKey.length() - 1);
            String translated = messageSource.getMessage(extracted, null, extracted, LocaleContextHolder.getLocale());
            return translated;
        }
         return labelKey;
    }
}
