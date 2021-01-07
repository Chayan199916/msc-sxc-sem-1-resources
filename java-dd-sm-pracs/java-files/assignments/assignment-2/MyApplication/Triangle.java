package Mathematics.geometry;

public class Triangle {
    private double side;

    public Triangle(double side) {
        this.side = side;
    }

    public double getArea() {
        return Math.round(Math.sqrt(3) / 4 * side * side);
    }

    public double getPerimeter() {
        return Math.round(3 * side);
    }

    public double getSide() {
        return side;
    }
}