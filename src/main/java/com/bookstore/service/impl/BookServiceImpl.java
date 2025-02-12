package com.bookstore.service.impl;

import com.bookstore.dto.BookDto;
import com.bookstore.dto.CreateBookRequestDto;
import com.bookstore.dto.SearchBookParameters;
import com.bookstore.exception.EntityNotFoundException;
import com.bookstore.mapper.BookMapper;
import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationBuilder;
import com.bookstore.repository.book.BookRepository;
import com.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final SpecificationBuilder<Book> bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book", id)));
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return bookRepository.findByTitle(title).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto bookRequestDto) {
        bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book", id));
        Book book = bookMapper.toModel(bookRequestDto);
        book.setId(id);
        Book updateBook = bookRepository.save(book);
        return bookMapper.toDto(updateBook);
    }

    @Override
    public List<BookDto> search(SearchBookParameters searchBookParameters) {
        Specification<Book> spec = bookSpecificationBuilder.build(searchBookParameters);
        return bookRepository.findAll(spec).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
