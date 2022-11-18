package com.ilyafrolov.service.impl;

import com.ilyafrolov.service.GenreService;
import com.ilyafrolov.model.Genre;
import com.ilyafrolov.repository.GenreRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void save(Genre genre) {

        if (genreRepository.getByName(genre) == null) {
            genreRepository.save(genre);
        }
    }

    public Genre get(Genre genre) {
        Genre g = new Genre();
        return g = genreRepository.getByName(genre).stream().findFirst().orElse(null);
    }
}
