package Q1_5_One_Away;

/**
 * One Away: There are three types of edits that can be performed on strings: insert, remove or replace
 * a character. Given two strings, write a function to check if they are one edit(or zero edits) away.
 */

public class QuestionA {

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second .length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++; index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] strArr= {{"pale", "pal"}, {"Pale", "Bale"}, {"tell", "tall"}, {"sell", "sold"}};
        for (String[] str : strArr) {
            String first = str[0];
            String second = str[1];
            System.out.println(first + " -> " + second + ": " + oneEditAway(first, second));
        }
    }
}
