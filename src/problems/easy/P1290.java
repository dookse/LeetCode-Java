package problems.easy;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


// 1290. Convert Binary Number in a Linked List to Integer
public class P1290 {

    public int getDecimalValue(final ListNode head) {
        StringBuilder binary = new StringBuilder();
        ListNode now = head;
        while (now != null) {
            binary.append(now.val);
            now = now.next;
        }
        return Integer.parseInt(binary.toString(), 2);
    }

    @Test
    public void test1() {
        ListNode head = makeListNode(asLinkedList(1, 0, 1));
        assertThat(getDecimalValue(head)).isEqualTo(5);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(0);
        assertThat(getDecimalValue(head)).isEqualTo(0);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        assertThat(getDecimalValue(head)).isEqualTo(1);
    }

    @Test
    public void test4() {
        ListNode head = makeListNode(asLinkedList(1, 0, 0, 1));
        assertThat(getDecimalValue(head)).isEqualTo(9);
    }

    @Test
    public void test5() {
        ListNode head = makeListNode(asLinkedList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0));
        assertThat(getDecimalValue(head)).isEqualTo(18880);
    }

    private LinkedList<Integer> asLinkedList(final Integer... integers) {
        return new LinkedList<>(Arrays.asList(integers));
    }

    private ListNode makeListNode(final LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.pollFirst());
        addNextNode(head, list);
        return head;
    }

    private void addNextNode(final ListNode node, final LinkedList<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        node.next = new ListNode(list.pollFirst());
        addNextNode(node.next, list);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(final int x) {
            val = x;
        }
    }

}
