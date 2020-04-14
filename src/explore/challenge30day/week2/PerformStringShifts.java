package explore.challenge30day.week2;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(s.split("")));
        int shiftCount = 0;
        for (int[] input : shift) {
            shiftCount += input[0] == 0 ? input[1] : input[1] * -1;
        }
        if (shiftCount > 0) {
            for (int i = 0; i < shiftCount; i++) {
                list.addLast(list.removeFirst());
            }
        } else {
            for (int i = shiftCount; i < 0; i++) {
                list.addFirst(list.removeLast());
            }
        }
        return String.join("", list);
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

}
