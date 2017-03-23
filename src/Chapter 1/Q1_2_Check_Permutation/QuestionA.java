package Q1_2_Check_Permutation;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * Comparison is case sensitive and white spaces are significant. so "god    " is different from "dog".
 */

public class QuestionA {

    private static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static Boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        return sort(s).equals(sort(t));
    }

    public static void main(String[] args) {
        String[][] pairs = {{"hello", "hell"}, {"apple", "leppa"}, {"smith", "htims"}, {"neo", "eoh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
