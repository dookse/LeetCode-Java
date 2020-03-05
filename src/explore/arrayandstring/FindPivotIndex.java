package explore.arrayandstring;

import java.util.stream.IntStream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPivotIndex {

    public int pivotIndex(final int[] nums) {
        int left = 0;
        int sum = IntStream.of(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    @Test
    public void test1() {
        assertThat(pivotIndex(new int[]{1, 7, 3, 6, 5, 6})).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(pivotIndex(new int[]{1, 2, 3})).isEqualTo(-1);
    }

    @Test
    public void test3() {
        assertThat(pivotIndex(new int[]{1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1})).isEqualTo(5);
    }

    @Test
    public void test4() {
        assertThat(pivotIndex(new int[]{500, 1000, 500})).isEqualTo(1);
    }

    @Test
    public void test5() {
        assertThat(pivotIndex(new int[]{-100, 100, 0, -100, 100})).isEqualTo(2);
    }

    @Test
    public void test6() {
        assertThat(pivotIndex(new int[]{-1, -1, -1, 0, 1, 1})).isEqualTo(0);
    }

    @Test
    public void test7() {
        assertThat(pivotIndex(new int[]{-1, -1, 0, 1, 1, 0})).isEqualTo(5);
    }

}
