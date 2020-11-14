class Main{

    private static void sortNumbers(String args[]){

        int j, temp;
        System.out.println("Array before sorting : ");
        display(args);
        for(int i = 1; i < args.length; i++){

            j = i - 1;
            temp = Integer.parseInt(args[i]);
            while(j >= 0 && Integer.parseInt(args[j]) < temp){

                args[j + 1] = args[j];
                j--;

            }
            args[j + 1] = Integer.toString(temp);

        }
        System.out.println("Array after sorting : ");
        display(args);

    }
    private static void display(String args[]){

        for(String indivString : args)
            System.out.print(indivString + " ");
        System.out.println();

    }
    public static void main(String[] args) {
        
        sortNumbers(args);

    }

}