package explore.challenge30day.week2;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    @Test
    public void test1() {
        assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
    }

    @Test
    public void test3() {
        assertThat(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0})).isEqualTo(2);
    }

}
