package com.bookstore.dto;

public record SearchBookParameters(
        String[] titles,
        String[] authors
) {
}
