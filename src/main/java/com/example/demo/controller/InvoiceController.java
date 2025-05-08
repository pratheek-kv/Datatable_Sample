package com.example.demo.controller;

import com.example.demo.datatable.model.TableMetadata;
import com.example.demo.datatable.impl.DataTableBuilder;
import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    private DataTableBuilder dataTableBuilder;

    InvoiceService invoiceService;

    public InvoiceController(DataTableBuilder dataTableBuilder, InvoiceService invoiceService) {
        this.dataTableBuilder = dataTableBuilder;
        this.invoiceService = invoiceService;
    }

    @PostMapping("/search_invoice_table")
    public Page<Invoice> handlePost(@RequestBody(required = false) InvoiceRequestDTO request) {
       return invoiceService.findAll(request.getSearch(),PageRequest.of(request.getCurrentPage() - 1,request.getRowsPerPage()));
    }

    @GetMapping("/search_invoice_table")
    public TableMetadata handleGet() {
        return dataTableBuilder.buildTable("DataTableMetaModel/Invoice.yaml");
    }
}
