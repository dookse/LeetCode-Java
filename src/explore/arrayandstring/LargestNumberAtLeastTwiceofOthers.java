package explore.arrayandstring;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(final int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (var i = 1; i < n; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != maxIndex && nums[maxIndex] / 2 < nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }


    @Test
    public void test1() {
        assertThat(dominantIndex(new int[]{3, 6, 1, 0})).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(dominantIndex(new int[]{1, 2, 3, 4})).isEqualTo(-1);
    }

    @Test
    public void test3() {
        assertThat(dominantIndex(new int[]{1, 0})).isEqualTo(0);
    }
}
