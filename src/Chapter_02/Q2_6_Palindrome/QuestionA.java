package Q2_6_Palindrome;

import CtCILibrary.LinkedListNode;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */

public class QuestionA {

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null || two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return (one == null && two == null);
    }

    public static void main(String[] args) {
        int length = 10;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));

        nodes[3].data = 6;
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}

