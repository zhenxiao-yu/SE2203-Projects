package Question3;

import Question1.Rollable;
import Question2.Wheel;

import java.util.Random;

public class DayWheel extends Wheel implements Rollable {
    //declare integers to hold day
    private final int initialDay; //stores the value of the original instance
    private int thisDay; //stores the value of the YearWheel
    private final int daysInMonth; //stores the number of days in a month
    private final int minValue; //stores the minimum value of the DayWheel


    //constructor method for DayWheel
    public DayWheel(int day, int daysInMonth){
        this.initialDay = day;
        this.thisDay = day;
        this.daysInMonth = daysInMonth;
        this.minValue = 1;
        //no max value for DayWheel because the the length of months changes
    }

    //method that changes the value of the DayWheel
    public void setThisDay(int thisDay){
        this.thisDay = thisDay;
    }

    //returns the value of the original instance
    //used for reset
    public int getInitialDay() {
        return this.initialDay;
    }

    //returns the value of the DayWheel
    public int getThisDay() {
        return this.thisDay;
    }

    //returns the length of the month
    public int getDaysInMonth(){
        return daysInMonth;
    }

    //returns random day value
    public int getRandom() {
        Random random = new Random();
        return 1 + random.nextInt(27);
    }

    // returns the minimum value
    public int getMin(){
        return this.minValue;
    }

    //implement the abstract methods from Wheel.java
    //resets the value of the DayWheel to to the original day
    @Override
    public void reset() {
        setThisDay(this.getInitialDay());
    }

    //if a day is at minimum value, then previous roll must caused a rollover
    @Override
    public Boolean isRolledOver() {
        return this.getMin() == this.getThisDay();
    }
    
    //implement the Rollable interface
    //roll the DayWheel one step up
    @Override
    public void rollUp() {
        if (this.getThisDay() == this.getDaysInMonth()) {
            this.setThisDay(this.getMin());
        } else {
            this.setThisDay(this.getThisDay() + 1);
        }
    }

    //roll the DayWheel one step down
    @Override
    public void rollDown() {
        if (isRolledOver()) {
            this.setThisDay(this.getDaysInMonth());
        } else {
            this.setThisDay(this.getThisDay() - 1);
        }
    }

}
