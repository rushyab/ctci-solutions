package Q2_2_Return_Kth_To_Last;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionB {

    public static class Index {
        int value = 0;
    }

    public static LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    private static LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
        if (head == null) return null;

        LinkedListNode nd = kthToLast(head.next, k, idx);
        idx.value += 1;
        if (idx.value == k) {
            return head;
        }
        return nd;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            LinkedListNode node = kthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}

