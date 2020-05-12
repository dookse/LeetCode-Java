package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1431. Kids With the Greatest Number of Candies
public class P1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> answer = new ArrayList<>();
        for (int candy : candies) {
            answer.add(candy + extraCandies >= max);
        }
        return answer;
    }

    @Test
    public void test1() {
        List<Boolean> expected = Arrays.asList(true, true, true, false, true);
        assertThat(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3)).isEqualTo(expected);
    }

    @Test
    public void test2() {
        List<Boolean> expected = Arrays.asList(true, false, false, false, false);
        assertThat(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1)).isEqualTo(expected);
    }

    @Test
    public void test3() {
        List<Boolean> expected = Arrays.asList(true, false, true);
        assertThat(kidsWithCandies(new int[]{12, 1, 12}, 10)).isEqualTo(expected);
    }

}
