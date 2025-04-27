package com.bookstore.repository;

import com.bookstore.dto.book.SearchBookParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(SearchBookParameters searchBookParameters);
}
