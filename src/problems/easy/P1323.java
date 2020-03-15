package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1323. Maximum 69 Number
public class P1323 {

    public int maximum69Number(final int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    @Test
    public void test1() {
        assertThat(maximum69Number(9669)).isEqualTo(9969);
    }

    @Test
    public void test2() {
        assertThat(maximum69Number(9999)).isEqualTo(9999);
    }

    @Test
    public void test3() {
        assertThat(maximum69Number(9996)).isEqualTo(9999);
    }

}
