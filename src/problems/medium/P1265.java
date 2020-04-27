package problems.medium;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1265. Print Immutable Linked List in Reverse
public class P1265 {

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(System.in);
    }

    @Test
    public void test1() {
        ImmutableListNode node = new ImmutableListNode(1);
        node.next = new ImmutableListNode(2);
        node.next.next = new ImmutableListNode(3);
        node.next.next.next = new ImmutableListNode(4);
        printLinkedListInReverse(node);
        assertThat(outContent.toString()).isEqualTo(""
            + "4" + System.lineSeparator()
            + "3" + System.lineSeparator()
            + "2" + System.lineSeparator()
            + "1" + System.lineSeparator());
    }

    @Test
    public void test2() {
        ImmutableListNode node = new ImmutableListNode(0);
        node.next = new ImmutableListNode(-4);
        node.next.next = new ImmutableListNode(-1);
        node.next.next.next = new ImmutableListNode(3);
        node.next.next.next.next = new ImmutableListNode(-5);
        printLinkedListInReverse(node);
        assertThat(outContent.toString()).isEqualTo(""
            + "-5" + System.lineSeparator()
            + "3" + System.lineSeparator()
            + "-1" + System.lineSeparator()
            + "-4" + System.lineSeparator()
            + "0" + System.lineSeparator());
    }

    static class ImmutableListNode {

        ImmutableListNode next;
        int value;

        public ImmutableListNode(final int value) {
            this.value = value;
        }

        public void printValue() {
            System.out.println(value);
        }

        public ImmutableListNode getNext() {
            return next;
        }
    }

}
