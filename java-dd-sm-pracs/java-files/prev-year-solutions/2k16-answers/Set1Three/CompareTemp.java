import java.util.Scanner;

import Centigrade.Centigrade;
import Farenheit.Farenheit;

class CompareTemp {
    static void compare(Centigrade centigrade, Farenheit farenheit) {
        if (centigrade.getTemp() == (farenheit.getTemp() - 32) * 5 / 9) {
            System.out.println("Same temp value in diff scale");
        } else {
            System.out.println("Diff temp value in diff scale");
        }
    }

    public static void main(String[] args) {
        Double tempCentigrade;
        Double tempFarenheit;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the centigrade scale temp : ");
        tempCentigrade = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the farenheit scale temp : ");
        tempFarenheit = Double.parseDouble(sc.nextLine());
        Centigrade centigrade = new Centigrade(tempCentigrade);
        Farenheit farenheit = new Farenheit(tempFarenheit);
        compare(centigrade, farenheit);
    }
}
