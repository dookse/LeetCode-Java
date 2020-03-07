package explore.arrayandstring;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusOne {

    public int[] plusOne(final int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            }
            digits[i]++;
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    @Test
    public void test1() {
        assertThat(plusOne(new int[]{1, 2, 3})).isEqualTo(new int[]{1, 2, 4});
    }

    @Test
    public void test2() {
        assertThat(plusOne(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2, 2});
    }

    @Test
    public void test3() {
        assertThat(plusOne(new int[]{1, 9, 9, 9})).isEqualTo(new int[]{2, 0, 0, 0});
    }

    @Test
    public void test4() {
        assertThat(plusOne(new int[]{9})).isEqualTo(new int[]{1, 0});
    }

    @Test
    public void test5() {
        assertThat(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})).isEqualTo(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1});
    }

    @Test
    public void test6() {
        assertThat(plusOne(new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3}))
            .isEqualTo(new int[]{6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 4});
    }

    @Test
    public void test7() {
        assertThat(plusOne(
            new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1,
                1, 7, 4, 0, 0, 6}))
            .isEqualTo(
                new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0,
                    1, 1, 1, 7, 4, 0, 0, 7});
    }

}
