import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    ArrayList<Client> Clients = new ArrayList<Client>();
    ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
    boolean exit = false;

    public void runMenu() {
        while(!exit) {
            printMenu();
            int mp = getMP();
            buildMenu(mp);
        }
    }

    public void printMenu() {
        System.out.println("Please enter the selected menu point.");
        System.out.println("0) Exit");
        System.out.println("1) Add new entry");
        System.out.println("2) Delete entry");
        System.out.println("3) List entries");
        System.out.println("4) Buy a vehicle");
        System.out.println("5) Sell a vehicle");
        System.out.println("6) List car owners");
    }

    private int getMP() {
        Scanner scanner = new Scanner(System.in);
        int mp = -1;
        while(mp < 0 || mp > 6) {
            try {
                System.out.println("\nEnter the selected menu point: ");
                mp = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e) {
                System.out.println("ERROR. INVALID SELECTION.");
            }
        }

        return mp;
    }

    private void buildMenu(int mp) {
        Scanner scanner = new Scanner(System.in);
        switch (mp) {
            case 0:
                exit = true;
                System.out.println("Goodbye!");
                System.out.println("\n");
                break;

            case 1:
                System.out.println("---------------Add new entry---------------");
                System.out.println("Please enter your credentials.");

                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("ID number: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                boolean hasCar = false;

                for (int i = 0; i < Clients.size(); i++) {
                    while (Clients.get(i).id == id) {
                        System.out.print("This ID number is already taken! Please enter a new one: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                    }
                }

                Client client = new Client(name, age, id);
                Clients.add(client);

                System.out.println("\n");
                break;

            case 2:
                System.out.println("---------------Delete entry---------------");
                System.out.print("Type in the name you'd like to delete: ");
                String name_temp = scanner.nextLine();

                for(int i=0; i<Clients.size(); i++) {
                    while(!Clients.get(i).name.equals(name_temp)) {
                        System.out.print("This user does not exist! Please enter the name again: ");
                        name_temp = scanner.nextLine();
                    }
                }

                for(int i=0; i<Clients.size(); i++) {
                    if(Clients.get(i).name.equals(name_temp)) {
                        Clients.remove(i);
                    }
                }

                System.out.println("\n");
                break;
            case 3:
                System.out.println("---------------List entries---------------");
                System.out.println("Listing entries...");

                boolean isEmptyClient = Clients.isEmpty();
                if(isEmptyClient) {
                    System.out.println("No entries found!");
                } else {
                    for (int i=0; i<Clients.size(); i++) {
                        System.out.println("Client #"+(i+1)+": "+Clients.get(i).name+", "
                                                                +Clients.get(i).age+" years old"
                                                                +"\nID number: "+Clients.get(i).id
                                                                +"\nOwns a car? "+Clients.get(i).hasCar
                                                                +"\n");
                    }
                }

                System.out.println("\n");
                break;

            case 4:
                System.out.println("---------------Buy a vehicle---------------");
                System.out.println("Who'd like to buy a car (ID of the owner)?");
                int owner_id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Which car would you like to buy?");
                System.out.print("Model: ");
                String model = scanner.nextLine();
                System.out.print("Make: ");
                String make = scanner.nextLine();
                System.out.print("Year: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                Vehicle car = new Vehicle(model, make, year, owner_id);
                Vehicles.add(car);

                for(int i=0; i<Clients.size(); i++) {
                    if(Clients.get(i).id == owner_id) {
                        Clients.get(i).hasCar = true;
                    }
                }

                System.out.println("\n");
                break;

            case 5:
                System.out.println("---------------Sell a vehicle---------------");
                System.out.println("Who'd like to sell a car (ID of the owner)?");
                owner_id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Which car would you like to sell?");
                System.out.print("Model: ");
                model = scanner.nextLine();
                System.out.print("Make: ");
                make = scanner.nextLine();

                for(int i=0; i<Clients.size(); i++) {
                    if(Clients.get(i).id == owner_id) {
                        Clients.get(i).hasCar = false;
                        for(int j=0; j<Vehicles.size(); j++) {
                            if((Vehicles.get(j).model == model) && (Vehicles.get(j).make == make)) {
                                Vehicles.remove(j);
                            }
                        }
                    }
                }

                System.out.println("Car sold!");

                System.out.println("\n");
                break;

            case 6:
                System.out.println("---------------List car owners---------------");
                System.out.println("Listing car owners list...");

                boolean isEmptyVehicle = Vehicles.isEmpty();
                if(isEmptyVehicle) {
                    System.out.println("No entries found!");
                } else {
                    for(int i=0; i<Clients.size(); i++) {
                        if(Clients.get(i).hasCar) {
                            for(int j=0; j<Vehicles.size(); j++) {
                                if(Clients.get(i).id == Vehicles.get(j).owner_id) {
                                    System.out.println(Clients.get(i).name+" owns a "+Vehicles.get(j).model+" "+Vehicles.get(j).make);
                                }
                            }
                        }
                    }
                }

                System.out.println("\n");
                break;

            default:
                System.out.println("NaN");
                break;
        }
    }

}
