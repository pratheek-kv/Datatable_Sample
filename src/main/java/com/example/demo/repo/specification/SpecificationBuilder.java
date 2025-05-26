package com.example.demo.repo.specification;


import com.example.demo.datatablev2.dto.filtercriteria.FilterCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {

    Specification<T> containsInAllStringFields(String keyword);

    Specification<T> fromAdvancedSearch(FilterCriteria dto);
}
