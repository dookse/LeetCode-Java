package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1134. Armstrong Number
public class P1134 {

    public boolean isArmstrong(final int n) {
        int temp = n, sum = 0;
        int length = (int) Math.log10(n) + 1;
        while (temp > 0) {
            sum += Math.pow(temp % 10, length);
            temp /= 10;
        }
        return sum == n;
    }

    @Test
    public void test1() {
        assertThat(isArmstrong(153)).isTrue();
    }

    @Test
    public void test2() {
        assertThat(isArmstrong(123)).isFalse();
    }

}
