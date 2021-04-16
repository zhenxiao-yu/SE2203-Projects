package TennisBallGames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Abdelkader
 */
public class MatchesAdapter {

    Connection connection;

    public MatchesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE Matches");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Matches ("
                        + "MatchNumber INT NOT NULL PRIMARY KEY, "
                        + "HomeTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "VisitorTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "HomeTeamScore INT, "
                        + "VisitorTeamScore INT "
                        + ")");
                populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException {
        // Create a listing of the matches to be played
        this.insertMatch(1, "Astros", "Brewers");
        this.insertMatch(2, "Brewers", "Cubs");
        this.insertMatch(3, "Cubs", "Astros");
    }

    //get the match number when a new game is added
    public int getMax() throws SQLException {
        ResultSet rs;
        //give initial value to num variable
        int num = 0;
        //get the max number of items from the MatchNumber column from Matches table
        String sqlStatement = "SELECT MAX(MatchNumber)FROM Matches";
        //Execute the query by sending the SQL statement to the DBMS
        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(sqlStatement);
        //Get the number od items and return it
        while (rs.next()) {
            num = rs.getInt(1);
        }
        return num;
    }

    public void insertMatch(int num, String home, String visitor) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Matches (MatchNumber, HomeTeam, VisitorTeam, HomeTeamScore, VisitorTeamScore) "
                + "VALUES (" + num + " , '" + home + "' , '" + visitor + "', 0, 0)");
    }

    // Get all Matches
    public ObservableList<Matches> getMatchesList() throws SQLException {
        ObservableList<Matches> matchesList = FXCollections.observableArrayList();
        ResultSet rs;
        // Add your code here for Task #2
        //Write an SQL statement to select all columns from the Matches table
        String sqlStatement = "SELECT * FROM Matches";
        //Execute the query by sending the SQL statement to the DBMS
        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(sqlStatement);
        //Use a while loop to add the contents of the result set to matchesList
        while (rs.next()) {
            matchesList.add(new Matches(rs.getInt("MatchNumber"),
                    rs.getString("HomeTeam"),
                    rs.getString("VisitorTeam"),
                    rs.getInt("HomeTeamScore"),
                    rs.getInt("VisitorTeamScore")));
        }
        return matchesList;
    }

    // Get a String list of matches to populate the ComboBox used in Task #4.
    public ObservableList<String> getMatchesNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "Select MatchNumber, HomeTeam, VisitorTeam FROM Matches";
        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // Loop the entire rows of rs and set the string values of list
        while (rs.next()) {
            list.add(new String(rs.getInt("MatchNumber") + "-" +
                    rs.getString("HomeTeam") + "   -" +
                    rs.getString("VisitorTeam")));
        }

        return list;
    }


    public void setTeamsScore(int matchNumber, int hScore, int vScore) throws SQLException {
        // Add your code here for Task #4
        // Create a Statement object
        Statement stmt = connection.createStatement();
        // Update the Matches table by changing the scores
        String sqlStatement = "UPDATE Matches SET HomeTeamScore = " + hScore +
                ", VisitorTeamScore = " + vScore +
                "WHERE MatchNumber = " + String.valueOf(matchNumber); //only change score from the teams that are selected in the combobox
        // Execute the statement and update the result
        stmt.executeUpdate(sqlStatement);
    }

}
