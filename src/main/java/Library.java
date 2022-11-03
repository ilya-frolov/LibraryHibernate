import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Library {
    private static SessionFactory factory = null;

    public static void main(String[] args) {

        try (Session session = getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            for (int i = 1; i < 4; i++) {
                Book book = new Book();
                book.setTitle("book title" + i);

                Author author = new Author("book author" + i);
                session.save(author);
                book.setAuthor(author);

                Genre genre = new Genre("book genre" + i);
                session.save(genre);
                book.setGenre(genre);

                Publisher publisher = new Publisher("book publisher" + i, "book address" + i);
                session.save(publisher);
                book.setPublisher(publisher);
                session.save(book);

                Magazine magazine = new Magazine();
                magazine.setTitle("magazine title" + i);

                Author author2 = new Author("magazine author" + i);
                session.save(author2);
                magazine.setAuthor(author2);

                Genre genre2 = new Genre("magazine genre" + i);
                session.save(genre2);
                magazine.setGenre(genre2);

                Publisher publisher2 = new Publisher("magazine publisher" + i, "magazine address" + i);
                session.save(publisher2);
                magazine.setPublisher(publisher2);
                magazine.setPublishDate(LocalDate.now());
                session.save(magazine);

                Newspaper newspaper = new Newspaper();
                newspaper.setTitle("newspaper title" + i);

                Author author3 = new Author("newspaper author" + i);
                session.save(author3);
                newspaper.setAuthor(author3);

                Genre genre3 = new Genre("newspaper genre" + i);
                session.save(genre3);
                newspaper.setGenre(genre3);

                Publisher publisher3 = new Publisher("newspaper publisher" + i, "newspaper address" + i);
                session.save(publisher3);
                newspaper.setPublisher(publisher3);
                newspaper.setPublishDate(LocalDate.now());
                session.save(newspaper);
            }
            transaction.commit();
            System.out.println("all items saved");
        }

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 1; i < 10; i++) {
                Book book = session.get(Book.class, i);
                System.out.println("found book: " + book);

                Magazine magazine = session.get(Magazine.class, i);
                System.out.println("found magazine: " + magazine);

                Newspaper newspaper = session.get(Newspaper.class, i);
                System.out.println("found newspaper: " + newspaper);
            }
            transaction.commit();
        }

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Book book = new Book();
            book.setId(28);
            book.setTitle("book new title");
            Author author = session.get(Author.class, 1);
            book.setAuthor(author);
            Genre genre = session.get(Genre.class, 2);
            book.setGenre(genre);
            Publisher publisher = session.get(Publisher.class, 3);
            book.setPublisher(publisher);
            session.update(book);

            transaction.commit();
        }

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Magazine magazine = new Magazine();
            magazine.setId(32);
            magazine.setTitle("magazine new title");
            Author author = session.get(Author.class, 29);
            magazine.setAuthor(author);
            Genre genre = session.get(Genre.class, 30);
            magazine.setGenre(genre);
            Publisher publisher = session.get(Publisher.class, 31);
            magazine.setPublisher(publisher);
            session.delete(magazine);

            transaction.commit();
        }
    }


    private static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            factory = configuration.buildSessionFactory();
        }
        return factory;
    }
}
