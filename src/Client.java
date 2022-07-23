import java.util.Scanner;
public class Client {

    String name;
    int age;
    int id;
    boolean hasCar = false;
    Scanner scanner = new Scanner(System.in);

    Client(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

}
