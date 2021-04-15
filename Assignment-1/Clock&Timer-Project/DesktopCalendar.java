package Question3;

public class DesktopCalendar {
    public static void main(String[] args)
    {
        // Rolling up and prints from Feb 28 to Mar 3 2016
        CalendarCounter aDay = new CalendarCounter(2, 28, 2016);
        for (int i = 0; i < 5; i++)
        {
            System.out.println(aDay);
            aDay.increase();
        } // end for
        System.out.println();
        aDay.reset();
        System.out.println("Reset: " + aDay);
        System.out.println();

        // Rolling down and prints from March 3 down to Feb 28 2016
        aDay = new CalendarCounter(3, 3, 2016);
        for (int i = 0; i < 5; i++)
        {
            System.out.println(aDay);
            aDay.decrease();
        } // end for
        System.out.println();
        aDay.reset();
        System.out.println("Reset: " + aDay);
        System.out.println();

        // Rolling up and prints from Feb 27 to Mar 3 2021
        aDay = new CalendarCounter(2, 27, 2021);
        for (int i = 0; i < 5; i++)
        {
            System.out.println(aDay);
            aDay.increase();
        } // end for

        System.out.println();
        aDay.reset();
        System.out.println("Reset: " + aDay);
        System.out.println();
        // Rolling down and prints from March 3 down to Feb 28 2021
        aDay = new CalendarCounter(3, 3, 2021);
        for (int i = 0; i < 5; i++)
        {
            System.out.println(aDay);
            aDay.decrease();
        } // end for
        System.out.println();
        aDay.reset();
        System.out.println("Reset: " + aDay);
        System.out.println();
    } // end main
} // end Calendar

