package Q2_6_Palindrome;

import CtCILibrary.LinkedListNode;

public class QuestionC {

    public static class Result {
        private LinkedListNode node;
        private boolean result;
        public Result(LinkedListNode n, boolean res) {
            node = n;
            result = res;
        }
    }

    public static boolean isPalindrome(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    private static Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) { // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) { // Odd number of nodes
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);

        /* If child calls are not a palindrome, pass back up
		 * a failure. */
        if (!res.result || res.node == null) {
            return res;
        }

		/* Check if matches corresponding node on other side. */
        res.result = (head.data == res.node.data);

		/* Return corresponding node. */
        res.node = res.node.next;

        return res;
    }

    private static int lengthOfList(LinkedListNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
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
