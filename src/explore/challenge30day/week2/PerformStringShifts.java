package explore.challenge30day.week2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        int shiftCount = 0;
        for (int[] input : shift) {
            shiftCount += input[0] == 0 ? input[1] : input[1] * -1;
        }
        int shiftIndex = shiftCount % s.length();
        shiftIndex += shiftCount < 0 ? s.length() : 0;
        return s.substring(shiftIndex) + s.substring(0, shiftIndex);
    }

    @Test
    public void test1() {
        int[][] shift = new int[][]{{0, 1}, {1, 2}};
        assertThat(stringShift("abc", shift)).isEqualTo("cab");
    }

    @Test
    public void test2() {
        int[][] shift = new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        assertThat(stringShift("abcdefg", shift)).isEqualTo("efgabcd");
    }

    @Test
    public void test3() {
        int[][] shift = new int[][]{{1, 1}, {1, 1}, {0, 2}, {0, 2}};
        assertThat(stringShift("abcde", shift)).isEqualTo("cdeab");
    }

    @Test
    public void test4() {
        int[][] shift = new int[][]{{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}};
        assertThat(stringShift("yisxjwry", shift)).isEqualTo("yisxjwry");
    }

    @Test
    public void test5() {
        int[][] shift = new int[][]{{1, 4}, {0, 5}, {0, 4}, {1, 1}, {1, 5}};
        assertThat(stringShift("mecsk", shift)).isEqualTo("kmecs");
    }

}
