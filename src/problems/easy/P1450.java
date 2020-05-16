package problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1450. Number of Students Doing Homework at a Given Time
public class P1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4)).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(busyStudent(new int[]{4}, new int[]{4}, 5)).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7)).isEqualTo(0);
    }

    @Test
    public void test4() {
        assertThat(busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5))
            .isEqualTo(5);
    }
}
