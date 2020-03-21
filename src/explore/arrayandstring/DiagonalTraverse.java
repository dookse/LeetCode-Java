package explore.arrayandstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DiagonalTraverse {

    public int[] findDiagonalOrder(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int x, y, k = 0;
        int endX = matrix[0].length;
        int endY = matrix.length;
        List<Integer> intermediate = new ArrayList<>();
        int[] answer = new int[endX * endY];
        for (int i = 0; i < endX + endY - 1; i++) {
            intermediate.clear();
            x = i < endX ? i : endX - 1;
            y = i < endX ? 0 : i - endX + 1;
            while (x >= 0 && y < endY) {
                intermediate.add(matrix[y][x]);
                x--;
                y++;
            }
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (final Integer num : intermediate) {
                answer[k++] = num;
            }
        }
        return answer;
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

    @Test
    public void test6() {
        int[] result = findDiagonalOrder(new int[][]{{2, 5}, {8, 4}, {0, -1}});
        assertThat(result).isEqualTo(new int[]{2, 5, 8, 0, 4, -1});
    }


}
