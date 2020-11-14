class Main {

    public static void main(String[] args) {

        Pattern pattern = new Pattern(args[args.length - 1]);
        pattern.displayFirstPattern();
        System.out.println();
        pattern.displaySecondPattern();
        System.out.println();
        pattern.displayThirdPattern();
        System.out.println();
        pattern.displayFourthPattern();

    }

}

class Pattern {

    private String pattern;

    Pattern(String pattern) {

        this.pattern = pattern;

    }

    void displayFirstPattern() {

        int j;
        for (int i = 0; i < pattern.length(); i++) {

            for(j = i; j < pattern.length(); j++){

                System.out.print(pattern.charAt(j) + " ");

            }
            System.out.println();

        }

    }

    void displaySecondPattern() {

        int j;
        for(int i = 0; i < pattern.length(); i++){

            for(j = 0; j <= i; j++)
                System.out.print(pattern.charAt(j) + " ");
            System.out.println();

        }

    }

    void displayThirdPattern() {

        int j;
        for(int i = 0; i < pattern.length(); i++){

            for(j = 0; j < pattern.length() - i; j++)
                System.out.print(pattern.charAt(j) + " ");
            System.out.println();

        }

    }

    void displayFourthPattern() {

        int j;
        for(int i = 0; i < pattern.length(); i++){

            for(j = pattern.length() - i - 1; j < pattern.length(); j++)
                System.out.print(pattern.charAt(j) + " ");
            System.out.println();

        }

    }

}