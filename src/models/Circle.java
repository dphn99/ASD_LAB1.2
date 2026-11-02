package models;

public class Circle {
    private final double x;
    private final double y;
    private final double radius;

    public Circle(double x, double y, double radius) {
        if (!Double.isFinite(radius) || radius < 0) {
            throw new IllegalArgumentException("Radius must be finite and non-negative.");
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return """
                Circle:
                  Center:    (%.2f, %.2f)
                  Radius:    %.2f
                  Area:      %.2f
                  Perimeter: %.2f
                """.formatted(x, y, radius, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Circle other)) {
            return false;
        }

        return Double.compare(x, other.x) == 0
                && Double.compare(y, other.y) == 0
                && Double.compare(radius, other.radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(radius);
        return result;
    }
} 
