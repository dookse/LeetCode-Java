package problems.easy;

import java.util.Objects;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 206. Reverse Linked List
public class P206 {

    public ListNode reverseList(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    @Test
    public void test1() {
        ListNode inputList = new ListNode(1);
        inputList.next = new ListNode(2);
        inputList.next.next = new ListNode(3);
        inputList.next.next.next = new ListNode(4);
        inputList.next.next.next.next = new ListNode(5);

        ListNode resultList = new ListNode(5);
        resultList.next = new ListNode(4);
        resultList.next.next = new ListNode(3);
        resultList.next.next.next = new ListNode(2);
        resultList.next.next.next.next = new ListNode(1);
        resultList.next.next.next.next.next = null;

        ListNode actual = reverseList(inputList);
        assertThat(actual).isEqualTo(resultList);
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(final int x) {
        val = x;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
            Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}


