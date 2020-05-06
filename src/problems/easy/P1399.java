package problems.easy;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1399. Count Largest Group
public class P1399 {

    public int countLargestGroup(final int n) {
        int max = 0;
        int answer = 0;
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int sum = 0, num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            max = Math.max(++nums[sum], max);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(countLargestGroup(13)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(countLargestGroup(2)).isEqualTo(2);
    }

    @Test
    public void test3() {
        assertThat(countLargestGroup(15)).isEqualTo(6);
    }

    @Test
    public void test4() {
        assertThat(countLargestGroup(24)).isEqualTo(5);
    }
}
