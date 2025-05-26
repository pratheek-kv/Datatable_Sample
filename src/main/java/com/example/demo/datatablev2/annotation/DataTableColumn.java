package com.example.demo.datatablev2.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataTableColumn {
    String label();
    String align() default "left";
    boolean sortable() default false;
    String[] headerCellProps() default {};
}
