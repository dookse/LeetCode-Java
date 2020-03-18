package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1299. Replace Elements with Greatest Element on Right Side
public class P1299 {

    public int[] replaceElements(final int[] arr) {

        int length = arr.length;
        int max = Integer.MIN_VALUE;
        int[] answer = new int[length];
        answer[length - 1] = -1;

        for (int i = length - 1; i > 0; i--) {
            max = Math.max(max, arr[i]);
            answer[i - 1] = max;
        }

        return answer;
    }

    @Test
    public void test1() {
        assertThat(replaceElements(new int[]{17, 18, 5, 4, 6, 1})).isEqualTo(new int[]{18, 6, 6, 6, 1, -1});
    }

    @Test
    public void test2() {
        assertThat(replaceElements(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{5, 5, 5, 5, -1});
    }

}
