package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.repo.*;
import com.example.demo.repo.specification.InvoiceSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Page<Invoice> findAll(String searchKeyword,Pageable pageable) {
        if(searchKeyword == null || searchKeyword.isEmpty()){
            return invoiceRepository.findAll(pageable);
        }

        return invoiceRepository.findAll(InvoiceSpecifications.containsInAllStringFields(searchKeyword), pageable);
    }

    public List<Invoice> findAll() {

        return invoiceRepository.findAll();

//        return invoiceRepository.findAll(InvoiceSpecifications.containsInAllStringFields(keyword), pageable);
    }
}
