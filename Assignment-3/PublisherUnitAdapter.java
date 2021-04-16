package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PublisherUnitAdapter {
    Connection connection;
    public PublisherUnitAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE PublisherUnits");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of PublisherUnits
                stmt.execute("CREATE TABLE PublisherUnits ("
                        + "EmployeeName CHAR(25) NOT NULL REFERENCES EmployeeName (EmployeeName), " //employee name column
                        + "EmployeeID CHAR(25) NOT NULL REFERENCES EmployeeID (EmployeeID), " //employee id column
                        + "BranchName CHAR(25) NOT NULL REFERENCES BranchName (BranchName), " //branch name column
                        + ")");
               //add some sample items
                populateSamples();
            }
        }
    }

    //adding some sample items
    private void populateSamples() throws SQLException {
        // Create a listing of authors to be added
        this.insertPublisherUnit("Joel Beres","#458678","Waterloo");
        this.insertPublisherUnit("Debrah Park","#945117","Toronto");
        this.insertPublisherUnit("Jamal Leblonc","#785258","Montreal");
    }

    //insert a new item into the table
    public void insertPublisherUnit(String name, String ID, String Location) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO PublisheUnits (EmployeeName, EmployeeID, BranchName) "
                + "VALUES (" + name + " , '" + ID + "' , '" + Location + "')");
    }

    //based on the value selected in the combo box, delete the entire row
    public void deletePublisherUnit(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM PublisherUnits WHERE EmployeeName = name");
    }

    //based on the value selected in the combo box, update values from that row
    public void editPublisherUnit(String name, String newName, String ID, String Location) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE PublisherUnits SET EmployeeName = newName, EmployeeID = ID, BranchName = Location WHERE EmployeeName = name");
    }

    // Get a String list of employee names to populate the ComboBox used in edit/delete Publisher Unit Form.
    public ObservableList<String> getEmployeeList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "Select EmployeeName FROM PublisherUnits";
        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // Loop the entire rows of rs and set the string values of list
        while (rs.next()) {
            list.add(rs.getString(""));
        }

        return list;
    }
}
