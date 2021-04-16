package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorAdapter {

    Connection connection;

    public AuthorAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE Authors");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Authors
                stmt.execute("CREATE TABLE Authors ("
                        + "AuthorNames CHAR(25) NOT NULL REFERENCES AuthorNames (AuthorNames), "
                        + ")");
                //add some sample items
                populateSamples();
            }
        }
    }

    //adding some sample items
    private void populateSamples() throws SQLException {
        // Create a listing of authors to be added
        this.insertAuthor("Emily Dickinson"); //employee name column
        this.insertAuthor("Ernest Hemingway"); //employee id column
        this.insertAuthor("Jane Austen"); //branch name column
    }

    //insert a new item into the table
    public void insertAuthor(String authorName) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Authors (AuthorNames) "
                + "VALUES (" + authorName + ")");
    }

    //based on the value selected in the combo box, delete the entire row
    public void deleteAuthor(String authorName) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM Authors WHERE AuthorNames = authorName");
    }

    //based on the value selected in the combo box, update values from that row
    public void editAuthor(String authorName, String newName) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Authors SET AuthorNames = newName WHERE AutherName = authorName");
    }

    //Get a String list of name to populate the ComboBox used in Edit/Delete Author Form
    public ObservableList<String> getAuthorNameList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "Select AuthorNames FROM Authors";
        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // Loop the entire rows of rs and set the string values of list
        while (rs.next()) {
            list.add(new String(rs.getString("AuthorNames") ));
        }

        return list;
    }


}
