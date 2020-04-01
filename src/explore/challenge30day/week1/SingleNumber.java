package explore.challenge30day.week1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleNumber {

    public int singleNumber(final int[] nums) {
        int answer = 0;
        for (final int num : nums) {
            answer ^= num;
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(singleNumber(new int[]{2, 2, 1})).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(singleNumber(new int[]{4, 1, 2, 1, 2})).isEqualTo(4);
    }

    @Test
    public void test3() {
        assertThat(singleNumber(new int[]{2, 1, 2, 1, 3})).isEqualTo(3);
    }

}
