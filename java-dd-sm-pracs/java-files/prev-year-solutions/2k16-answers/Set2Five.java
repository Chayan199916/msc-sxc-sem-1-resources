abstract class Number {
    int n;

    Number(int n) {
        this.n = n;
    }

    abstract void displayNum();
}

class HexNum extends Number {

    String hex;

    HexNum(int n) {
        super(n);
        this.hex = Integer.toHexString(n);
    }

    void displayNum() {
        System.out.println("The hexadecimal equivalent is:" + hex);
    }
}

class OctalNum extends Number {

    String oct;

    OctalNum(int n) {
        super(n);
        this.oct = Integer.toOctalString(n);
    }

    void displayNum() {
        System.out.println("The octal equivalent is:" + oct);
    }

}

class Set2Five {
    public static void main(String args[]) {
        int num = Integer.parseInt(args[args.length - 1]);
        Number hexObj = new HexNum(num);
        Number octObj = new OctalNum(num);
        hexObj.displayNum();
        octObj.displayNum();
    }
}