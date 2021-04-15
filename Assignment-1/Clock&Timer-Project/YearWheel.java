package Question3;

import Question1.Rollable;
import Question2.Wheel;

import java.util.Random;

public class YearWheel extends Wheel implements Rollable {
    // declare integers to hold year
    private final int initialYear; //store the value of the original instance
    private int thisYear; //stores the value of the YearWheel

    //constructor method for YearWheel
    public YearWheel(int year){
        this.initialYear = year;
        this.thisYear = year;
        //no min, max value needed for YearWheel
    }

    //method that changes the value of the YearWheel
    public void setThisYear(int thisYear){
        this.thisYear = thisYear;
    }

    //returns the value of the original instance
    //used for reset
    public int getInitialYear(){
        return initialYear;
    }

    //returns the value of the YearWheel
    public int getThisYear(){
        return thisYear;
    }

    //returns random year value
    public int getRandom() {
        Random random = new Random();
        return 1 + random.nextInt();
    }

    //implement the abstract methods from Wheel.java
    //resets the value of the YearWheel to to the original year
    @Override
    public void reset() {
        setThisYear(this.getInitialYear());
    }

    //for any date after 0 AD, there will be no roll over
    @Override
    public Boolean isRolledOver() {
        return this.getThisYear() < 0;
    }

    //implement the Rollable interface
    //roll the YearWheel one step up
    @Override
    public void rollUp() {
        this.setThisYear(this.getThisYear() + 1);
    }

    //roll the YearWheel one step down
    @Override
    public void rollDown() {
        this.setThisYear(this.getThisYear() - 1);
    }

}
