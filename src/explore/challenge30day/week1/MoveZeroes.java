package explore.challenge30day.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZeroes {

    public void moveZeroes(final int[] nums) {
        int nonZeroIndex = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for (int i = nonZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test1() {
        int[] input = new int[]{0, 1, 0, 3, 12};
        moveZeroes(input);
        assertThat(input).isEqualTo(new int[]{1, 3, 12, 0, 0});
    }

    @Test
    public void test2() {
        int[] input = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(input);
        assertThat(input).isEqualTo(new int[]{4, 2, 4, 3, 5, 1, 0, 0, 0, 0});
    }


}
