package Q1_3_URLify;

/**
 * URLify: write a method to replace all spaces with '%20d'. You may assume that string has sufficient space
 * at the end to hold additional characters, and that you are given true length of the string.
 * If implementing in java use a character arrays, because java strings are immutable.
 */

public class Question {

    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, newLength;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        newLength = trueLength + (spaceCount * 2);

        for (int i = newLength; i < str.length; i++) str[i] = '\0';

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength-1] = str[i];
                newLength--;
            }
        }
    }

    private static int findLastChar(char[] str) {
        for (int i = str.length-1; i >= 0; i--) {
            if (str[i] != ' ')   return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith       ";
        char[] arr = str.toCharArray();

        int trueLength = findLastChar(arr) + 1;

        replaceSpaces(arr, trueLength);
        System.out.println(arr);
    }
}
