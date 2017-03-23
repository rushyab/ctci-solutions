package Q1_5_One_Away;

public class QuestionB {

    public static boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0, index2 = 0;
        boolean foundOdd = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundOdd) return false;
                foundOdd = true;

                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // On replace, move shorter pointer
            }
            index2++; // Always move pointer for longer string
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
