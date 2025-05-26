package com.example.demo.datatablev2.impl;


import com.example.demo.datatablev2.TableBuilder;
import com.example.demo.datatablev2.dto.TableMetadata;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Component
public class DataTableBuilder {

    ApplicationContext applicationContext;

    TableBuilder tableBuilder;

    public DataTableBuilder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public TableMetadata buildTable(String yamlFilePath){

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(yamlFilePath)) {
            if (inputStream == null) {
                throw new RuntimeException("YAML file not found: " + yamlFilePath);
            }

            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = yaml.load(inputStream);

            String tableType = (String) yamlData.get("type");

            if(tableType == null) {
                throw new RuntimeException("Table Type is mandatory in YAML " + yamlFilePath);
            }

            TableBuilder tableBuilder = (TableBuilder) applicationContext.getBean(tableType);

            return tableBuilder.buildTable(yamlData);


        } catch (Exception e) {
            throw new RuntimeException("Failed to read YAML or resolve labels", e);
        }

    }

}
