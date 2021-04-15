package Question2;

import Question1.Rollable;

public class IntegerWheel extends Wheel<Integer> implements Rollable {
    //declare min and max values
    private int minValue;
    private int maxValue;

    //implement the abstract methods from Wheel.java
    //set the value of the wheel to minimum value
    @Override
    public void reset() {
        super.setValue(this.getMin());
    }

    //return whether last wheel step caused a rollover
    //if the value is at min, the previous step must caused be a rollover
    @Override
    public Boolean isRolledOver() {
        return super.getValue().equals(this.getMin());
    }

    //implement the Rollable interface
    //roll the wheel one step down
    @Override
    public void rollDown() {
        //decrease wheel value by 1 if the current value is more than the minimum value
        if (super.getValue() > this.getMin())
            super.setValue(super.getValue() - 1);
        else
            //if not, there has been a rollover, set the value to max
            super.setValue(this.getMax());
    }

    //roll the wheel one step up
    @Override
    public void rollUp() {
        //increase wheel value by 1 if the current value is less than the minimum value
        if (this.getMin() > super.getValue())
            super.setValue(super.getValue() + 1);
        else
            //if not, there has been a rollover, set the wheel value to max
            super.setValue(this.getMax());
    }

    //1st constructor, initialize the minValue to 0, maxValue to max, wheel value to max
    public IntegerWheel(int max){
        this.minValue = 0;
        this.maxValue = max;
        super.setValue(max);
    }

    //2nd constructor, minValue to min, maxValue to max, wheel value to min
    public IntegerWheel(int max, int min){
        this.minValue = min;
        this.maxValue = max;
        super.setValue(min);
    }

    //return the minimum value
    public int getMin(){
        return this.minValue;
    }

    //return the maximum value
    public int getMax(){
        return this.maxValue;
    }
}
