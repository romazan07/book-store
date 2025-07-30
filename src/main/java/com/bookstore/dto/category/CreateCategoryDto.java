package com.bookstore.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryDto(
        @NotBlank String name,
        String description
) {
}
