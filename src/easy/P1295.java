package easy;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 1295. Find Numbers with Even Number of Digits
public class P1295 {

    public int findNumbers(final int[] nums) {
        return (int) Arrays.stream(nums)
            .map(num -> String.valueOf(num).length())
            .filter(len -> len % 2 == 0)
            .count();
    }

    @Test
    public void test1() {
        assertEquals(2, findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    @Test
    public void test2() {
        assertEquals(1, findNumbers(new int[]{555, 901, 482, 1771}));
    }
}
