package com.ilyafrolov.repository;

import com.ilyafrolov.model.Genre;

import java.util.List;

public interface GenreRepository {

    void save(Genre genre);

    List<Genre> getByName(Genre genre);

    List<Genre> getById(Genre genre);

    List<Genre> getAll();

    void update(Genre genre);

    void delete(Genre genre);
}
