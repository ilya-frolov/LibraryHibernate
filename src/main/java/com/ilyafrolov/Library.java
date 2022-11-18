package com.ilyafrolov;

import com.ilyafrolov.model.Author;
import com.ilyafrolov.model.Book;
import com.ilyafrolov.model.Genre;
import com.ilyafrolov.repository.impl.AuthorRepositoryImpl;
import com.ilyafrolov.service.impl.BookServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Library {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ilyafrolov");

//        AuthorRepositoryImpl authorRepository = context.getBean(AuthorRepositoryImpl.class);
//        Author author = new Author();
//        author.setName("author 4");
//        author.setId(2);
//        authorRepository.delete(author);
//
//        List<Author> authors = authorRepository.getAll();
//        System.out.println(authors);

        BookServiceImpl bookService = context.getBean(BookServiceImpl.class);

        for (int i = 1; i < 4; i++) {
            Book book = new Book(i, "book title" + i,
                    new Author(i, "book author" + i), new Genre(i, "book genre" + i));

            bookService.save(book);
        }

        System.out.println(bookService.getAll());
    }



}
