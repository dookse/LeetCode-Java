package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1351. Count Negative Numbers in a Sorted Matrix
public class P1351 {

    public int countNegatives(final int[][] grid) {
        int count = 0;
        for (final int[] line : grid) {
            int size = line.length;
            for (int j = 0; j < size; j++) {
                if (line[j] < 0) {
                    count += size - j;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        assertThat(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}))
            .isEqualTo(8);
    }

    @Test
    public void test2() {
        assertThat(countNegatives(new int[][]{{3, 2}, {1, 0}}))
            .isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(countNegatives(new int[][]{{1, -1}, {-1, -1}}))
            .isEqualTo(3);
    }


}
