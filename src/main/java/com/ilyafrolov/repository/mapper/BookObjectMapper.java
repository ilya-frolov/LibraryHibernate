package com.ilyafrolov.repository.mapper;

import com.ilyafrolov.model.Author;
import com.ilyafrolov.model.Book;
import com.ilyafrolov.model.Genre;
import com.ilyafrolov.repository.AuthorRepository;
import com.ilyafrolov.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Component("bookMapper")
public class BookObjectMapper implements RowMapper<Book> {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book mapRow(ResultSet rs, int row) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        Author author = new Author();
        author.setId(rs.getInt("author_id"));
        book.setAuthor(authorRepository.getById(author).stream().findFirst().get());
        Genre genre = new Genre();
        genre.setId(rs.getInt("author_id"));
        book.setGenre(genreRepository.getById(genre).stream().findFirst().get());
        return book;
    }
}
