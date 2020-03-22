package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1180. Count Substrings with Only One Distinct Letter
public class P1180 {

    public int countLetters(final String s) {
        int sum = 1, sameCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sameCount++;
            } else {
                sameCount = 1;
            }
            sum += sameCount;
        }
        return sum;
    }

    @Test
    public void test1() {
        assertThat(countLetters("aaaba")).isEqualTo(8);
    }

    @Test
    public void test2() {
        assertThat(countLetters("aaaaaaaaaa")).isEqualTo(55);
    }

    @Test
    public void test3() {
        assertThat(countLetters("a")).isEqualTo(1);
    }

}
