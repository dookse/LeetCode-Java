package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// 1165. Single-Row Keyboard
public class P1165 {

    public int calculateTime(final String keyboard, final String word) {
        int distance = 0, from = 0;
        for (int i = 0; i < word.length(); i++) {
            int to = keyboard.indexOf(word.charAt(i));
            distance += Math.abs(from - to);
            from = to;
        }
        return distance;
    }

    @Test
    public void test1() {
        assertThat(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba")).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode")).isEqualTo(73);
    }

}
