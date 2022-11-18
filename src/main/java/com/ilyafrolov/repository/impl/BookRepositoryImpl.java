package com.ilyafrolov.repository.impl;

import com.ilyafrolov.repository.SQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.ilyafrolov.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ilyafrolov.repository.BookRepository;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Repository
public final class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> bookMapper;

    public void save(Book book) {
        jdbcTemplate.update(SQLQuery.SQL_INSERT_BOOK, book.getTitle(), book.getAuthor().getId(), book.getGenre().getId());
    }

    public List<Book> get(Book book) {
        return jdbcTemplate.query(SQLQuery.SQL_GET_BOOK_BY_NAME, bookMapper, book.getTitle());
    }

    public List<Book> getAll() {
        return jdbcTemplate.query(SQLQuery.SQL_GET_ALL_BOOKS, bookMapper);
    }

    public void update(Book book) {
        jdbcTemplate.update(SQLQuery.SQL_UPDATE_BOOK_BY_NAME, book.getTitle(), book.getAuthor().getId(),
                book.getGenre().getId(), book.getId());
    }

    public void delete(Book book) {
        jdbcTemplate.update(SQLQuery.SQL_DELETE_BOOK_BY_NAME, book.getTitle());
    }
}
