package com.bookstore.repository.book;

import com.bookstore.dto.SearchBookParameters;
import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilderImpl implements SpecificationBuilder<Book> {
    private final BookSpecificationProviderManagerImpl bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(SearchBookParameters searchBookParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchBookParameters.authors() != null && searchBookParameters.authors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(searchBookParameters.authors()));
        }
        if (searchBookParameters.titlePart() != null
                && searchBookParameters.titlePart().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("title")
                    .getSpecification(searchBookParameters.titlePart()));
        }
        return spec;
    }
}
