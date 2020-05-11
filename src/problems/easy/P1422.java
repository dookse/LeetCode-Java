package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1422. Maximum Score After Splitting a String
public class P1422 {

    public int maxScore(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            int sum = count(left, "0") + count(right, "1");
            max = Math.max(max, sum);
        }
        return max;
    }

    private int count(String input, String target) {
        int count = 0;
        String[] s = input.split("");
        for (String c : s) {
            if (c.equals(target)) {
                count++;
            }
        }
        return count;
    }


    @Test
    public void test1() {
        assertThat(maxScore("011101")).isEqualTo(5);
    }

    @Test
    public void test2() {
        assertThat(maxScore("00111")).isEqualTo(5);
    }

    @Test
    public void test3() {
        assertThat(maxScore("1111")).isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(maxScore("00")).isEqualTo(1);
    }

}
