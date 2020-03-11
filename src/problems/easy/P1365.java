package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1365. How Many Numbers Are Smaller Than the Current Number
public class P1365 {

    public int[] smallerNumbersThanCurrent(final int[] nums) {
        int[] count = new int[102], result = new int[nums.length];

        for (final int num : nums) {
            count[num + 1]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }

        return result;
    }

    @Test
    public void test1() {
        assertThat(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})).isEqualTo(new int[]{4, 0, 1, 1, 3});
    }

    @Test
    public void test2() {
        assertThat(smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})).isEqualTo(new int[]{2, 1, 0, 3});
    }

    @Test
    public void test3() {
        assertThat(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})).isEqualTo(new int[]{0, 0, 0, 0});
    }

}
