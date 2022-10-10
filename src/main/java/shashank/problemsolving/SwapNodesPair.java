package shashank.problemsolving;

public class SwapNodesPair {

    // Leetcode 24

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node4);

        System.out.println("Head before : ");
        head.show();

        System.out.println("Head after : ");
        swapPairs(head).show();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = current.next;
            current.next = second;
            current = current.next.next;
        }
        return dummy.next;
    }


    public static ListNode swapFirstTwoNodes(ListNode head) {
        ListNode temp1 = head.next;
        ListNode temp2 = head.next.next;
        head.next = temp2;
        temp1.next = head;
        head = temp1;
        return head;
    }


    /**
     * O/P :
     *
     * Head before :
     * 1-->2-->3-->4-->5
     * Head after :
     * 2-->1-->4-->3-->5
     *
     */
}



