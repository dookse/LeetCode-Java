package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 905. Sort Array By Parity
public class P905 {

    public int[] sortArrayByParity(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            if (!isEven(a[left])) {
                swap(a, left, right);
            }
            if (isEven(a[left])) {
                left++;
            }
            if (!isEven(a[right])) {
                right--;
            }
        }
        return a;
    }

    private boolean isEven(final int i) {
        return (i & 1) == 0;
    }

    private void swap(final int[] a, final int left, final int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }


    @Test
    public void test1() {
        assertThat(sortArrayByParity(new int[]{3, 1, 2, 4})).isEqualTo(new int[]{4, 2, 1, 3});
    }
}
