package TennisBallGames;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abdelkader
 */
public class Teams {

    private final StringProperty teamName;
    private final IntegerProperty  wins;
    private final IntegerProperty losses;
    private final IntegerProperty ties;

    public Teams(String name, int win , int lose, int tie) {
        this.teamName = new SimpleStringProperty(name);
        this.wins = new SimpleIntegerProperty(win);
        this.losses = new SimpleIntegerProperty(lose);
        this.ties = new SimpleIntegerProperty(tie);
    }


    public void setTeamName(String name) {
        teamName.set(name);
    }
    public StringProperty teamNameProperty() {
        return teamName;
    }
    public String getTeamName() {
        return teamName.get();
    }
    
    public void setWins(int win) {
        wins.set(win);
    }
    public IntegerProperty winsProperty() {
        return wins;
    }
    public int getWins() {
        return wins.get();
    }
    
    public void setLosses(int lose) {
        losses.set(lose);
    }
    public IntegerProperty lossesProperty() {
        return losses;
    }
    public int getLosses() {
        return losses.get();
    }
    
    public void setTies(int tie) {
        losses.set(tie);
    }
    public IntegerProperty tiesProperty() {
        return ties;
    }
    public int getTies() {
        return ties.get();
    }
}
