package Q2_2_Return_Kth_To_Last;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 * Return Kth to last: Implement a algorithm to find the kth to last element of a singly linked list.
 */

public class QuestionA {

    public static int printKthToLast(LinkedListNode head, int k) {

        if (head == null) return 0;

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is: " + head.data);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 1; i <= array.length + 1; i++) {
            printKthToLast(head, i);
        }
    }
}
