package com.bookstore.dto;

public record SearchBookParameters(
        String[] titlePart,
        String[] authors
) {
}
