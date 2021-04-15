public class CarRentalDemo {
    public static void main(String[] args) {
        // Create two rental agents
        CarRentalAgent firstCompany = new CarRentalAgent("InitiativeRent", "10 First St.");
        CarRentalAgent secondCompany = new CarRentalAgent("CheapRent", "123 Second St.");

        // Create cars
        Car economy1 = new Car("Ford", "Fiesta", "White", "2020");
        economy1.setSize(4, 5);
        economy1.setLuggage(1, 1);
        economy1.setVIN("1HGCM56415A005624");
        Car economy2 = new Car("Chevrolet", "Spark", "Black", "2020");
        economy2.setSize(4, 5);
        economy2.setLuggage(1, 1);
        economy2.setVIN("WBADT43403G034950");
        Car economy3 = new Car("Mitsubishi", "Mirage", "White", "2019");
        economy3.setSize(4, 5);
        economy3.setLuggage(1, 1);
        economy3.setVIN("2HGFG11879H560138");
        Car compact1 = new Car("Nissan", "Versa", "Red", "2019");
        compact1.setSize(4, 5);
        compact1.setLuggage(1, 2);
        compact1.setVIN("1G1ZS58F77F128386");
        Car compact2 = new Car("Ford", "Focus", "White", "2020");
        compact2.setSize(4, 5);
        compact2.setLuggage(1, 2);
        compact2.setVIN("1FDAW57SX1ED49643");
        Car compact3 = new Car("Chevrolet", "Volt", "Silver", "2020");
        compact3.setSize(4, 5);
        compact3.setLuggage(1, 2);
        compact3.setVIN("3HGCM56417G721802");
        Car standard1 = new Car("Hyundai", "Fiesta", "Yellow", "2020");
        standard1.setSize(4, 5);
        standard1.setLuggage(2, 1);
        standard1.setVIN("2GNFLDE35E6206836");
        Car standard2 = new Car("VW", "Jetta", "Blue", "2019");
        standard2.setSize(4, 5);
        standard2.setLuggage(2, 1);
        standard2.setVIN("1N4BA41E94C855149");
        Car standard3 = new Car("Honda", "Accord", "Brown", "2020");
        standard3.setSize(4, 5);
        standard3.setLuggage(2, 1);
        standard3.setVIN("KMHFC46D87A299420");
        Car standard4 = new Car("Toyota", "Camry", "Green", "2018");
        standard4.setSize(4, 5);
        standard4.setLuggage(2, 1);
        standard4.setVIN("3HGCM56417G721802");
        Car premium1 = new Car("Hyundai", "Sonata", "White", "2020");
        premium1.setSize(4, 5);
        premium1.setLuggage(2, 2);
        premium1.setVIN("1VWBP7A38CC023418");
        Car premium2 = new Car("Nissan", "Maxima", "Black", "2018");
        premium2.setSize(4, 5);
        premium2.setLuggage(2, 2);
        premium2.setVIN("2T1BR32E37C728114");
        Car premium3 = new Car("Chevrolet", "Impala", "Gray", "2021");
        premium3.setSize(4, 5);
        premium3.setLuggage(2, 2);
        premium3.setVIN("1GCVKREC0EZ103056");
        Car premium4 = new Car("Toyota", "Avalon", "Red", "2018");
        premium4.setSize(4, 5);
        premium4.setLuggage(2, 2);
        premium4.setVIN("JTKDE167570187929");
        Car premium5 = new Car("Chrysler", "300", "Black", "2020");
        premium5.setSize(4, 5);
        premium5.setLuggage(2, 2);
        premium5.setVIN("2MEBM74F5JX656278");
        Car premium6 = new Car("Audi", "A-5", "White", "2018");
        premium6.setSize(4, 5);
        premium6.setLuggage(2, 2);
        premium6.setVIN("19VDE3F78DE390473");
        Car premium7 = new Car("BMW", "5-series", "Red", "2021");
        premium7.setSize(4, 5);
        premium7.setLuggage(2, 2);
        premium7.setVIN("1YVGE22D6S5427386");
        Car convertible1 = new Car("Ford", "Mustang", "Yellow", "2021");
        convertible1.setSize(2, 4);
        convertible1.setLuggage(1, 1);
        convertible1.setVIN("2XKADR9X9KM569615");
        Car convertible2 = new Car("Chevrolet", "Camaro", "White", "2020");
        convertible2.setSize(2, 4);
        convertible2.setLuggage(1, 1);
        convertible2.setVIN("3GNFK16R3WG121908");
        Car convertible3 = new Car("BMW", "4-series", "Red", "2021");
        convertible3.setSize(2, 4);
        convertible3.setLuggage(1, 1);
        convertible3.setVIN("1FMZU32E2WZA30946");

        // Add car to the first company
        firstCompany.addInventory(economy1);
        firstCompany.addInventory(economy3);
        firstCompany.addInventory(compact1);
        firstCompany.addInventory(compact3);
        firstCompany.addInventory(standard1);
        firstCompany.addInventory(standard2);
        firstCompany.addInventory(premium1);
        firstCompany.addInventory(premium2);
        firstCompany.addInventory(premium3);
        firstCompany.addInventory(premium4);
        firstCompany.addInventory(premium5);
        firstCompany.addInventory(convertible1);
        firstCompany.addInventory(convertible2);

        // Add car to the second company
        secondCompany.addInventory(economy2);
        secondCompany.addInventory(compact2);
        secondCompany.addInventory(standard3);
        secondCompany.addInventory(standard4);
        secondCompany.addInventory(premium6);
        secondCompany.addInventory(premium7);
        secondCompany.addInventory(convertible3);

        // Print out the inventory list of the first company
        firstCompany.printInventory();
        System.out.println();

        // Print out the inventory list of the second company
        secondCompany.printInventory();
        System.out.println();

        // Try to rent a car twice
        System.out.println("Renting the car: " + economy1.getCarInfo());
        if (firstCompany.rentCar(economy1))
            System.out.println("The rent is completed successfully");
        else
            System.out.println("The car is not available");
        System.out.println();

        System.out.println("Renting the car: " + economy1.getCarInfo() + " again");
        if (firstCompany.rentCar(economy1))
            System.out.println("The rent is completed successfully");
        else
            System.out.println("Sorry: the car is not available");
        System.out.println();

        // try to return a car
        System.out.println("Returning the car: " + economy1.getCarInfo() );
        if (firstCompany.returnCar(economy1))
            System.out.println("The car is returned successfully");
        else
            System.out.println("Error: the car is not out, or it is not owned by the company");
        System.out.println();

        System.out.println("Renting the car: " + economy1.getCarInfo() + " again");
        if (firstCompany.rentCar(economy1))
            System.out.println("The rent is completed successfully");
        else
            System.out.println("Sorry: the car is not available");
        System.out.println();

        System.out.println("Returning the car: " + economy2.getCarInfo() );
        if (secondCompany.returnCar(economy2))
            System.out.println("The car is returned successfully");
        else
            System.out.println("Error: the car is not out, or it is not owned by the company");
        System.out.println();


    }
}