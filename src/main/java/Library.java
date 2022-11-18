import model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.impl.BookServiceImpl;

public class Library {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("repository.impl", "service.impl");
        BookServiceImpl bookService = context.getBean(BookServiceImpl.class);

        for (int i = 1; i < 4; i++) {
            Book book = new Book(i, "book title" + i,
                    new Author(i, "book author" + i), new Genre(i, "book genre" + i));

            bookService.save(book);
        }

        System.out.println(bookService.getAll());
    }



}
