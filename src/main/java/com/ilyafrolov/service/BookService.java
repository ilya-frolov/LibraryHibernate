package com.ilyafrolov.service;

import com.ilyafrolov.model.Book;

import java.util.List;

public interface BookService {

    void save(Book book);

    Book get(Book book);

    List<Book> getAll();

    void update(Book book);

    void delete(Book book);
}
