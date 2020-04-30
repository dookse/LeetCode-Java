package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 728. Self Dividing Numbers
public class P728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> answer = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDivided(i, i)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean selfDivided(int num, int i) {
        int digit = num % 10;
        if (digit == 0 || i % digit != 0) {
            return false;
        } else if (num < 10) {
            return true;
        }
        return selfDivided(num / 10, i);
    }

    @Test
    public void test1() {
        assertThat(selfDividingNumbers(1, 22)).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22));
    }
}
