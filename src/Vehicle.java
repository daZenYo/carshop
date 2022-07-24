import java.util.ArrayList;

public class Vehicle {

    static ArrayList<Vehicle> Vehicles = new ArrayList<>();
    String model;
    String make;
    int year;
    int owner_id;

    /**
     * Constructor for the Vehicle class.
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     * @param year - the year the vehicle was made in
     * @param owner_id - the vehicle's owner's id
     */
    Vehicle(String model, String make, int year, int owner_id) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.owner_id = owner_id;
    }

    /**
     * Method for buying a new vehicle, which adds a vehicle to the Vehicles arraylist.
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     * @param year - the year the vehicle was made in
     * @param owner_id - the vehicle's owner's id
     */
    public static void buyVehicle(String model, String make, int year, int owner_id) {
        for(int i=0; i<Client.getList().size(); i++) {
            if(Client.getList().get(i).id == owner_id) {
                Client.getList().get(i).hasCar = true;
                Client.getList().get(i).numberOfCars++;
            }
        }

        Vehicle car = new Vehicle(model, make, year, owner_id);
        Vehicles.add(car);
    }

    /**
     * Method for selling a vehicle, which deletes the specified vehicle from the arraylist.
     * @param owner_id - the vehicle's owner's id
     * @param model - model of the vehicle
     * @param make - make of the vehicle
     */
    public static void sellVehicle(int owner_id, String model, String make) {
        for(int i=0; i<Client.getList().size(); i++) {  //Not the prettiest, but it works
            if(Client.getList().get(i).id == owner_id) {
                for(int j=0; j<Vehicles.size(); j++) {
                    if((Vehicles.get(j).model).equals(model) && (Vehicles.get(j).make).equals(make)) {
                        Vehicles.remove(j);
                        System.out.println("Car sold!");
                        Client.getList().get(i).numberOfCars--;
                        if(Client.getList().get(i).numberOfCars == 0) { Client.getList().get(i).hasCar = false; }
                    }
                }
            }
        }
    }

    /**
     * Method for listing every car owner.
     */
    public static void listOwners() {
        boolean isEmpty = Vehicles.isEmpty();
        if(isEmpty) {
            System.out.println("No entries found!");
        } else {
            for(int i=0; i<Client.getList().size(); i++) {
                if(Client.getList().get(i).hasCar) {
                    for(int j=0; j<Vehicles.size(); j++) {
                        if(Vehicles.get(j).owner_id == Client.getList().get(i).id) {
                            System.out.println(Client.getList().get(i).name+" owns a "
                                                +Vehicles.get(j).model+" "
                                                +Vehicles.get(j).make);
                        }
                    }
                }
            }
        }
    }

    /**
     * Load test values into the program to make testing easier.
     */
    public static void loadTestValues() {
        Vehicle.buyVehicle("chevrolet", "camaro", 2014, 1);
        Vehicle.buyVehicle("ferrari", "unit", 2023, 2);
        Vehicle.buyVehicle("bmw", "e30", 2002, 2);
        System.out.println("Vehicle test values initialized!");
    }

}
