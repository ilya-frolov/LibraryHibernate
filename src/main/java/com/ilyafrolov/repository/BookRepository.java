package com.ilyafrolov.repository;

import com.ilyafrolov.model.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository {

    void save(Book book);

    List<Book> get(Book book);

    List<Book> getAll();

    void update(Book book);

    void delete(Book book);
}
