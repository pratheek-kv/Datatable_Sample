package com.example.demo.datatable;

import com.example.demo.datatable.model.TableMetadata;

import java.util.Map;

public interface TableBuilder {

     TableMetadata buildTable(Map<String, Object> yamlData);
}
