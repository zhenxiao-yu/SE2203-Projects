package Question3;

import Question1.Rollable;
import Question2.Wheel;

import java.util.Random;

public class MonthWheel extends Wheel implements Rollable {
    // declare integers to hold initialMonth
    private final int initialMonth; //store the value of the original instance
    private int thisMonth; //stores the value of the MonthWheel
    private int daysInMonth; //stores the number of days in a specific month
    private final int maxValue; //stores the minimum value of the MonthWheel
    private final int minValue; //stores the minimum value of the MonthWheel

    //constructor method for MonthWheel
    public MonthWheel(int month, int year){
        this.initialMonth = month;
        this.thisMonth = month;
        //Assign each month the correct number of days
        switch (month){
            case 2:
                if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
                    this.setMaxDays(29);
                else
                    this.setMaxDays(28);
                break;
            case 4,6,9,11:
                this.setMaxDays(30);
                break;
            case 1,3,5,7,8,10,12:
                this.setMaxDays(31);
                break;
        }
        //1 = "Jan", 2 = "Feb" ....12 = "Dec"
        this.minValue = 1;
        this.maxValue = 12;
    }

    //method that changes the value of the MonthWheel
    public void setThisMonth(int monthValue){
        this.thisMonth = monthValue;
    }

    //change the number of days in a month
    public void setMaxDays(int numberOfDays){
        this.daysInMonth = numberOfDays;
    }

    //returns the number of days in a month
    public int getMaxDays(){
        return this.daysInMonth;
    }

    //returns the value of the original instance
    //used for reset
    public int getInitialMonth(){
        return initialMonth;
    }

    //returns the value of the MonthWheel
    public int getThisMonth(){
        return thisMonth;
    }

    //Find the length of a month given the month and year
    public int getMonthLength(int month, int year){
        switch (month-1){
            //Length of feb depends on the year being a leap year
            case 2:
                if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
                    return  29;
                } else {
                    return 28;
                }
            //Apr,Jun,Sep,Nov al hav 30 days
            case 4,6,9,11:
                return  30;
            //Jan,Mar,May,Jul,Aug,Oct,Dec all have 31 days
            case 1,3,5,7,8,10,12:
                return 31;
        }
        return month;
    }

    //returns random month value
    public int getRandom() {
        Random random = new Random();
        return 1 + random.nextInt(11);
    }

    //return the minimum value
    public int getMin(){
        return this.minValue;
    }

    //return the maximum value
    public int getMax(){
        return this.maxValue;
    }

    //implement the abstract methods from Wheel.java
    @Override
    public void reset() {
        this.setThisMonth(this.getInitialMonth());
    }

    //if a month is at minimum value, then previous roll must caused a rollover
    @Override
    public Boolean isRolledOver() {
        return this.getMin() == this.getThisMonth();
    }

    //implement the Rollable interface
    //roll the MonthWheel one step up
    @Override
    public void rollUp() {
        if (this.getThisMonth() >= this.getMax()) {
            this.setThisMonth(this.getMin());
        } else {
            this.setThisMonth(this.getThisMonth() + 1);
        }
    }

    //roll the MonthWheel one step down
    @Override
    public void rollDown() {
        if (isRolledOver()) {
            this.setThisMonth(this.getMax());
        } else {
            this.setThisMonth(this.getThisMonth() - 1);
        }
    }


}
