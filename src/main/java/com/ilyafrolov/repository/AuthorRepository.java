package com.ilyafrolov.repository;

import com.ilyafrolov.model.Author;

import java.util.List;

public interface AuthorRepository {

    void save(Author author);

    List<Author> getByName(Author author);

    List<Author> getById(Author author);

    List<Author> getAll();

    void update(Author author);

    void delete(Author author);
}
