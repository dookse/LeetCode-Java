package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1252. Cells with Odd Values in a Matrix
public class P1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            int row = index[0], col = index[1];
            for (int i = 0; i < m; i++) {
                matrix[row][i]++;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][col]++;
            }
        }
        int answer = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if ((value & 1) == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}})).isEqualTo(6);
    }

    @Test
    public void test2() {
        assertThat(oddCells(2, 2, new int[][]{{1, 1}, {0, 0}})).isEqualTo(0);
    }
}
