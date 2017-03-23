package Q1_1_Is_Unique;

/**
 * Is Unique: Implement an algorithm to determine if the string has all unique characters.
 * What if you cannot use additional data structures?
 */

public class Question {

    /* using addition array of boolean values, where the flag at index i indicates
       whether the character i in the alphabet is contained in the string.
       Space complexity: O(1), Time complexity: O(n)(or O(1) as the loop will never run more than 128 times) */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (char c : str.toCharArray()) {
            if (charSet[c]) return false;
            charSet[c] = true;
        }

        return true;
    }

    /* we can reduce space usage by a factor of eight by using a bit vector.
       we will assume in below code, that the string uses lowercase letters a through z. */
    public static boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= 1 << val;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "12344", "12345", " "};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word) + "--" + isUniqueChars2(word));
        }
    }
}