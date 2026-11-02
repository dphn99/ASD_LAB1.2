import models.Circle;
import structures.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        table.insert(new Circle(2, 4, 5));
        table.insert(new Circle(7, 8, 5));
        table.insert(new Circle(1, 3, 5));

        Circle found = table.search(new Circle(7, 8, 5));
        System.out.println("Found: " + found);

        table.print();
    }
}
