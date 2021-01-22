
import Mathematics.geometry.Rectangle;
// import Mathematics.geometry.Triangle;
// import Mathematics.algebra.TwoDEquation;

class Demo {
    public static void main(String[] args) throws Exception {
        // Triangle class demo
        // Triangle triangle = new Triangle(Double.parseDouble(args[args.length - 1]));
        // System.out.println("Area : " + triangle.getArea());
        // System.out.println("Perimeter : " + triangle.getPerimeter());
        // System.out.println("Side : " + triangle.getSide());

        // Rectangle class demo
        Rectangle rectangle = new Rectangle(Double.parseDouble(args[0]), Double.parseDouble(args[args.length - 1]));
        System.out.println("Area : " + rectangle.getArea());
        System.out.println("Perimeter : " + rectangle.getPerimeter());
        System.out.println("Length : " + rectangle.getLength());
        System.out.println("Width : " + rectangle.getWidth());

        // TwoDEquation class demo
        // TwoDEquation twoDEquation = new TwoDEquation(Double.parseDouble(args[0]),
        // Double.parseDouble(args[1]),
        // Double.parseDouble(args[args.length - 1]));
        // System.out.println("Positive root : " + twoDEquation.getPositiveRoot());
    }
}