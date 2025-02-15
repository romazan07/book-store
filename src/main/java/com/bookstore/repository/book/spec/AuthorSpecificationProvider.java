package com.bookstore.repository.book.spec;

import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    private static final String AUTHOR_FIELD = "author";
    private static final String AUTHOR_SPEC_KEY = "author";

    @Override
    public String getKey() {
        return AUTHOR_SPEC_KEY;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(AUTHOR_FIELD).in(Arrays.stream(params).toArray());
    }
}
