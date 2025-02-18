package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.dto.CreateBookRequestDto;
import com.bookstore.dto.SearchBookParameters;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    List<BookDto> findByTitle(String title);

    BookDto update(Long id, CreateBookRequestDto bookRequestDto);

    List<BookDto> search(SearchBookParameters searchBookParameters);

    void deleteById(Long id);
}
