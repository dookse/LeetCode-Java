package problems.easy;

import java.util.Arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1086. High Five
public class P1086 {

    public int[][] highFive(final int[][] items) {
        Arrays.sort(items, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));
        int lastId = items[0][0];
        int[][] answer = new int[lastId][2];
        int count = 0, sum = 0;
        for (final int[] item : items) {
            int id = item[0];
            if (lastId != id) {
                count = 0;
                sum = 0;
                lastId = id;
            }
            if (count < 5) {
                sum += item[1];
                count++;
            }
            if (count == 5) {
                answer[id - 1] = new int[]{id, sum / 5};
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        int[][] input = new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100},
            {2, 100}, {2, 76}};
        assertThat(highFive(input)).isEqualTo(new int[][]{{1, 87}, {2, 88}});
    }


}
