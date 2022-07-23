import java.util.ArrayList;
import java.util.Scanner;
public class Client {

    public static ArrayList<Client> Clients = new ArrayList<>();

    String name;
    int age;
    int id;
    int numberOfCars;
    boolean hasCar = false;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Constructor of the class Client
     * @param name - the name of the client
     * @param age - the age of the client
     * @param id - id of the client
     */
    public Client(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /**
     * Getter method, returns the Clients arraylist
     * @return - the arraylist
     */
    public static ArrayList<Client> getList() {
        return Clients;
    }

    /**
     * Adds a new client to the array of clients.
     * @param name - the name of the client
     * @param age - the age of the client
     * @param id - id of the client
     */
    public static void addEntry(String name, int age, int id) {
        for(int i=0; i<Clients.size(); i++) {
            while(Clients.get(i).id == id) {
                System.out.print("This ID number is already taken! Please enter a new one: ");
                id = scanner.nextInt();
                scanner.nextLine();
            }
        }

        Client client = new Client(name, age, id);
        Clients.add(client);
    }

    /**
     * Deletes a user from the array of clients.
     * @param id_temp - the temporary integer which specifies the client to be deleted
     */
    public static void deleteEntry(int id_temp) {
        for(int i=0; i<Clients.size(); i++) {
            while(!(Clients.get(i).id == id_temp)) {
                System.out.print("This user does not exist! Please enter the ID again: ");
                id_temp = scanner.nextInt();
                scanner.nextLine();
            }
            if(Clients.get(i).id == id_temp) {
                Clients.remove(i);
                System.out.println("User deleted!");
            }
        }
    }

    /**
     * Lists the contents of the client arraylist (a.k.a. the users)
     */
    public static void listEntries() {
        boolean isEmpty = Clients.isEmpty();
        if(isEmpty) {
            System.out.println("No entries found!");
        } else {
            for(int i=0; i<Clients.size(); i++) {
                System.out.println("Client #"+(i+1)+": "+Clients.get(i).name+", "
                                                        +Clients.get(i).age+" years old"
                                                        +"\nID number: "+Clients.get(i).id
                                                        +"\nOwns a car? "+Clients.get(i).hasCar
                                                        +"\n");
            }
        }
    }

}
