import java.util.Scanner;
public class Menu {
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
        System.out.println("7) Load test values");
    }

    private int getMP() {
        Scanner scanner = new Scanner(System.in);
        int mp = -1;
        while(mp < 0 || mp > 9) {
            try {
                System.out.print("\nEnter the selected menu point: ");
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

                Client.addEntry(name, age, id);

                System.out.println("\n");
                break;

            case 2:
                System.out.println("---------------Delete entry---------------");
                System.out.print("Type in the ID number of the user you'd like to delete: ");
                int id_temp = scanner.nextInt();
                scanner.nextLine();

                Client.deleteEntry(id_temp);

                System.out.println("\n");
                break;
            case 3:
                System.out.println("---------------List entries---------------");
                System.out.println("Listing entries...");

                Client.listEntries();

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

                Vehicle.buyVehicle(model, make, year, owner_id);

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

                Vehicle.sellVehicle(owner_id, model, make);

                System.out.println("\n");
                break;

            case 6:
                System.out.println("---------------List car owners---------------");
                System.out.println("Listing car owners list...");

                Vehicle.listOwners();

                System.out.println("\n");
                break;

            case 7:
                System.out.println("---------------Load test values---------------");
                System.out.println("Loading test values...");

                Client.loadTestValues();
                Vehicle.loadTestValues();

                System.out.println("\n");
                break;

            default:
                System.out.println("NaN");
                break;
        }
    }

}
