/**
 * Write a Java program that creates an abstract class called ‘Number’. This
 * class holds an integer as its data member and a suitable method to initialize
 * it. This class also contains an abstract method called displayNum( ). Create
 * two derived classes called ‘HexNum’ and ‘OctalNum’ that inherit ‘Number’.
 * Override displayNum ( ) in the derived classes so that it displays the value
 * in Hexadecimal and Octal, respectively. Write a main ( ) function to create
 * objects of type ‘HexNum’ and ‘OctalNum’ classes and display the hexadecimal
 * and octal form of the supplied integer value. Use dynamic method dispatch
 * feature to execute the program.
 */

abstract class Number {
    int number;

    Number(int number) {
        this.number = number;
    }

    abstract void displayNum();
}

class HexNum extends Number {

    String hex;

    HexNum(int number) {
        super(number);
        this.hex = Integer.toHexString(number);
    }

    void displayNum() {
        System.out.println("The hexadecimal equivalent is : " + hex.toUpperCase());
    }
}

class OctalNum extends Number {

    String oct;

    OctalNum(int number) {
        super(number);
        this.oct = Integer.toOctalString(number);
    }

    void displayNum() {
        System.out.println("The octal equivalent is : " + oct);
    }

}

class CMSM4157_6 {
    public static void main(String args[]) {
        int num = Integer.parseInt(args[args.length - 1]);
        Number hexObj = new HexNum(num); /* dynamic method dispatch; super class reference; sub class object type */
        Number octObj = new OctalNum(num); /* dynamic method dispatch; super class reference; sub class object type */
        System.out.println("Hexadecimal form : ");
        hexObj.displayNum();
        System.out.println("Octal form : ");
        octObj.displayNum();
    }
}