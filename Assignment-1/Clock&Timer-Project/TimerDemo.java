package Question2;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {
    static IntegerWheel seconds = new IntegerWheel(20);
    static IntegerWheel minutes = new IntegerWheel(0);
    static IntegerWheel hours = new IntegerWheel(0);
    static IntegerWheelCounter theTimer = new IntegerWheelCounter(hours, minutes, seconds);
    static Timer timer = new Timer();

    public void run() {
        System.out.print("\r" + theTimer);
        if (theTimer.toString().equals("00:00:00") ) {
            {
                timer.cancel();
                timer.purge();
                return;
            }
        }
        theTimer.decrease();
    }

    public static void main(String[] args) {
        System.out.println("Wheels based timer");
        System.out.println("==================");
        timer.schedule(new TimerDemo(), 0, 1000);
    }
}