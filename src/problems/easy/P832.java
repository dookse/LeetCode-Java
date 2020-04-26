package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 832. Flipping an Image
public class P832 {

    public int[][] flipAndInvertImage(int[][] a) {
        for (int[] rows : a) {
            int left = 0, right = rows.length - 1;
            invert(rows, left, right);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] ^= 1;
            }
        }
        return a;
    }

    private void invert(final int[] ints, int left, int right) {
        while (left < right) {
            int temp = ints[left];
            ints[left] = ints[right];
            ints[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test1() {
        int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] expected = new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        assertThat(flipAndInvertImage(input)).isEqualTo(expected);
    }
}
