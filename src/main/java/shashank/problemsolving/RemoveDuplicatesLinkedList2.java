package shashank.problemsolving;

public class RemoveDuplicatesLinkedList2 {

    // Leetcode 82

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode head = new ListNode(1, node4);

        System.out.println("Head before : ");
        head.show();

        System.out.println("Head after : ");
        deleteDuplicates(head).show();
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode ref = head;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                curr = curr.next;
                prev = prev.next;
            } else {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                prev.next = curr;
            }
        }

        return dummy.next;
    }
}

/**
 *
 * O/P :
 *
 * Head before :
 * 1-->1-->1-->2-->3
 * Head after :
 * 2-->3
 *
 *
 */


