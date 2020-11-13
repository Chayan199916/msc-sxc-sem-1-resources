class Main {

    private static void countWord(String sentence, String word) {

        int countWord = 0;
        String words[] = sentence.split(" ");
        for (String indivWord : words) {

            if (indivWord.compareToIgnoreCase(word) == 0)
                countWord++;

        }
        System.out.println("# of times " + word + " has occured is : " + countWord);

    }

    public static void main(String[] args) {

        String word = "element";
        countWord(args[args.length - 1], word);

    }

}
