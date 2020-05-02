package explore.challenge30day.may.week1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JewelsandStones {

    public int numJewelsInStones(final String j, final String s) {
        int count = 0;
        for (char stone : s.toCharArray()) {
            if (j.contains(String.valueOf(stone))) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        assertThat(numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }
}
