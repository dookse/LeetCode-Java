package easy;

import java.util.Stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 1221. Split a String in Balanced Strings
public class P1221 {

    public int balancedStringSplit(final String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char[] chars = s.toCharArray();
        for (final Character c : chars) {
            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result++;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(4, balancedStringSplit("RLRRLLRLRL"));
    }

    @Test
    public void test2() {
        assertEquals(3, balancedStringSplit("RLLLLRRRLR"));
    }

    @Test
    public void test3() {
        assertEquals(1, balancedStringSplit("LLLLRRRR"));
    }

    @Test
    public void test4() {
        assertEquals(2, balancedStringSplit("RLRRRLLRLL"));
    }


}
