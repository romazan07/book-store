package mate.academy.bookstore;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreApplication {
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("BookOne");
            book.setAuthor("Author 1");
            book.setIsbn("0123456789");
            book.setPrice(BigDecimal.TEN);

            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}
