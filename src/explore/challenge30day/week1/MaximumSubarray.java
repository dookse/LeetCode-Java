package explore.challenge30day.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumSubarray {

    public int maxSubArray(final int[] nums) {
        int[] sums = new int[nums.length];
        int max = nums[0];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(nums[i], sums[i - 1] + nums[i]);
            max = Math.max(sums[i], max);
        }
        return max;
    }

    @Test
    public void test1() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertThat(maxSubArray(input)).isEqualTo(6);
    }

}
