package com.ilyafrolov.repository.impl;

import com.ilyafrolov.repository.SQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.ilyafrolov.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ilyafrolov.repository.GenreRepository;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Repository
public final class GenreRepositoryImpl implements GenreRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper genreMapper;

    public void save(Genre genre) {
        jdbcTemplate.update(SQLQuery.SQL_INSERT_GENRE, genre.getName());
    }

    public List<Genre> getByName(Genre genre) {
        return jdbcTemplate.query(SQLQuery.SQL_GET_GENRE_BY_NAME, genreMapper, genre.getName());
    }

    public List<Genre> getById(Genre genre) {
        return jdbcTemplate.query(SQLQuery.SQL_GET_GENRE_BY_ID, genreMapper, genre.getId());
    }

    public List<Genre> getAll() {
        return jdbcTemplate.query(SQLQuery.SQL_GET_ALL_GENRES, genreMapper);
    }

    public void update(Genre genre) {
        jdbcTemplate.update(SQLQuery.SQL_UPDATE_GENRE_BY_ID, genre.getName(), genre.getId());
    }

    public void delete(Genre genre) {
        jdbcTemplate.update(SQLQuery.SQL_DELETE_GENRE_BY_NAME, genre.getName());
    }
}
