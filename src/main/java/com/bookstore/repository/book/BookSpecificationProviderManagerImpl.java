package com.bookstore.repository.book;

import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationProvider;
import com.bookstore.repository.SpecificationProviderManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManagerImpl implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> specificationProviderList;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return specificationProviderList.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Can't find correct specification provider with key = " + key));
    }
}
