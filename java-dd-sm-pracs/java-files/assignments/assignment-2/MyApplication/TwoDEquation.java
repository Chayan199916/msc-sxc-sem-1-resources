package Mathematics.algebra;

public class TwoDEquation {

    private double degree_x2;
    private double degree_x;
    private double constant;

    public TwoDEquation(double degree_x2, double degree_x, double constant) {
        this.degree_x2 = degree_x2;
        this.degree_x = degree_x;
        this.constant = constant;
    }

    double getDeterminant() {
        return degree_x * degree_x - 4 * degree_x2 * constant;
    }

    public double getPositiveRoot() throws Exception {
        double determinant = getDeterminant();
        if (determinant > 0)
            return Math.round((-degree_x + Math.sqrt(determinant)) / (2 * degree_x2));
        else
            throw new Exception("No such real positive root present");
    }

}
