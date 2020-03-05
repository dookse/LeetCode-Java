package problems.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

// 1313. Decompress Run-Length Encoded List
public class P1313 {

    public int[] decompressRLElist(final int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                result.add(nums[i + 1]);
            }
        }
        return result.stream().mapToInt(o -> o).toArray();
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{2, 4, 4, 4}, decompressRLElist(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{2, 2, 6}, decompressRLElist(new int[]{2, 2, 1, 6}));
    }

}
