package Mathematics.geometry;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return Math.round(length * width);
    }

    public double getPerimeter() {
        return Math.round(2 * (length + width));
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}