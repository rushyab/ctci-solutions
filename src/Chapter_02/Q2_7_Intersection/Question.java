package Q2_7_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is based on reference, not value.
 * That is, if the Kth node of the first linked list is the exact same node (by reference) as
 * the Jth node of the second linked list, then they are intersecting.
 */

public class Question {

    private static class Result {
        private LinkedListNode tail;
        private int size;
        private Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        /* If any of the list is empty return null. */
        if (list1 == null || list2 == null) return null;

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no Intersection. */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 :list1;

        /* Advance the pointer for longer linked list by difference in lengths */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        /* Return either one. */
        return longer;
    }

    private static Result getTailAndSize(LinkedListNode head) {
        if (head == null) return null;

        int size = 0;
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        return new Result(current, size);
    }

    private static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] vals = {1, 4, 6, 7, 8, 10, 2};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {3, 3, 5};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        /* 1 -> 4 -> 6 -
                        \
                         -> 7 -> 8 -> 10 -> 2
                        /
           3 -> 3-> 5 -                        */
        list2.next.next.next = list1.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());

        LinkedListNode Intersection = findIntersection(list1, list2);

        System.out.println(Intersection.printForward());
    }
}
