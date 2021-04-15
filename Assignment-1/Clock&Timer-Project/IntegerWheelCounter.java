package Question2;

import Question1.CounterDisplay;
import java.util.Random;

public class IntegerWheelCounter implements CounterDisplay {
    //declare an array of integerWheels to represent different units of measurement for time
    private IntegerWheel[] integerWheel = new IntegerWheel[3];
    // declare the number of wheels as an integer;
    private int noOfWheels;

    //constructor,
    public IntegerWheelCounter(IntegerWheel wheelThree, IntegerWheel wheelTwo, IntegerWheel wheelOne){
        this.noOfWheels = integerWheel.length;
        this.integerWheel[noOfWheels-3] = wheelThree; //Q2: hours
        this.integerWheel[noOfWheels-2] = wheelTwo;   //Q2: minutes
        this.integerWheel[noOfWheels-1] = wheelOne;   //Q2: seconds
    }

    //implement the methods from the CounterDisplay interface
    //reset counter to minimum value
    @Override
    public void reset() {
        for (IntegerWheel wheel : integerWheel) {
            wheel.reset();
        }
    }

    //randomize the positions of the wheels of the counter
    @Override
    public void shuffle() {
        Random random = new Random();
        for (IntegerWheel wheel : integerWheel) {
            wheel.setValue(wheel.getMax() + random.nextInt(wheel.getMin() - wheel.getMax()));
        }
    }

    //increment the counter
    @Override
    public void increase() {
        integerWheel[noOfWheels-1].rollUp();
        if (integerWheel[noOfWheels-1].getValue().equals(integerWheel[noOfWheels-1].getMax())){
            integerWheel[noOfWheels-2].rollUp();
            if (integerWheel[noOfWheels-2].getValue().equals(integerWheel[noOfWheels-2].getMax())){
                integerWheel[noOfWheels-3].rollUp();
            }
        }
    }

    //decrement the counter
    @Override
    public void decrease() {
        integerWheel[noOfWheels-1].rollDown();
        if (integerWheel[noOfWheels-1].getValue().equals(integerWheel[noOfWheels-1].getMin())){
            integerWheel[noOfWheels-2].rollDown();
            if (integerWheel[noOfWheels-2].getValue().equals(integerWheel[noOfWheels-2].getMin())){
                integerWheel[noOfWheels-3].rollDown();
            }
        }
    }

    //format the output
    public String toString(){
        String hour = integerWheel[noOfWheels-3].getValue().toString();
        String minute = integerWheel[noOfWheels-2].getValue().toString();
        String second = integerWheel[noOfWheels-1].getValue().toString();
        //add leading 0 to single digits
        if (10 > integerWheel[0].getValue()){
            hour = "0" + integerWheel[0].getValue();
        }
        if (10 > integerWheel[1].getValue()){
            minute = "0" + integerWheel[1].getValue();
        }
        if (10 > integerWheel[2].getValue()){
            second = "0" + integerWheel[2].getValue();
        }
        //final output
        return hour + ":" + minute + ":" + second;
    }
}

