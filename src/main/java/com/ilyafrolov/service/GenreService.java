package com.ilyafrolov.service;

import com.ilyafrolov.model.Genre;

import java.util.List;

public interface GenreService {

    void save(Genre genre);

    Genre get(Genre genre);
}
