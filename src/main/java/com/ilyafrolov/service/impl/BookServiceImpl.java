package com.ilyafrolov.service.impl;

import com.ilyafrolov.service.AuthorService;
import com.ilyafrolov.service.BookService;
import com.ilyafrolov.service.GenreService;
import com.ilyafrolov.model.Book;
import com.ilyafrolov.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public final class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    public void save(Book book) {
        if (authorService.get(book.getAuthor()) == null) {
            authorService.save(book.getAuthor());
        }
        if (genreService.get(book.getGenre()) == null) {
            genreService.save(book.getGenre());
        }
        if (bookRepository.get(book).stream().findFirst().orElse(null) == null) {
            bookRepository.save(book);
        }
    }

    public Book get(Book book) {
        Book b = new Book();
        return b = bookRepository.get(book).stream().findFirst().orElse(null);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public void update(Book book) {
        if (get(book) != null) {
            bookRepository.update(book);
        }
    }

    public void delete(Book book) {
        if (get(book) != null) {
            bookRepository.delete(book);
        }
    }
}
