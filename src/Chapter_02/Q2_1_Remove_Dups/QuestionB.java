package Q2_1_Remove_Dups;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionB {

    public static void deleteDuplicates(LinkedListNode head) {
        LinkedListNode current  = head;
        while (current!= null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 9, 8, 8, 2, 3, 1, 2, 4, 5};

        LinkedListNode head = AssortedMethods.createLinkedListFromArray(arr);
        System.out.println(head.printForward());
        deleteDuplicates(head);
        System.out.println(head.printForward());
    }
}
