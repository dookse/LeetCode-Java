package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1413. Minimum Value to Get Positive Step by Step Sum
public class P1413 {

    public int minStartValue(int[] nums) {
        int current = 0, answer = 0;
        for (int num : nums) {
            current += num;
            if (current < 0) {
                answer += Math.abs(current);
                current = 0;
            }
        }
        return answer + 1;
    }

    @Test
    public void test1() {
        assertThat(minStartValue(new int[]{-3, 2, -3, 4, 2})).isEqualTo(5);
    }

    @Test
    public void test2() {
        assertThat(minStartValue(new int[]{1, 2})).isEqualTo(1);
    }

    @Test
    public void test3() {
        assertThat(minStartValue(new int[]{1, -2, -3})).isEqualTo(5);
    }

    @Test
    public void test4() {
        assertThat(minStartValue(new int[]{-3, 2, -3, 4, 2})).isEqualTo(5);
    }
}
