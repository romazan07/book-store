package com.bookstore.service;

import com.bookstore.dto.book.BookDto;
import com.bookstore.dto.book.CreateBookRequestDto;
import com.bookstore.dto.book.SearchBookParameters;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    List<BookDto> findByTitle(String title);

    BookDto update(Long id, CreateBookRequestDto bookRequestDto);

    List<BookDto> search(SearchBookParameters searchBookParameters);

    void deleteById(Long id);
}
