package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final String COLUMN_ID = "id";
    private final String COLUMN_FIRST_NAME = "first_name";
    private final String COLUMN_LAST_NAME = "last_name";

    private final DataSource dataSource;

    @Override
    public Author findById(final Long id) {
        final String query = "SELECT * FROM author WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getAuthorFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Author findByName(final String firstName, final String lastName) {
        final String query = "SELECT * FROM author WHERE first_name = ? AND last_name = ?";
        return executeQueryOnFirstAndLastName(query, firstName, lastName);
    }

    @Override
    public Author save(final Author author) {
        final String query = "INSERT INTO author (first_name, last_name) values (?, ?) RETURNING *";
        return executeQueryOnFirstAndLastName(query, author.getFirstName(), author.getLastName());
    }

    private Author executeQueryOnFirstAndLastName(final String query, final String firstName, final String lastName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getAuthorFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Author getAuthorFromResultSet(final ResultSet resultSet) throws SQLException {
        final Author author = Author.builder()
                .firstName(resultSet.getString(COLUMN_FIRST_NAME))
                .lastName(resultSet.getString(COLUMN_LAST_NAME))
                .build();

        author.setId(resultSet.getLong(COLUMN_ID));

        return author;
    }
}
