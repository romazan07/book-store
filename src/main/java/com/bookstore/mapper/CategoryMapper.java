package com.bookstore.mapper;

import com.bookstore.config.MapperConfig;
import com.bookstore.dto.category.CreateCategoryDto;
import com.bookstore.dto.category.ResponseCategoryDto;
import com.bookstore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    ResponseCategoryDto toDto(Category category);

    Category toEntity(CreateCategoryDto createCategoryDto);

    void updateCategoryFromDb(
            CreateCategoryDto categoryRequestDto,
            @MappingTarget Category category
    );
}
