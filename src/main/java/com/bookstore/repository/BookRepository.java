package com.bookstore.repository;

import com.bookstore.model.Book;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Collection<Book> findByTitle(String title);
}
