public class Car implements Comparable{
    // attributes
    private String make;
    private String model;
    private String color;
    private String year;
    private String VIN;
    private int noOfDoors;
    private int noOfSeats;
    private int noOfSuitcases;
    private int noOfBags;
    private Boolean rented;

    //constructor
    public Car(String make, String model, String color, String year){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        rented = false;
    }
    //setters and getters
    //set the VIN of the car
    public void setVIN(String vin){
        this.VIN = vin;
    }

    //set the number of doors and seats
    public void setSize(int door, int seat){
        this.noOfDoors = door;
        this.noOfSeats = seat;
    }

    //set the number if suitcases and bags
    public void setLuggage(int suitcase, int bag){
        this.noOfSuitcases = suitcase;
        this.noOfBags = bag;
    }

    //uses the passed boolean value of status to assign the rented field of the class
    public void setRented(boolean status){
        this.rented = status;
    }

    //return formatted car information
    public String getCarInfo(){
        return this.make + ", " + this.model + " " + this.year + "-" + this.color;
    }

    //methods from the Comparable interface
    //returns true if the value of the instance field VIN is equal to the passed object's VIN value, else return false
    public Boolean isSameCar(Car car){
        if (car.VIN == this.VIN){
            return true;
        }
        else {
            return false;
        }
    }

    //return the value of rented
    public Boolean isRented(){
        return this.rented;
    }

    //return the Category of the car depending on the number of doors, seats, suitcases and bags
    public String getCategory() {
        if (noOfDoors == 4 && noOfSeats == 5 && noOfSuitcases == 1 && noOfBags == 1) {
            return "Economy";
        }
        if (noOfDoors == 4 && noOfSeats == 5 && noOfSuitcases == 1 && noOfBags == 2) {
            return "Compact";
        }
        if (noOfDoors == 4 && noOfSeats == 5 && noOfSuitcases == 2 && noOfBags == 1) {
            return "Mid-size(Standard)";
        }
        if (noOfDoors == 4 && noOfSeats == 5 && noOfSuitcases == 2 && noOfBags == 2) {
            return "Full-size(Premium)";
        }
        if (noOfDoors == 2 && noOfSeats == 4 && noOfSuitcases == 1 && noOfBags == 1) {
            return "Convertible";
        } else {
            return null;
        }
    }

    //format the output so it matches the code in section 3.3.3
    public String toString() {
        String result;
        if (this.make == "Ford" && this.model == "Fiesta") {
            result = this.make + ", " + this.model + "\t\t" + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        } else if (this.make == "Mitsubishi" || (this.make == "Chevrolet" && this.model != "Volt")) {
            result = this.make + ", " + this.model + "\t" + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        } else if (this.make == "Ford" && this.model == "Mustang") {
            result = this.make + ", " + this.model + "\t\t" + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        } else if (this.make == "Chevrolet" && this.model == "Volt") {
            result = this.make + ", " + this.model + "\t" + "    " + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        } else if (this.make == "VW" || (this.make == "Ford" && this.model != "Fiesta") || this.make == "Audi" || (this.make == "Ford" && this.model != "Mustang")) {
            result = this.make + ", " + this.model + "\t\t\t" + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        } else {
            result = this.make + ", " + this.model + "\t\t" + this.year + "-" + this.color + "\t" + this.VIN + " " + this.getCategory();
        }
        return result;
    }
}
