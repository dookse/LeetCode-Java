package explore.challenge30day.week2;

import org.junit.jupiter.api.Test;

import lombok.EqualsAndHashCode;

import static org.assertj.core.api.Assertions.assertThat;

public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode output = middleNode(head);
        assertThat(output.val).isEqualTo(3);
        assertThat(output.next.val).isEqualTo(4);
        assertThat(output.next.next.val).isEqualTo(5);
        assertThat(output.next.next.next).isNull();
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode output = middleNode(head);
        assertThat(output.val).isEqualTo(4);
        assertThat(output.next.val).isEqualTo(5);
        assertThat(output.next.next.val).isEqualTo(6);
        assertThat(output.next.next.next).isNull();
    }

    @EqualsAndHashCode
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
