package repository.impl;

import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Author;
import org.springframework.stereotype.Repository;
import repository.AuthorRepository;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Repository
public final class AuthorRepositoryImpl implements AuthorRepository {

    private Set<Author> authors = new HashSet<>();

    public void save(Author author) {
        authors.add(author);
    }

    public Author get(Author author) {
        return authors.stream()
                .filter(a -> a.getName().equals(author.getName()))
                .findFirst().orElse(null);
    }


//    public Author getByID(int id) {
//        Author newAuthor = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_AUTHORS_BY_ID);
//             ResultSet rs = ps.executeQuery();) {
//
//            ps.setInt(1, id);
//            if (rs.next()) {
//                newAuthor = new Author(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newAuthor;
//    }
//
//    public Author getByName(Author author) {
//        Author newAuthor = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_AUTHORS_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, author.getName());
//            if (rs.next()) {
//                newAuthor = new Author(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newAuthor;
//    }
//
//    public Author add(Author author) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_AUTHORS, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, author.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//            if (rs.next()) {
//                author.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return author;
//    }
}

