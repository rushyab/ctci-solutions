package Q2_1_Remove_Dups;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from a unsorted linked list.
 * FOLLOW UP
 * How would you solve this if a temporary buffer is not allowed?
 */

public class QuestionA {
    public static void deleteDuplicates(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDuplicates(head);
        System.out.println(head.printForward());
    }
}