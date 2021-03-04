import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static String[][] text = new String[12][1];
    private static String[] spiltArr = new String[12];
    private static File file = new File("src/data.txt");

    public static void main(String[] args) throws FileNotFoundException {


//        spiltAtSpace();
//        longestSentence();

//        printWordStartingWith("K");
//        printWordOfLength(3);
//        printWordsWithDoubleConsonant();
//  printPartOfWord("københavn", 6, 4);

        printIfPalindrome("du er Freud");
    }

    //TaskFour
    private static void printIfPalindrome(String s) {
        int i = 0;
        int j;
        boolean isPalindrome = true;

        String checkString;
        checkString = s.toLowerCase();
        checkString = checkString.replaceAll(" ", "");

        j = checkString.length() - 1;


        while (i < j) {

            if (checkString.charAt(i) != checkString.charAt(j)) {
                isPalindrome = false;
            }

            i++;
            j--;
        }

        if (isPalindrome) {
            System.out.println(s);
            System.out.println("is Palindrome");
        } else {
            System.out.println("is not Palindrome");
        }
    }

    //TaskThree
    private static void printPartOfWord(String ord, int startIndex, int antalBogstaver) {
        String partOfWord = "";
        try {
            partOfWord = ord.substring(startIndex, startIndex + antalBogstaver);
            System.out.println(partOfWord);
        } catch (StringIndexOutOfBoundsException e) {
            if (startIndex + antalBogstaver > ord.length()) {
                System.out.println("For Stor mængde bogstaver angivet");
            }
            System.out.println(partOfWord);
        }
    }

    //TaskTwo
    private static void longestSentence() throws FileNotFoundException {
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            spiltArr = scan.nextLine().split("//. ");
        }
        for (String s : spiltArr) {
            System.out.println(s);
        }
    }

    private static void spiltAtSpace() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine()) {
            text[i] = scan.nextLine().split(" ");
            i++;
        }
    }

    //TaskOne
    private static void printWordsWithDoubleConsonant() {
        for (String[] strings : text) {
            for (String s : strings) {
                for (int i = 1; i < s.length(); i++) {
                    s = s.replaceAll("[.,]", "");
                    if (isAlphabet(s)) {
                        if (s.charAt(i) == s.charAt(i - 1)) {
                            System.out.println(s);
                        }
                    }
                }
            }
        }
    }

    private static boolean isAlphabet(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }


    private static void printWordOfLength(int l) {
        boolean wordIsValid = true;
        for (String[] strings : text) {
            for (String s : strings) {
                if (s.length() == l) {
                    if (s.contains(".") || s.contains(",")) {
                        wordIsValid = false;
                    }
                    if (wordIsValid) {
                        System.out.println(s);
                    }
                }
            }

        }
    }


    private static void printWordStartingWith(String pattern) {
        for (String[] strings : text) {
            for (String s : strings) {
                if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                    System.out.println(s);
                }
            }
        }
    }
}