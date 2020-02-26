package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P1342 {

    public int numberOfSteps(final int num) {
        if (num <= 0) {
            return 0;
        }
        if (num % 2 == 0) {
            return numberOfSteps(num / 2) + 1;
        } else {
            return numberOfSteps(num - 1) + 1;
        }
    }

    private boolean isEven(final int num) {
        return num % 2 == 0;
    }

    @Test
    public void test1() {
        assertEquals(6, numberOfSteps(14));
    }

    @Test
    public void test2() {
        assertEquals(4, numberOfSteps(8));
    }

    @Test
    public void test3() {
        assertEquals(12, numberOfSteps(123));
    }

}
