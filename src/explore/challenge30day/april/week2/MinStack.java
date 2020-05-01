package explore.challenge30day.april.week2;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinStack {

    private Node top;

    public void push(int x) {
        top = new Node(x, top);
    }

    public void pop() {
        checkEmptyStack();
        top = top.next;
    }

    public int top() {
        checkEmptyStack();
        return top.data;
    }

    public int getMin() {
        return top.min;
    }

    private void checkEmptyStack() {
        if (top == null) {
            throw new EmptyStackException();
        }
    }

    @Test
    public void test1() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertThat(stack.getMin()).isEqualTo(-3);
        stack.pop();
        assertThat(stack.top()).isEqualTo(0);
        assertThat(stack.getMin()).isEqualTo(-2);
    }

    @Test
    public void test2() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        assertThat(stack.getMin()).isEqualTo(0);
        stack.pop();
        assertThat(stack.getMin()).isEqualTo(0);
        stack.pop();
        assertThat(stack.getMin()).isEqualTo(0);
        stack.pop();
        assertThat(stack.getMin()).isEqualTo(2);
    }

    static class Node {

        int data;
        int min;
        Node next;

        public Node(final int data, final Node node) {
            this.data = data;
            this.next = node;
            this.min = node == null ? data : Math.min(node.min, data);
        }
    }

}
