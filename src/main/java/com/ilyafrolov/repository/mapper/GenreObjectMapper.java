package com.ilyafrolov.repository.mapper;

import com.ilyafrolov.model.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("genreMapper")
public class GenreObjectMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int row) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre;
    }
}
