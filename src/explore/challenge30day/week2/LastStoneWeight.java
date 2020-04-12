package explore.challenge30day.week2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        if (stones == null) {
            return 0;
        } else if (stones.length == 1) {
            return stones[0];
        }
        int heavy1 = stones.length - 2;
        int heavy2 = stones.length - 1;
        while (true) {
            Arrays.sort(stones);
            if (stones[heavy1] == 0) {
                return stones[heavy2];
            }
            int x = Math.min(stones[heavy2], stones[heavy1]);
            int y = Math.max(stones[heavy2], stones[heavy1]);
            if (x == y) {
                stones[heavy2] = 0;
            } else {
                stones[heavy2] = y - x;
            }
            stones[heavy1] = 0;
        }
    }

    @Test
    public void test1() {
        int[] input = new int[]{2, 7, 4, 1, 8, 1};
        assertThat(lastStoneWeight(input)).isEqualTo(1);
    }

    @Test
    public void test2() {
        int[] input = new int[]{1};
        assertThat(lastStoneWeight(input)).isEqualTo(1);
    }
}
