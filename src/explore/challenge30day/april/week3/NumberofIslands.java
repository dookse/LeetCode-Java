package explore.challenge30day.april.week3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == '1' && !visit[y][x]) {
                    search(grid, visit, y, x);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void search(char[][] grid, boolean[][] visit, int y, int x) {
        if (y < 0 || y >= grid.length) {
            return;
        }
        if (x < 0 || x >= grid[0].length) {
            return;
        }
        if (grid[y][x] == '0') {
            return;
        }
        if (!visit[y][x]) {
            visit[y][x] = true;
            search(grid, visit, y - 1, x);
            search(grid, visit, y, x - 1);
            search(grid, visit, y + 1, x);
            search(grid, visit, y, x + 1);
        }
    }

    @Test
    public void test1() {
        char[][] input = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertThat(numIslands(input)).isEqualTo(1);
    }

    @Test
    public void test2() {
        char[][] input = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertThat(numIslands(input)).isEqualTo(3);
    }

}
