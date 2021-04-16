/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TennisBallGames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abdelkader
 */
public class TeamsAdapter {

    Connection connection;

    public TeamsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                // We drop Matches first because it refrences the table Teams
                stmt.execute("DROP TABLE Matches");
                stmt.execute("DROP TABLE Teams");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of teams
                stmt.execute("CREATE TABLE Teams ("
                        + "TeamName CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Wins INT, " + "Losses INT, "
                        + "Ties INT" + ")");
                populateSampls();
            }
        }
    }

    private void populateSampls() throws SQLException {
        // Add some teams
        this.insertTeam("Astros");
        this.insertTeam("Marlins");
        this.insertTeam("Brewers");
        this.insertTeam("Cubs");
    }

    public void insertTeam(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Teams (TeamName, Wins, Losses, Ties) VALUES ('" + name + "', 0, 0, 0)");
    }

    // Get all teams Data
    public ObservableList<Teams> getTeamsList() throws SQLException {
        ObservableList<Teams> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT * FROM Teams";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // loop for the all rs rows and update list
        while (rs.next()) {
            list.add(new Teams(rs.getString("TeamName"),
                    rs.getInt("Wins"),
                    rs.getInt("Losses"),
                    rs.getInt("Ties")));
        }
        return list;
    }

    // Get all teams names to populate the ComboBoxs used in Task #3.
    public ObservableList<String> getTeamsNames() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT TeamName FROM Teams";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        // loop for the all rs rows and update list
        while (rs.next()) {
            list.add(rs.getString("TeamName"));
        }
        return list;
    }

    public void setStatus(String homeTeam, String visitorTeam, int homeTeamScore, int visitorTeamScore) throws SQLException {
        //declare necessary variables
        boolean homeTeamWin ;
        boolean visitorTeamWin;
        boolean tie;
        //if the scores from both teams are the same, theres a tie, neither wins
        if (homeTeamScore == visitorTeamScore) {
            homeTeamWin = false;
            visitorTeamWin = false;
        } else {
            //The team with the greater score wins
            homeTeamWin = homeTeamScore > visitorTeamScore;
            visitorTeamWin = visitorTeamScore > homeTeamScore;
        }
        tie = !(homeTeamWin|| visitorTeamWin);

        // Create a Statement object
        //CONCUR_UPDATABLE enables updating table through ResultSet
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT * FROM Teams";

        // Execute statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            String teamName = rs.getString("TeamName").strip();
            //if th teams tie, increase their Ties columns by 1
            if (teamName.equals(homeTeam) || teamName.equals(visitorTeam))
                if (tie) {
                    rs.updateInt("Ties", 1 + rs.getInt("Ties"));
                    rs.updateRow();
                }
            //if home team wins, increase their Wins column by 1
            if (Objects.equals(teamName, homeTeam) && homeTeamWin) {
                rs.updateInt("Wins", 1 + rs.getInt("Wins"));
                rs.updateRow(); // row updated after change
            }
            //if home team lost, increase their Losses column by 1
            if (Objects.equals(teamName, homeTeam) && !homeTeamWin && !tie ) {
                rs.updateInt("Losses", 1 + rs.getInt("Losses"));
                rs.updateRow();
            }
            //if visitor team wins, increase their Wins column by 1
            if (Objects.equals(teamName, visitorTeam) && visitorTeamWin) {
                rs.updateInt("Wins", 1 + rs.getInt("Wins"));
                rs.updateRow();
            }
            //if visitor team lost, increase their Losses column by 1
            if (Objects.equals(teamName, visitorTeam) && !visitorTeamWin && !tie) {
                rs.updateInt("Losses", 1 + rs.getInt("Losses"));
                rs.updateRow();
            }
        }

    }
}