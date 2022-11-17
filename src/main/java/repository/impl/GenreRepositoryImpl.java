package repository.impl;

import lombok.Setter;
import model.Genre;
import org.springframework.stereotype.Repository;
import repository.GenreRepository;
import java.util.HashSet;
import java.util.Set;

@Setter
@Repository
public final class GenreRepositoryImpl implements GenreRepository {

    private Set<Genre> genres = new HashSet<>();

    public void save(Genre genre) {
        genres.add(genre);
    }

    public Genre get(Genre genre) {
        return genres.stream()
                .filter(g -> g.getName().equals(genre.getName()))
                .findFirst().orElse(null);
    }

//    public Genre getByID(int id) {
//        Genre newGenre = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_GENRES_BY_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setInt(1, id);
//            if (rs.next()) {
//                newGenre = new Genre(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newGenre;
//    }
//
//    public Genre getByName(Genre genre) {
//        Genre newGenre = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_GENRES_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, genre.getName());
//            if (rs.next()) {
//                newGenre = new Genre(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newGenre;
//    }
//
//    public Genre add(Genre genre) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_GENRES, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, genre.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'genres'.");
//
//            if (rs.next()) {
//                genre.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return genre;
//    }
}
