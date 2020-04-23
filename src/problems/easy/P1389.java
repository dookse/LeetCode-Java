package problems.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1389. Create Target Array in the Given Order
public class P1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    @Test
    public void test1() {
        assertThat(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}))
            .isEqualTo(new int[]{0, 4, 1, 3, 2});
    }
}
