package TennisBallGames;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abdelkader
 */
public class Matches {
    private final IntegerProperty  matchNumber;
    private final StringProperty homeTeam;
    private final StringProperty  visitorTeam;
    private final IntegerProperty homeTeamScore;
    private final IntegerProperty visitorTeamScore;


    public Matches(int num, String home, String visitor) {
        this(num, home, visitor,0,0);
    }

    public Matches(int num, String home, String visitor, int hScore, int vScore) {
        this.matchNumber = new SimpleIntegerProperty(num);
        this.homeTeam = new SimpleStringProperty(home);
        this.visitorTeam = new SimpleStringProperty(visitor);
        this.homeTeamScore = new SimpleIntegerProperty(hScore);
        this.visitorTeamScore = new SimpleIntegerProperty(vScore);

    }


    public void setMatchNumber(int num) {
        matchNumber.set(num);
    }
    public IntegerProperty matchNumberProperty() {
        return matchNumber;
    }
    public int getMatchNumber() {
        return matchNumber.get();
    }
    
    public void setHomeTeam(String home) {
        homeTeam.set(home);
    }
    public StringProperty homeTeamProperty() {
        return homeTeam;
    }
    public String getHomeTeam() {
        return homeTeam.get();
    }
   
    public void setVisitorTeam(String visitor) {
        homeTeam.set(visitor);
    }
    public StringProperty visitorTeamProperty() {
        return visitorTeam;
    }
    public String getVisitorTeam() {
        return visitorTeam.get();
    }
    

    public void setHomeTeamScore(int num) {
        homeTeamScore.set(num);
    }
    public IntegerProperty homeTeamScoreProperty() {
        return homeTeamScore;
    }
    public int getHomeTeamScore() {
        return homeTeamScore.get();
    }
    
    
    public void setVisitorTeamScore(int num) {
        visitorTeamScore.set(num);
    }
    public IntegerProperty visitorTeamScoreProperty() {
        return visitorTeamScore;
    }
    public int getVisitorTeamScore() {
        return visitorTeamScore.get();
    }
}

