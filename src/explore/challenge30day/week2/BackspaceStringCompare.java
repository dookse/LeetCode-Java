package explore.challenge30day.week2;

import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    @ParameterizedTest
    @CsvSource({"y#fo##f,y#f#o##f", "ab##,c#d#", "ab#c,ad#c", "ab##,c#d#", "a##c,#a#c"})
    public void testTrue(String s, String t) {
        assertThat(backspaceCompare(s, t)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"xywrrmp,xywrrm#p", "a#c,b", "abcdez,abcdef"})
    public void testFalse(String s, String t) {
        assertThat(backspaceCompare(s, t)).isFalse();
    }

}
