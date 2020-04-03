package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 344. Reverse String
public class P344 {

    public void reverseString(final char[] s) {
        int left = 0, right = s.length - 1;
        while (right > left) {
            char tempLeft = s[left];
            s[left] = s[right];
            s[right] = tempLeft;
            left++;
            right--;
        }
    }

    @Test
    public void test1() {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        reverseString(input);
        assertThat(input).isEqualTo(new char[]{'o', 'l', 'l', 'e', 'h'});
    }

    @Test
    public void test2() {
        char[] input = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(input);
        assertThat(input).isEqualTo(new char[]{'h', 'a', 'n', 'n', 'a', 'H'});
    }

    @Test
    public void test3() {
        char[] input = {};
        reverseString(input);
        assertThat(input).isEqualTo(new char[]{});
    }

    @Test
    public void test4() {
        char[] input = {'a'};
        reverseString(input);
        assertThat(input).isEqualTo(new char[]{'a'});
    }

    @Test
    public void test5() {
        char[] input = {'a', 'b'};
        reverseString(input);
        assertThat(input).isEqualTo(new char[]{'b', 'a'});
    }

    @Test
    public void test6() {
        char[] input = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a',
            'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        char[] output = {'a', 'm', 'a', 'n', 'a', 'P', ' ', ':', 'l', 'a', 'n', 'a', 'c', ' ', 'a', ' ', ',', 'n', 'a',
            'l', 'p', ' ', 'a', ' ', ',', 'n', 'a', 'm', ' ', 'A'};
        reverseString(input);
        assertThat(input).isEqualTo(output);
    }
}
