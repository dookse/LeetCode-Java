package explore.challenge30day.april.week3;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pivot = nums[0];
        Arrays.sort(nums);
        int pivotIdx = Arrays.binarySearch(nums, pivot);
        int targetIdx = Arrays.binarySearch(nums, target);
        if (pivotIdx < 0 || targetIdx < 0) {
            return -1;
        }
        if (pivotIdx == targetIdx) {
            return 0;
        } else if (pivotIdx < targetIdx) {
            return targetIdx - pivotIdx;
        } else {
            return nums.length - pivotIdx + targetIdx;
        }
    }

    @Test
    public void test1() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
    }

    @Test
    public void test3() {
        assertThat(search(new int[]{1}, 1)).isEqualTo(0);
    }

    @Test
    public void test4() {
        assertThat(search(new int[]{3, 1}, 1)).isEqualTo(1);
    }

    @Test
    public void test5() {
        assertThat(search(new int[]{3, 1}, 3)).isEqualTo(0);
    }

}
