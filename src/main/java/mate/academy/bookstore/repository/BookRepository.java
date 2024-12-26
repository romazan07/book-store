package mate.academy.bookstore.repository;

import java.util.Collection;
import mate.academy.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Collection<Book> findByTitle(String title);
}
