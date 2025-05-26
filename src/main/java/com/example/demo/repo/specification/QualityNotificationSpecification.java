package com.example.demo.repo.specification;


import com.example.demo.datatablev2.dto.filtercriteria.AdvancedSearch;
import com.example.demo.datatablev2.dto.filtercriteria.FilterCriteria;
import com.example.demo.datatablev2.dto.toolbaractions.advancedsearch.FilterByCondition;
import com.example.demo.model.QualityNotification;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class QualityNotificationSpecification implements SpecificationBuilder<QualityNotification> {

    @Override
    public Specification<QualityNotification> containsInAllStringFields(String keyword) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Field field : QualityNotification.class.getDeclaredFields()) {
                if (field.getType().equals(String.class)) {
                    predicates.add(cb.like(cb.lower(root.get(field.getName())), "%" + keyword.toLowerCase() + "%"));
                }
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public Specification<QualityNotification> fromAdvancedSearch(FilterCriteria dto) {
        List<List<AdvancedSearch>> groups = dto.getAdvancedSearch();
        boolean outerIsOr = "all".equalsIgnoreCase(dto.getMatchBy());

        Specification<QualityNotification> finalSpec = null;

        for (List<AdvancedSearch> group : groups) {
            Specification<QualityNotification> groupSpec = null;

            for (AdvancedSearch filter : group) {
                Specification<QualityNotification> spec = getFilterSpecification(filter);

                groupSpec = (groupSpec == null) ? spec : groupSpec.and(spec);
            }

            finalSpec = (finalSpec == null)
                    ? groupSpec
                    : (outerIsOr ? finalSpec.or(groupSpec) : finalSpec.and(groupSpec));
        }

        return finalSpec;
    }

    private static Specification<QualityNotification> getFilterSpecification(AdvancedSearch filter) {
        return (root, query, cb) -> {
            Path<String> path = root.get(filter.getFilterBy());
            String value = filter.getFilterValue().getId();

            return switch (filter.getFilterClause()) {
                case "eq" -> cb.equal(path, value);
                case "ne" -> cb.notEqual(path, value);
                case "like" -> cb.like(path, "%" + value + "%");
                case "gt" -> cb.greaterThan(path, value);
                case "lt" -> cb.lessThan(path, value);
                // Add more operators as needed
                default -> null;
            };
        };
    }
}
