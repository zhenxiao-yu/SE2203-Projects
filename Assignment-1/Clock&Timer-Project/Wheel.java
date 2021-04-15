package Question2;

public abstract class Wheel<T> {
    //declares the value of the wheel
    private T value;

    //sets the value
    public void setValue(T value){
        this.value = value;
    }
    //return the value
    public T getValue(){
        return value;
    }

    // abstract methods
    //set the value field to the minimum value
    public abstract void reset();
    //return whether last wheel step caused a rollover
    public abstract Boolean isRolledOver();
}
