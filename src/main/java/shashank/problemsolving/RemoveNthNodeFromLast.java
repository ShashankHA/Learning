package shashank.problemsolving;

public class RemoveNthNodeFromLast {

    // leetcode -19

    /**
     * O/P:
     * Head before :
     * 1-->4-->5-->2-->3
     * Head after :
     * 1-->4-->2-->3
     */


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(5, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode head = new ListNode(1, node4);

        System.out.println("Head before : ");
        head.show();

        System.out.println("Head after : ");
        removeNthFromEnd(head, 3).show();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev;
        prev = dummy;

        ListNode runner1 = head;
        ListNode runner2 = head;

        int count = 1;

        while (count <= n) {
            runner1 = runner1.next;
            count++;
        }

        while (runner1 != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }


}
