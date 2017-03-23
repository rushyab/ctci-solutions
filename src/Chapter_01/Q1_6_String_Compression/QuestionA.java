package Q1_6_String_Compression;

/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You can assume the string has only
 * uppercase(A-Z) and lowercase letters(a-z).
 */

public class QuestionA {

    public static String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString : str;
    }

    public static void main(String[] args) {
        String[] str = {"aaabccddeeeeee", "aaabbbbcaaa", "Aaaaaabbc", "aabbc"};
        for (String s : str) {
            System.out.println(s + " - > " + compressBad(s));
        }
    }
}
