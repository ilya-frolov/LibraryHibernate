package com.ilyafrolov.repository.mapper;

import com.ilyafrolov.model.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("authorMapper")
public class AuthorObjectMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int row) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        return author;
    }
}
