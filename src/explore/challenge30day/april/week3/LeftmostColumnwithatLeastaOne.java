package explore.challenge30day.april.week3;

import java.util.List;

import org.junit.jupiter.api.Test;

import explore.challenge30day.april.week3.model.BinaryMatrix;

import static org.assertj.core.api.Assertions.assertThat;

public class LeftmostColumnwithatLeastaOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0), col = dimensions.get(1);
        int lastOneIndex = -1;
        int x = col - 1, y = 0;
        while (y < row && x >= 0) {
            if (binaryMatrix.get(y, x) == 1) {
                lastOneIndex = x;
                x--;
            } else {
                y++;
            }
        }
        return lastOneIndex;
    }

    @Test
    public void test1() {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0}, {1, 1}});
        assertThat(leftMostColumnWithOne(matrix)).isEqualTo(0);
    }

    @Test
    public void test2() {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 1}});
        assertThat(leftMostColumnWithOne(matrix)).isEqualTo(1);
    }

    @Test
    public void test3() {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 0}});
        assertThat(leftMostColumnWithOne(matrix)).isEqualTo(-1);
    }

    @Test
    public void test4() {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}});
        assertThat(leftMostColumnWithOne(matrix)).isEqualTo(1);
    }

    @Test
    public void test5() {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0}, {1, 1}});
        assertThat(leftMostColumnWithOne(matrix)).isEqualTo(0);
    }
}


