package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 771. Jewels and Stones
public class P771 {

    public int numJewelsInStones(final String j, final String s) {
        int count = 0;
        for (final char stone : s.toCharArray()) {
            if (j.contains(String.valueOf(stone))) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    public void test2() {
        assertEquals(0, numJewelsInStones("z", "ZZ"));
    }

}
