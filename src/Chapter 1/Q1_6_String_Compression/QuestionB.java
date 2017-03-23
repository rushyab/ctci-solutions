package Q1_6_String_Compression;

public class QuestionB {

    public static String compressCount(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString.append(str.charAt(i));
                compressedString.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    public static void main(String[] args) {
        String[] str = {"aaabccddeeeeee", "aaabbbbcaaa", "Aaaaaabbc", "aabbc"};
        for (String s : str) {
            System.out.println(s + " - > " + compressCount(s));
        }
    }
}
