class StringHandler {
    
    private static void performSorting(String args[]){

        int j;
        String temp = new String();
        System.out.println("Array before sorting...");
        display(args);
        for(int i = 1; i < args.length; i++){

            temp = args[i];
            j = i - 1;
            while(j > 0 && args[j].compareTo(temp) > 0){

                args[j + 1] = args[j];
                j--;

            }
            args[j + 1] = temp;

        }
        System.out.println("Array after sorting...");
        display(args);

    }
    private static void display(String args[]){
        
        for(String indivsString : args)
        System.out.print(indivsString + " ");
        System.out.println();

    }
    public static void main(String[] args) {
        
        performSorting(args);

    }

}

