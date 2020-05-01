package explore.challenge30day.april.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BestTimetoBuyandSellStockII {

    public int maxProfit(final int[] prices) {
        int n = prices.length - 1, maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    @Test
    public void test1() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
    }

    @Test
    public void test2() {
        assertThat(maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
    }

    @Test
    public void test3() {
        assertThat(maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    }
}
