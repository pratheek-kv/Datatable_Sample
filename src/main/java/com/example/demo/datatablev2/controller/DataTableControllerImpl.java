package com.example.demo.datatablev2.controller;


import com.example.demo.datatablev2.AnnotationTableBuilder;
import com.example.demo.datatablev2.dto.TableMetadata;
import com.example.demo.datatablev2.dto.filtercriteria.FilterCriteria;
import com.example.demo.datatablev2.impl.DataTableBuilder;
import com.example.demo.datatablev2.mapper.DataMapper;
import com.example.demo.service.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.SecretKey;
import java.util.Locale;

public abstract class DataTableControllerImpl<T,D> {

    private final DataTableBuilder dataTableBuilder;
    private final String tableId;
    private final DataMapper dataMapper;

    AbstractService<T> baseService;
    ApplicationContext applicationContext;

    public DataTableControllerImpl(DataTableBuilder dataTableBuilder, AbstractService<T> baseService, String tableId, DataMapper mapper) {
        this.dataTableBuilder = dataTableBuilder;
        this.baseService = baseService;
        this.tableId = tableId;
        this.dataMapper = mapper;

    }

    @PostMapping("/search_table")
    public Page<D> handlePost(@RequestBody(required = false) FilterCriteria request) {

        Page<T> result = baseService.findAll(request);

        return (Page<D>) result.map(entity -> dataMapper.mapToDTO(entity, Locale.ENGLISH));
    }

    @GetMapping("/search_table")
    public TableMetadata handleGet() {
        return dataTableBuilder.buildTable("DataTableMetaModel/"+ tableId +".yaml");
    }
}
