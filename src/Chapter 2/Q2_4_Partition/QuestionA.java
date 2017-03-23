package Q2_4_Partition;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 * Partition: write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than x. If x is contained within the list,
 * the values of x only need to be after the elements less than x. The partition element x
 * can appear anywhere in the "right partition"; it does not need to appear between the left
 * and right partitions.
 */

public class QuestionA {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

		/* Partition list */
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

		/* Merge before list and after list */
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args) {
		/* Create linked list */
        int[] arr = {29, 9, 2, 3, 10, 332, 838, 44, 5};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(arr);

        System.out.println(head.printForward());

		/* Partition */
        LinkedListNode h = partition(head, 12);

		/* Print Result */
        System.out.println(h.printForward());
    }
}
