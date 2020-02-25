import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToInteger {

    private final Map<String, Integer> romanMap =
        Map.of("M", 1000, "D", 500, "C", 100, "L", 50, "X", 10, "V", 5, "I", 1);

    public int romanToInt(final String s) {
        int result = 0;
        String[] strArr = s.split("");
        for (int i = 0; i < s.length(); i++) {
            int now = romanMap.get(strArr[i]);
            if (i < s.length() - 1) {
                int next = romanMap.get(strArr[i + 1]);
                if (next - now > 0) {
                    now = next - now;
                    i++;
                }
            }
            result += now;
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(3, romanToInt("III"));
    }

    @Test
    public void test2() {
        assertEquals(4, romanToInt("IV"));
    }

    @Test
    public void test3() {
        assertEquals(9, romanToInt("IX"));
    }

    @Test
    public void test4() {
        assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    public void test5() {
        assertEquals(1994, romanToInt("MCMXCIV"));
    }

    @Test
    public void test6() {
        assertEquals(1476, romanToInt("MCDLXXVI"));
    }

}
