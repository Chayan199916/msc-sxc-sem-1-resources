class Main{

    private static void checkString(String args[]){

        for(String indivString : args){

            if(indivString.indexOf("e") != -1)
                System.out.println(indivString);

        }

    }
    public static void main(String[] args) {
        
        checkString(args);

    }

}