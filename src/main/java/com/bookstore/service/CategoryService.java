package com.bookstore.service;

import com.bookstore.dto.book.BookDtoWithoutCategoryIds;
import com.bookstore.dto.category.CreateCategoryDto;
import com.bookstore.dto.category.ResponseCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<ResponseCategoryDto> findAll(Pageable pageable);

    ResponseCategoryDto getById(Long id);

    ResponseCategoryDto save(CreateCategoryDto createCategoryDto);

    ResponseCategoryDto update(Long id, CreateCategoryDto createCategoryDto);

    void deleteById(Long id);

    Page<BookDtoWithoutCategoryIds> getBooksByCategoryId(Pageable pageable, Long categoryId);
}
