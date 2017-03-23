package Q1_4_Permutation_Palindrome;

public class QuestionB {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int oddCount = 0;
        int[] table = new int[26];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
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
        String[] str = {"ABCDE", "Aa BB CC DD E", "aa bb cc d", "Aa bb cc d e", "Level", "Noon"};
        for (String s : str) {
            if (isPermutationOfPalindrome(s)) System.out.format("%-15s -> TRUE\n", s);
            else                              System.out.format("%-15s -> FALSE\n", s);
        }
    }

}
