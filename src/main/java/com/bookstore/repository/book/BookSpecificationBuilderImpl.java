package com.bookstore.repository.book;

import com.bookstore.dto.SearchBookParameters;
import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilderImpl implements SpecificationBuilder<Book> {
    private static final String AUTHOR_KEY = "author";
    private static final String TITLE_KEY = "title";
    private final BookSpecificationProviderManagerImpl bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(SearchBookParameters searchBookParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchBookParameters.authors() != null && searchBookParameters.authors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR_KEY)
                    .getSpecification(searchBookParameters.authors()));
        }
        if (searchBookParameters.titles() != null
                && searchBookParameters.titles().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(TITLE_KEY)
                    .getSpecification(searchBookParameters.titles()));
        }
        return spec;
    }
}
