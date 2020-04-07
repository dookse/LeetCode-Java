package explore.challenge30day.week1;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingElements {

    public int countElements(final int[] arr) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (final int value : arr) {
            set.add(value);
        }
        for (final int value : arr) {
            if (set.contains(value + 1)) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(countElements(new int[]{1, 2, 3})).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7})).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(countElements(new int[]{1, 3, 2, 3, 5, 0})).isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(countElements(new int[]{1, 1, 2, 2})).isEqualTo(2);
    }


}
