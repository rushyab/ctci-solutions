package Q2_5_Sum_Lists;

import CtCILibrary.LinkedListNode;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reversed order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */

public class QuestionA {

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int val = carry;
        if (l1 != null) {
            val += l1.data;
        }
        if (l2 != null) {
            val += l2.data;
        }
        result.data = val % 10;
        if (l1 != null || l2!= null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                            l2 == null ? null : l2.next,
                                             val >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    private static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1, 0);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.println(l1 + " + " + l2 + " = " + l3);
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }
}
