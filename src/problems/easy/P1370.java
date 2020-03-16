package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1370. Increasing Decreasing String
public class P1370 {

    public String sortString(final String s) {
        final int LENGTH = 26;
        int[] letterCount = new int[LENGTH];
        StringBuilder sb = new StringBuilder(s.length());

        for (final char c : s.toCharArray()) {
            letterCount[c - 'a']++;
        }

        while (sb.length() < s.length()) {
            for (int i = 0; i < LENGTH; i++) {
                if (letterCount[i] > 0) {
                    letterCount[i]--;
                    sb.append((char) (i + 'a'));
                }
            }
            for (int i = LENGTH - 1; i >= 0; i--) {
                if (letterCount[i] > 0) {
                    letterCount[i]--;
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void test1() {
        assertThat(sortString("aaaabbbbcccc")).isEqualTo("abccbaabccba");
    }

    @Test
    public void test2() {
        assertThat(sortString("rat")).isEqualTo("art");
    }

    @Test
    public void test3() {
        assertThat(sortString("leetcode")).isEqualTo("cdelotee");
    }

    @Test
    public void test4() {
        assertThat(sortString("ggggggg")).isEqualTo("ggggggg");
    }

    @Test
    public void test5() {
        assertThat(sortString("spo")).isEqualTo("ops");
    }
}
