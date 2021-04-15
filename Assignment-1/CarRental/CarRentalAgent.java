import java.util.ArrayList;

public class CarRentalAgent{
    //declare attributes
    private String companyName;
    private String address;
    //make ArrayList of Type car
    private ArrayList<Car> CarInventory = new ArrayList<>();

    //constructor method
    public CarRentalAgent(String name, String address){
        this.companyName = name;
        this.address = address;
    }

    //add car object into CarInventory only if theres no such car in the inventory
    public Boolean addInventory(Car car){
        boolean defaultValue = true;
        for (Car value : CarInventory) {
            if (value.isSameCar(car)) {
                defaultValue = false;
            }
        }
        if (defaultValue){
            CarInventory.add(car);
        }
        return defaultValue;
    }

    //print the list of available cars
    public void printInventory(){
        System.out.println("\n" + "Agent Name: " + companyName);
        System.out.println("Agent Address: " + address + "\n");
        System.out.println("Car model and make Year-color   VIN               Category");
        System.out.println("------------------ -----------  ----------------- ------------------");
        for (Car car : CarInventory) {
            //iterate through arraylist
            System.out.println(car.toString());
        }
    }

    //change the value of rented field
    public Boolean rentCar(Car car){
        if (!car.isRented()){
            car.setRented(true);
            return true;
        }
        else {
            return false;
        }
    }

    //simulates the return process
    //if 
    public Boolean returnCar(Car car){
        if (car.isRented()){
            car.setRented(false);
            return true;
        } else {
            return false;
        }
    }
}
