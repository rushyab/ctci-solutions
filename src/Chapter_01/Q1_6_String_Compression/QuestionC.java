package Q1_6_String_Compression;

public class QuestionC {

    public static String compressCount(String str) {
        int newLength = countCompression(str);

        if (newLength >= str.length())  return str;

        StringBuilder compressedString = new StringBuilder(newLength);

        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString.append(str.charAt(i));
                compressedString.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressedString.toString();
    }


    private static int countCompression(String str) {
        int countLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                countLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return countLength;
    }

    public static void main(String[] args) {
        String[] str = {"aaabccddeeeeee", "aaabbbbcaaa", "Aaaaaabbc", "aabbc"};
        for (String s : str) {
            System.out.println(s + " - > " + compressCount(s));
        }
    }
}
