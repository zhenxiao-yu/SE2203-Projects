package Question3;

import Question1.CounterDisplay;

public class CalendarCounter implements CounterDisplay {
    //declare yearWheel, monthWheel,dayWheel and weekDaysWheel
    private YearWheel yearWheel;
    private MonthWheel monthWheel;
    private DayWheel dayWheel;
    private WeekDaysWheel weekDaysWheel;

    //constructor method for CalenderCounter
    public CalendarCounter(int initalMonth, int initalDay, int initialYear){
        monthWheel = new MonthWheel(initalMonth, initialYear);
        dayWheel = new DayWheel(initalDay, monthWheel.getMaxDays());
        yearWheel = new YearWheel(initialYear);
        weekDaysWheel = new WeekDaysWheel(initalDay, initalMonth, initialYear);
    }

    //implement the methods from the CounterDisplay interface
    //reset the counter to initial date
    @Override
    public void reset() {
        monthWheel.setThisMonth(monthWheel.getInitialMonth());
        dayWheel.setThisDay(dayWheel.getInitialDay());
        yearWheel.setThisYear(yearWheel.getInitialYear());
        weekDaysWheel.setThisWeekDay(weekDaysWheel.getInitialWeekDay());
    }

    //set the value of the wheels to random date
    @Override
    public void shuffle() {
        int randomDay = dayWheel.getRandom();
        int randomMonth = monthWheel.getRandom();
        int randomYear = yearWheel.getRandom();
        dayWheel.setThisDay(randomDay);
        monthWheel.setThisMonth(randomMonth);
        yearWheel.setThisYear(randomYear);
        weekDaysWheel.setThisWeekDay(weekDaysWheel.getThisWeekDay(randomDay, randomMonth, randomYear));
    }

    //increment the counter
    @Override
    public void increase() {
        //stores the value the next wheel should roll up to
        int dayMin = dayWheel.getMin();
        int monthMin = monthWheel.getMin();
        //weekdays wheel goes up by one
        weekDaysWheel.rollUp();
        //if day wheel is not rolled to the max, the day wheel continues to increase
        if (!(monthWheel.getMaxDays() == dayWheel.getThisDay())){
            dayWheel.rollUp();
        }
       //if it is rolled to the max, reset it to min.
        else {
            dayWheel.setThisDay(dayMin);
            //if the month wheel is not rolled to the max, the month wheel increases
            if (!(monthWheel.getThisMonth() == monthWheel.getMax())){
                monthWheel.rollUp();
            }
            //if the month wheel is rolled to the max, reset it to min, and the year wheel increases
            else {
                monthWheel.setThisMonth(monthMin);
                yearWheel.rollUp();
            }
        }
    }

    //decrement the counter
    @Override
    public void decrease() {
        //stores the value the next wheel should roll down to
        int dayMax = monthWheel.getMonthLength(monthWheel.getThisMonth(), yearWheel.getThisYear());
        int monthMax = monthWheel.getMax();
        //weekdays wheel goes down by one
        weekDaysWheel.rollDown();
        //if the day wheel is not not rolled to the min, the day wheel continues to go down
        if (!dayWheel.isRolledOver()){
            dayWheel.rollDown();
        }
        //if it is rolled over, set the value to the length of the previous month
        else {
            dayWheel.setThisDay(dayMax);
            //if the month wheel is not rolled to the min, the month wheel continues to go down
            if (!monthWheel.isRolledOver()){
                monthWheel.rollDown();
            }
            //if the month wheel is rolled to the min, set the value to maximum
            else {
                monthWheel.setThisMonth(monthMax);
                yearWheel.rollDown();
            }
        }
    }

    //format the output
    public String toString(){
        //get the number that represent the weekday/month
        int weekdayNum = weekDaysWheel.getThisWeekDay(dayWheel.getThisDay(),monthWheel.getThisMonth(), yearWheel.getThisYear());
        int monthNum = monthWheel.getThisMonth();
        //convert int values of day and year to String
        String day = Integer.toString(dayWheel.getThisDay());
        String year = Integer.toString(yearWheel.getThisYear());
        //assign weekday names to int values
        String weekday = switch (weekdayNum) {
            case 0 -> "Sat";
            case 1 -> "Sun";
            case 2 -> "Mon";
            case 3 -> "Tue";
            case 4 -> "Wed";
            case 5 -> "Thu";
            case 6 -> "Fri";
            default -> "error, no matching name for such day";
        };
        //assign month names to int values
        String month = switch (monthNum) {
            case 1 -> "Jan";
            case 2 -> "Feb";
            case 3 -> "Mar";
            case 4 -> "Apr";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "Aug";
            case 9 -> "Sep";
            case 10 -> "Oct";
            case 11 -> "Nov";
            case 12 -> "Dec";
            default -> "error, no matching name for such day";
        };

        //final output
        return weekday + " " + day + " " + month + ", " + year;
    }

}
