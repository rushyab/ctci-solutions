package Q1_4_Permutation_Palindrome;

/**
 * Permutation Palindrome: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 */

public class QuestionA {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int table[] = getFrequencyCount(phrase);
        return countMaxOneOdd(table);
    }

    private static boolean countMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd)   return false;
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] getFrequencyCount(String phrase) {
        int[] letters = new int[26];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                letters[x]++;
            }
        }
        return letters;
    }

    private static int getCharNumber(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a';
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A';
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] str = {"ABCDE", "Aa BB CC DD E", "aa bb cc d", "AA bb cc d e", "Level", "Noon"};
        for (String s : str) {
            if (isPermutationOfPalindrome(s)) System.out.format("%-15s -> TRUE\n", s);
            else                              System.out.format("%-15s -> FALSE\n", s);
        }
    }
}
