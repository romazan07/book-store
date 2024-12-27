package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    List<BookDto> findByTitle(String title);

    void deleteById(Long id);

    BookDto update(Long id, CreateBookRequestDto bookRequestDto);
}
