package explore.challenge30day.april.week1;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HappyNumber {

    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (!set.add(sum)) {
                return false;
            }
            n = sum;
        }
        return true;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 13, 19})
    public void testTrueCase(final int n) {
        assertThat(isHappy(n)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 9, 11, 15, 17})
    public void testFalseCase(final int n) {
        assertThat(isHappy(n)).isFalse();
    }


}
