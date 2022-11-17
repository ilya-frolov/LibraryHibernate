package repository.impl;

import lombok.Setter;
import model.Book;
import org.springframework.stereotype.Repository;
import repository.BookRepository;
import java.util.HashSet;
import java.util.Set;

@Setter
@Repository
public final class BookRepositoryImpl implements BookRepository {

    private Set<Book> books = new HashSet<>();

    public void save(Book book) {
        books.add(book);
    }

    public Book get(Book book) {
        return books.stream()
                .filter(b -> b.getTitle().equals(book.getTitle()))
                .findFirst().orElse(null);
    }

    public Set<Book> getAll() {
        return books;
    }

    //change to stream
    public void update(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setGenre(book.getGenre());
            }
        }
    }

    //change to stream
    public void delete(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                books.remove(b);
            }
        }
    }

//    public List<Book> getAll() {
//        List<Book> books = new ArrayList<>();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_BOOKS);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                Book newBook = new Book(rs.getInt("id"), rs.getString("title"),
//                        authorRepository.getByID(rs.getInt("author_id")),
//                        genreRepository.getByID(rs.getInt("genre_id")), new Publisher());
//                new Book(1, "", new Author(), new Genre(), new Publisher());
//                books.add(newBook);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//
//
//    public int add(Book book) {
//        int updatedRows = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_BOOKS)) {
//
//            ps.setString(1, book.getTitle());
//            ps.setInt(2, book.getAuthor().getId());
//            ps.setInt(3, book.getGenre().getId());
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'books'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return updatedRows;
//    }
//
//    public int update(Book book) {
//        int updatedRows = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_BOOKS)) {
//
//            ps.setString(1, book.getTitle());
//            ps.setInt(2, book.getAuthor().getId());
//            ps.setInt(3, book.getGenre().getId());
//            ps.setInt(4, book.getId());
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'books'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return updatedRows;
//    }
//
//    public int delete(int id) {
//        int updatedRows = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_BOOKS)) {
//
//            ps.setInt(1, id);
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'book'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return updatedRows;
//    }
//
//    public Book getById(int id) {
//        Book book = new Book();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_BOOK_BY_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setInt(1, id);
//            while (rs.next()) {
//                book.setId(id);
//                book.setTitle(rs.getString("title"));
//                book.setAuthor(authorRepository.getByID(rs.getInt("author_id")));
//                book.setGenre(genreRepository.getByID(rs.getInt("genre_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return book;
//    }
//
//    public Book getByName(String title) {
//        Book newBook = new Book();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_BOOK_BY_TITLE);
//             ResultSet rs = ps.executeQuery()){
//
//            ps.setString(1, title);
//            if (rs.next()) {
//                newBook.setId(rs.getInt("id"));
//                newBook.setTitle(rs.getString("title"));
//                newBook.setAuthor(authorRepository.getByID(rs.getInt("author_id")));
//                newBook.setGenre(genreRepository.getByID(rs.getInt("genre_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newBook;
//    }

//    public int delete(int id) {
//        int updatedRows = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_BOOKS)) {
//
//            ps.setInt(1, id);
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'book'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return updatedRows;
//    }
//
//    public Book getById(int id) {
//        Book book = new Book();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_BOOK_BY_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setInt(1, id);
//            while (rs.next()) {
//                book.setId(id);
//                book.setTitle(rs.getString("title"));
//                book.setAuthor(authorRepository.getByID(rs.getInt("author_id")));
//                book.setGenre(genreRepository.getByID(rs.getInt("genre_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return book;
//    }
}
