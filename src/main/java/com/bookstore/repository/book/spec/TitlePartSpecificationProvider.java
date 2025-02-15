package com.bookstore.repository.book.spec;

import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationProvider;
import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitlePartSpecificationProvider implements SpecificationProvider<Book> {
    private static final String TITLE_FIELD = "title";
    private static final String TITLE_SPEC_KEY = "title";

    @Override
    public String getKey() {
        return TITLE_SPEC_KEY;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.or(Arrays.stream(params)
                        .map(p -> criteriaBuilder.like(root.get(TITLE_FIELD), "%" + p + "%"))
                        .toArray(Predicate[]::new));
    }
}
