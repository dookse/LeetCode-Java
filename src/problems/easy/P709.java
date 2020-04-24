package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 709. To Lower Case
public class P709 {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] |= 32;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertThat(toLowerCase("Hello")).isEqualTo("hello");
    }
}
