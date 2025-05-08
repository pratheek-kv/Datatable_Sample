package com.example.demo.repo.specification;

import com.example.demo.model.Invoice;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class InvoiceSpecifications {

    public static Specification<Invoice> containsInAllStringFields(String keyword) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Field field : Invoice.class.getDeclaredFields()) {
                if (field.getType().equals(String.class)) {
                    predicates.add(cb.like(cb.lower(root.get(field.getName())), "%" + keyword.toLowerCase() + "%"));
                }
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }
}
