package com.bookstore.dto.book;

public record SearchBookParameters(
        String[] titles,
        String[] authors
) {
}
