package explore.arrayandstring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DiagonalTraverse {

    public int[] findDiagonalOrder(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        boolean up = true;
        int x = 0, y = 0;
        int endY = matrix.length - 1;
        int endX = matrix[0].length - 1;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(matrix[0][0]);

        while (x < endX || y < endY) {
            if (up) {
                if (x == endX) {
                    up = false;
                    y++;
                } else if (y == 0) {
                    up = false;
                    x++;
                } else {
                    x++;
                    y--;
                }
            } else if (y == endY) {
                up = true;
                x++;
            } else if (x == 0) {
                up = true;
                y++;
            } else {
                y++;
                x--;
            }
            resultList.add(matrix[y][x]);
        }
        return resultList.stream().mapToInt(o -> o).toArray();
    }


    @Test
    public void test1() {
        int[] result = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertThat(result).isEqualTo(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9});
    }

    @Test
    public void test2() {
        int[] result = findDiagonalOrder(new int[][]{});
        assertThat(result).isEqualTo(new int[]{});
    }

    @Test
    public void test3() {
        int[] result = findDiagonalOrder(new int[][]{{1}});
        assertThat(result).isEqualTo(new int[]{1});
    }

    @Test
    public void test4() {
        int[] result = findDiagonalOrder(new int[][]{{2, 3}});
        assertThat(result).isEqualTo(new int[]{2, 3});
    }

    @Test
    public void test5() {
        int[] result = findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
        assertThat(result).isEqualTo(new int[]{1, 2, 3, 4});
    }


}
