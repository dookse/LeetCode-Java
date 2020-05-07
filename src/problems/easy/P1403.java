package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1403. Minimum Subsequence in Non-Increasing Order
public class P1403 {

    public List<Integer> minSubsequence(final int[] nums) {
        Arrays.sort(nums);
        List<Integer> answer = new ArrayList<>(nums.length);
        int sum = 0;
        int descSum = 0;
        for (final int num : nums) {
            sum += num;
        }
        originalList:
        for (int number : nums) {

        }
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            descSum += nums[i];
            answer.add(nums[i]);
            if (descSum > sum) {
                break;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        int[] input = new int[]{4, 3, 10, 9, 8};
        List<Integer> expected = Arrays.asList(10, 9);
        assertThat(minSubsequence(input)).isEqualTo(expected);
    }

    @Test
    public void test2() {
        int[] input = new int[]{4, 4, 7, 6, 7};
        List<Integer> expected = Arrays.asList(7, 7, 6);
        assertThat(minSubsequence(input)).isEqualTo(expected);
    }

    @Test
    public void test3() {
        int[] input = new int[]{6};
        List<Integer> expected = Arrays.asList(6);
        assertThat(minSubsequence(input)).isEqualTo(expected);
    }

}
