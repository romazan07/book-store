package com.bookstore.repository.book;

import com.bookstore.model.Book;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Collection<Book> findByTitle(String title);

    Page<Book> findAllByCategoriesId(Pageable pageable, Long categoryId);
}
