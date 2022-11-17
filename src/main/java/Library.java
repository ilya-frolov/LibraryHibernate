import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.GenreRepository;
import repository.impl.AuthorRepositoryImpl;
import repository.impl.BookRepositoryImpl;
import repository.impl.GenreRepositoryImpl;
import service.AuthorService;
import service.BookService;
import service.GenreService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.GenreServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    public static void main(String[] args) {

        //Standard method
//        BookService bookService = new BookServiceImpl(new BookRepositoryImpl(),
//                new AuthorServiceImpl(new AuthorRepositoryImpl()),
//                new GenreServiceImpl(new GenreRepositoryImpl()));
//
//        for (int i = 1; i < 4; i++) {
//            Book book = new Book(i, "book title" + i,
//                    new Author(i, "book author" + i), new Genre(i, "book genre" + i));
//
//            bookService.save(book);
//        }
//
//        System.out.println(bookService.getAll());

        //1,2,3. Spring with config file
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.config.xml");
//        BookServiceImpl bookService = context.getBean(BookServiceImpl.class);
//
//        for (int i = 1; i < 4; i++) {
//            Book book = new Book(i, "book title" + i,
//                    new Author(i, "book author" + i), new Genre(i, "book genre" + i));
//
//            bookService.save(book);
//        }
//
//        System.out.println(bookService.getAll());

        //4. Spring without Config file
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
