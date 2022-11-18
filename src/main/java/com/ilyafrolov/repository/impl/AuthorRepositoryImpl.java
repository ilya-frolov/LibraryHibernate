package com.ilyafrolov.repository.impl;

import com.ilyafrolov.repository.AuthorRepository;
import com.ilyafrolov.repository.SQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.ilyafrolov.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Repository
public final class AuthorRepositoryImpl implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper authorMapper;

    public void save(Author author) {
        jdbcTemplate.update(SQLQuery.SQL_INSERT_AUTHOR, author.getName());
    }

    public List<Author> getByName(Author author) {
        return jdbcTemplate.query(SQLQuery.SQL_GET_AUTHOR_BY_NAME, authorMapper, author.getName());
    }

    public List<Author> getById(Author author) {
        return jdbcTemplate.query(SQLQuery.SQL_GET_AUTHOR_BY_ID, authorMapper, author.getId());
    }

    public List<Author> getAll() {
        return jdbcTemplate.query(SQLQuery.SQL_GET_ALL_AUTHORS, authorMapper);
    }

    public void update(Author author) {
        jdbcTemplate.update(SQLQuery.SQL_UPDATE_AUTHOR_BY_ID, author.getName(), author.getId());
    }

    public void delete(Author author) {
        jdbcTemplate.update(SQLQuery.SQL_DELETE_AUTHOR_BY_NAME, author.getName());
    }
}

