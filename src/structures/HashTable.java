package structures;

import models.Circle;

public class HashTable {
    private final Circle[] elements;
    private static final double A = (Math.sqrt(5) - 1) / 2;

    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }

        elements = new Circle[capacity];
    }

    //key is the circle's area in our case
    private int hash(double key) {
        double product = key * A;
        double fractionalPart = product - Math.floor(product);

        return (int) (elements.length * fractionalPart);
    }

    public void insert(Circle circle) {
        if (circle == null) {
            throw new IllegalArgumentException("Circle must not be null.");
        }

        int initialIndex = hash(circle.getArea());

        for (int i = 0; i < elements.length; i++) {
            int index = (initialIndex + i * i) % elements.length;

            if (elements[index] == null) {
                elements[index] = circle;
                return;
            }
        }

        throw new IllegalStateException("No available slot found in the hash table.");
    }

    public Circle search(Circle target) {
        if (target == null) {
            throw new IllegalArgumentException("Target circle must not be null.");
        }

        int initialIndex = hash(target.getArea());

        for (int i = 0; i < elements.length; i++) {
            int index = (initialIndex + i * i) % elements.length;
            Circle current = elements[index];

            if (current == null) {
                return null;
            }

            if (current.equals(target)) {
                return current;
            }
        }

        return null;
    }

    public void print() {
        for (int i = 0; i < elements.length; i++) {
            System.out.printf("[%d] %s%n", i,
                    elements[i] == null ? "Empty" : elements[i]);
        }
    }
}
