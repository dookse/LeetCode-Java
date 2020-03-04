package easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1266. Minimum Time Visiting All Points
public class P1266 {

    public int minTimeToVisitAllPoints(final int[][] points) {
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            result += getDistance(points[i - 1], points[i]);
        }
        return result;
    }

    private int getDistance(final int[] currentPoint, final int[] nextPoint) {
        int distanceX = Math.abs(currentPoint[0] - nextPoint[0]);
        int distanceY = Math.abs(currentPoint[1] - nextPoint[1]);
        return Math.max(distanceX, distanceY);
    }

    @Test
    public void test1() {
        int[][] input = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        assertThat(minTimeToVisitAllPoints(input)).isEqualTo(7);
    }

    @Test
    public void test2() {
        int[][] input = new int[][]{{3, 2}, {-2, 2}};
        assertThat(minTimeToVisitAllPoints(input)).isEqualTo(5);
    }


}
