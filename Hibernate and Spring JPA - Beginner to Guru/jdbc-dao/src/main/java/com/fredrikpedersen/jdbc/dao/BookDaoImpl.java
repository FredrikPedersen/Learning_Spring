package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;
import com.fredrikpedersen.jdbc.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final DataSource dataSource;
    private final AuthorDao authorDao;

    @Override
    public Book findById(final Long id) {
        final String query = "SELECT * FROM book WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getBookFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Book findByTitle(final String title) {
        final String query = "SELECT * FROM book WHERE title = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getBookFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Book save(final Book book) {
        final String query = "INSERT INTO book (title, isbn, publisher, author_id) VALUES (?, ?, ?, ?) RETURNING *";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setString(3, book.getPublisher());

            if (book.getAuthor() != null) {
                statement.setLong(4, book.getAuthor().getId());
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getBookFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Book update(final Book book) {
        final String query = "UPDATE book SET title = ?, isbn = ?, publisher = ?, author_id = ? WHERE id = ? RETURNING *";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setString(3, book.getPublisher());

            if (book.getAuthor() != null) {
                statement.setLong(4, book.getAuthor().getId());
            }

            statement.setLong(5, book.getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getBookFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.findById(book.getId());
    }

    @Override
    public boolean deleteById(final Long id) {
        final String query = "DELETE FROM book WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Book getBookFromResultSet(final ResultSet resultSet) throws SQLException {
        final Book book = Book.builder()
                .title(resultSet.getString("title"))
                .isbn(resultSet.getString("isbn"))
                .publisher(resultSet.getString("publisher"))
                .author(authorDao.findById(resultSet.getLong("author_id")))
                .build();

        book.setId(resultSet.getLong("id"));
        return book;
    }
}
