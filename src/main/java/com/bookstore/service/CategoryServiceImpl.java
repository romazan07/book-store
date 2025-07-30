package com.bookstore.service;

import com.bookstore.dto.book.BookDtoWithoutCategoryIds;
import com.bookstore.dto.category.CreateCategoryDto;
import com.bookstore.dto.category.ResponseCategoryDto;
import com.bookstore.exception.EntityNotFoundException;
import com.bookstore.mapper.BookMapper;
import com.bookstore.mapper.CategoryMapper;
import com.bookstore.model.Category;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Page<ResponseCategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public ResponseCategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found entity by id " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public ResponseCategoryDto save(CreateCategoryDto createCategoryDto) {
        Category savedCategory =
                categoryRepository.save(categoryMapper.toEntity(createCategoryDto));
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public ResponseCategoryDto update(Long id, CreateCategoryDto createCategoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found category by id " + id));
        categoryMapper.updateCategoryFromDb(createCategoryDto, category);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<BookDtoWithoutCategoryIds> getBooksByCategoryId(
            Pageable pageable,
            Long categoryId
    ) {
        return bookRepository.findAllByCategoriesId(pageable, categoryId)
                .map(bookMapper::toDtoWithoutCategories);
    }
}
