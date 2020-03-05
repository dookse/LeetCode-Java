package problems.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 1281. Subtract the Product and Sum of Digits of an Integer
public class P1281 {

    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }

    @Test
    public void test1() {
        assertProblem(15, 234);
    }

    @Test
    public void test2() {
        assertProblem(21, 4421);
    }

    private void assertProblem(final int expected, final int n) {
        assertEquals(expected, subtractProductAndSum(n));
    }
}
