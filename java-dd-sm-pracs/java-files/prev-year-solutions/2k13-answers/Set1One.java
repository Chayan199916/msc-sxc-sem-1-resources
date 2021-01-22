class Set1One {
    static void check(int x) throws SameArgumentsException {
        if (x > 1)
            throw new SameArgumentsException("Repetition of arguments not allowed");
        else
            System.out.println();
    }

    public static void main(String args[]) {
        int counter = 0;
        String s = "TH";
        // ensuring there is no repetition of any command line arguments
        try {
            for (int i = 0; i < args.length; i++) {
                String store = args[i];
                int c = 0;
                for (int j = 0; j < args.length; j++) {

                    if (store.equalsIgnoreCase(args[j]) == true)
                        c++;
                }
                check(c);
            }
        } catch (Exception e) {
            System.out.println("Exception occured:" + e);
            System.exit(0);
        }
        for (int i = 0; i < args.length; i++) {
            String ext = args[i].substring(0, 2);
            if (s.equals(ext) == true)
                counter++;
        }
        System.out.println("The number of words starting with TH are:" + counter);
    }
}

class SameArgumentsException extends Exception {
    SameArgumentsException(String s) {
        super(s);
    }
}