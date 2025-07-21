package com.bookstore.dto.category;

public record ResponseCategoryDto(
        Long id,
        String name,
        String description
) {
}
