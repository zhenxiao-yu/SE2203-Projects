package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TitleAdapter {
    Connection connection;

    public TitleAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE Titles");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE BookTitles ("
                        + "Titles CHAR(35) NOT NULL REFERENCES Titles (Titles), "
                        + "PublicationDate CHAR(25) NOT NULL REFERENCES PublicationDate (PublicationDate), "
                        + "BookLength INT, "
                        + ")");
                //add some sample items
                populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException {
        // Create a listing of authors to be added
        this.insertTitle("Selected Poems","02/05/2021",128);
        this.insertTitle("In Our Time","01/19/2021",394);
        this.insertTitle("Pride and Prejudice","10/11/2021",331);
    }

    //insert a new item into the table
    public void insertTitle(String title, String publicationDate, int pageLength) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO BookTitles (Titles, PublicationDate, BookLength) "
                + "VALUES (" + title + " , '" + publicationDate + "' , '" + pageLength + "')");
    }

    //based on the value selected in the combo box, delete the entire row
    public void deleteTitle(String title) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM BookTitles WHERE Titles = title");
    }

    //based on the value selected in the combo box, update values from that row
    public void editTitle(String title, String newTitle, String publicationDate, int pageLength) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE BookTitles SET Titles = newTitle, PublicationDate = publicationDate, BookLength = pageLength WHERE Titles = title");
    }

    // Get a String list of titles to populate the ComboBox used in edit/delete Title Form.
    public ObservableList<String> getTitlesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "Select Titles FROM BookTitles";
        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // Loop the entire rows of rs and set the string values of list
        while (rs.next()) {
            list.add(rs.getString("Titles"));
        }

        return list;
    }
}
