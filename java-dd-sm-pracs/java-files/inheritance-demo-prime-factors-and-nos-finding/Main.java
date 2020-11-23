class Main {

    public static void main(String[] args) {
        
        int num = Integer.parseInt(args[args.length - 1]);
        PrimeFactorsFinder primeFactorsFinder = new PrimeFactorsFinder();
        primeFactorsFinder.setNum(num);
        primeFactorsFinder.findPrimeFactors();
        PrimeNumbersFinder primeNumbersFinder = new PrimeNumbersFinder();
        primeNumbersFinder.setNum(num);
        primeNumbersFinder.findPrimeNumbers();

    }
    
}

class NumberHandler{

    private int num;

    public void setNum(int num) {

        this.num = num;
    
    }
    public int getNum() {

        return num;
    
    }
    boolean checkPrime(int number){

        for(int i = 2; i <= Math.sqrt(Double.parseDouble(number + "")); i++){

            if(number % i == 0){

                return false;

            }

        }
        return true;

    }

}

class PrimeFactorsFinder extends NumberHandler{

    void findPrimeFactors(){

        System.out.println("All the prime factors are : ");

        for(int i = 2; i < getNum(); i++){

            if(getNum() % i == 0 && checkPrime(i))
                System.out.print(i + " ");

        }
        System.out.println();

    }

}
class PrimeNumbersFinder extends NumberHandler{

    void findPrimeNumbers(){

        System.out.println("All the prime numbers smaller are : ");
        
        for(int i = 2; i < getNum(); i++){

            if(checkPrime(i))
                System.out.print(i + " ");

        }
        System.out.println();

    }

}