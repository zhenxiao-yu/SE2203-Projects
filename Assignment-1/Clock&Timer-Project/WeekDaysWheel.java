package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class WeekDaysWheel extends Wheel implements Rollable {
    //declare integers to hold weekday
    private final int initialWeekDay; //stores the value of the original instance
    private int thisWeekDay; //stores the value of the WeekDaysWheel
    private final int minValue; //stores the minimum value of the WeekDaysWheel
    private final int maxValue; //stores the maximum value of the WeekDaysWheel

    //constructor method for WeekDaysWheel
    public WeekDaysWheel(int day, int month, int year){
        this.initialWeekDay = this.getThisWeekDay(day,month,year);
        this.thisWeekDay = this.getThisWeekDay(day,month,year);
        //0 = 'Sat", 1 = "Sun", 2 = "Mon" .... 6 = "Fri"
        this.minValue = 0;
        this.maxValue = 6;
    }

    //method that changes the value of the WeekDaysWheel
    public void setThisWeekDay(int weekday){
        this.thisWeekDay = weekday;
    }

    //returns the value of the original instance
    //used for reset
    public int getInitialWeekDay(){
        return this.initialWeekDay;
    }

    //returns the value of the WeekDaysWheel
    public int getThisWeekDay(){
        return thisWeekDay;
    }

    //find WeekDay value based on day, month and year based on Zeller’s Congruence in Java
    public int getThisWeekDay(int day, int month, int year){
        if (3 > month){
            month = month + 12;
            year = year - 1;
        }
        int a = year % 100;
        int b = year / 100;
        return this.thisWeekDay = ((day + (((month + 1) * 26) / 10) + a + (a / 4) + (b / 4)) + (5 * b)) % 7;
    }

    //returns the minimum value
    public int getMin(){
        return this.minValue;
    }

    //returns the maximum value
    public int getMax(){
        return this.maxValue;
    }

    //implement the abstract methods from Wheel.java
    //resets the value of the WeekDayWheel to to the original day
    @Override
    public void reset() {
        this.setThisWeekDay(initialWeekDay);
    }

    //if a weekday is at minimum value, then previous roll must caused a rollover
    @Override
    public Boolean isRolledOver() {
        return this.getMin() == this.getThisWeekDay();
    }

    //implement the Rollable interface
    //roll the WeekDaysWheel one step up
    @Override
    public void rollUp() {
        if (this.getThisWeekDay() >= this.getMax()) {
            setThisWeekDay(this.getMin());
        } else {
            setThisWeekDay(this.getThisWeekDay() + 1);
        }
    }

    //roll the WeekDaysWheel one step down
    @Override
    public void rollDown() {
        if (isRolledOver()) {
            setThisWeekDay(this.getMax());
        } else {
            setThisWeekDay(this.getThisWeekDay() - 1);
        }
    }

}
