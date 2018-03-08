package Q1_9_String_Rotation;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is substring of another.
 * Given two strings s1 and s2, write code to check if s2 is a rotation of s1 using one call to isSubstring
 * (eg.,"watterbottle" is a rotation of "erbottlewat").
 */

public class Question {
    private static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) { // can also use "big.contains(small)", return boolean
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {

        String[][] strArr = {{"waterbottle", "erbottlewat"}, {"keys", "ysek"}, {"data", "tada"}, {" ", " "}, {"", " "}};

        for (String[] s: strArr) {
            if(isRotation(s[0], s[1])) System.out.println(s[0]+", "+s[1]+ ": Yes");
            else System.out.println(s[0]+", "+s[1]+ ": No");
        }
    }
}

/*
o/p:
waterbottle, erbottlewat: Yes
keys, ysek: No
data, tada: Yes
 ,  : Yes
,  : No
 */