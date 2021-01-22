/* Write a Java program to do the following:
i. Accept a sentence as in command line.
ii. Display the accepted sentence.
iii. Input a word from the user.
iv. Replace each occurrence of a particular word from the accepted sentence by the newly input word.
v. Display the modified sentence along with the positions where modifications have been done.
*/

import java.util.*;

class CMSM4157_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word with which replacement would be done : ");
        String presentword = scanner.nextLine();
        System.out.println("Enter the word to be replaced");
        String newword = scanner.nextLine();
        Replacer replacer = new Replacer(args[0], newword, presentword);
        replacer.replaceWord();
        scanner.close();
    }
}

class Replacer {
    private String sentence;
    private String replacedword;
    private String presentword;
    private int modifiedpos[];

    Replacer(String sentence, String replacedword, String presentword) {
        this.sentence = sentence;
        this.replacedword = replacedword;
        this.presentword = presentword;
        this.modifiedpos = new int[sentence.trim()
                .split(" ").length]; /* max size of pos array could be the no of words in the sentence */
    }

    void displaySentence(String sentence) {
        System.out.println(sentence);
    }

    void displayPositions(int positions[], int limit) {
        System.out.println("Modified positions are : ");
        for (int i = 0; i < limit; i++)
            System.out.print(positions[i] + " ");
    }

    void replaceWord() {
        String newsentence = "";
        int pos = 0;
        int startingindex = 0; /* so that replacement goes beyond first word */
        String words[] = sentence.split(" ");
        System.out.println("Sentence before modification : ");
        displaySentence(sentence);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(presentword) == true) { /* case insensitive word replacing */
                newsentence += replacedword + " ";
                startingindex = sentence.indexOf(words[i], startingindex);
                modifiedpos[pos++] = startingindex;
                startingindex += words[i].length();
            } else {
                newsentence += words[i] + " ";
            }
        }
        System.out.println("Sentence after modification : ");
        displaySentence(newsentence.trim());
        displayPositions(modifiedpos, pos);
    }
}