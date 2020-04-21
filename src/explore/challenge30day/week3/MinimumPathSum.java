package explore.challenge30day.week3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumPathSum {


    public int minPathSum(int[][] grid) {
        int[][] sums = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (x == 0 && y == 0) {
                    sums[y][x] = grid[y][x];
                } else if (x == 0) {
                    sums[y][x] = grid[y][x] + sums[y - 1][x];
                } else if (y == 0) {
                    sums[y][x] = grid[y][x] + sums[y][x - 1];
                } else {
                    sums[y][x] = grid[y][x] + Math.min(sums[y - 1][x], sums[y][x - 1]);
                }
            }
        }
        return sums[sums.length - 1][sums[0].length - 1];
    }


    @Test
    public void test1() {
        assertThat(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}})).isEqualTo(7);
    }

}
