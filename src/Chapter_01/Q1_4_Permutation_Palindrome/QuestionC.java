package Q1_4_Permutation_Palindrome;

public class QuestionC {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return (bitVector == 0) || checkExactlyOneBitSet(bitVector);
    }

    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int getCharNumber(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a';
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A';
        }
        return -1;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) {
        String[] str = {"ABCDE", "Aa BB CC DD E", "aa bb cc d", "aa bb cc d e", "Level", "Noon"};
        for (String s : str) {
            if (isPermutationOfPalindrome(s)) System.out.format("%-15s -> TRUE\n", s);
            else                              System.out.format("%-15s -> FALSE\n", s);
        }
    }
}
