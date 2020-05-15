package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1446. Consecutive Characters
public class P1446 {

    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        int consecutive = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                consecutive++;
            } else {
                max = Math.max(max, consecutive);
                consecutive = 1;
            }
        }
        return Math.max(max, consecutive);
    }

    @Test
    public void test0() {
        assertThat(maxPower("")).isEqualTo(0);
    }

    @Test
    public void test00() {
        assertThat(maxPower("cc")).isEqualTo(2);
    }

    @Test
    public void test1() {
        assertThat(maxPower("leetcode")).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(maxPower("abbcccddddeeeeedcba")).isEqualTo(5);
    }

    @Test
    public void test3() {
        assertThat(maxPower("triplepillooooow")).isEqualTo(5);
    }

    @Test
    public void test4() {
        assertThat(maxPower("hooraaaaaaaaaaay")).isEqualTo(11);
    }

    @Test
    public void test5() {
        assertThat(maxPower("tourist")).isEqualTo(1);
    }

    @Test
    public void test6() {
        assertThat(maxPower("hooraaaaaaaaaaa")).isEqualTo(11);
    }
}
