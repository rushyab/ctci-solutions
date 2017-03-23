package Q1_2_Check_Permutation;

public class QuestionB {

    public static boolean permutation(String s, String t) {

        if (s.length() != t.length()) return false;

        int letters[] = new int[128]; // ASCII assumption

        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int v = t.charAt(i);
            letters[v]--;
            if (letters[v] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"hello", "hell"}, {"apple", "leppa"}, {"smith", "htims"}, {"neo", "eoh"}, {" ", " "}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
