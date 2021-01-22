
/**
 * Write a Java program to check whether all the strings passed as command line arguments are unique or
not. If any duplicate string is present, raise a user-defined exception. Also find the frequency of the
words starting with any vowel present in a set of words passed as command line arguments.
 */

import java.util.Arrays;

class CMSM4157_4 {
    static int countStringsStartingWithVowels(String args[]) {
        int vowelcounter = 0;
        String vowels[] = { "a", "e", "i", "o", "u" };
        for (int i = 0; i < args.length; i++) {
            String firstletter = args[i].substring(0, 1).toLowerCase();
            if (Arrays.toString(vowels).contains(firstletter))
                vowelcounter++;
        }
        return vowelcounter;
    }

    static void duplicacyCheckInArguments(String args[]) {
        String temp = "";
        int checkvar = 0;
        try {
            for (int i = 0; i < args.length; i++) {
                temp = args[i];
                checkvar = 0;
                for (int j = 0; j < args.length; j++) {
                    if (temp.equalsIgnoreCase(args[j]) == true) /* Case insensitive duplicacy checking */
                        checkvar++;
                }
            }
            if (checkvar > 1)
                throw new DuplicateArgumentsException("Duplicate string is present");
        } catch (Exception e) {
            e.printStackTrace(); /* printing stack trace of the instance */
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        duplicacyCheckInArguments(args);
        System.out
                .println("The frequency of words starting with any vowel is : " + countStringsStartingWithVowels(args));
    }
}

class DuplicateArgumentsException extends Exception { /* User defined exception class */
    DuplicateArgumentsException(String s) {
        super(s);
    }
}