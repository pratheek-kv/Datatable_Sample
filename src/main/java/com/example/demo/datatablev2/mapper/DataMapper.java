package com.example.demo.datatablev2.mapper;


import java.util.Locale;

public interface DataMapper<T, D> {
    D mapToDTO(T entity, Locale locale);
}