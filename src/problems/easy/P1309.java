package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1309. Decrypt String from Alphabet to Integer Mapping
public class P1309 {

    public String freqAlphabets(final String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (i + 3 <= n && s.charAt(i + 2) == '#') {
                sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 2;
            } else {
                sb.append((char) ('a' + Character.getNumericValue(s.charAt(i)) - 1));
            }
        }
        return sb.toString();
    }

    private int intValue(final char ch, final int n) {
        return 'a' + n * Character.getNumericValue(ch) - 1;
    }

    @Test
    public void test1() {
        assertThat(freqAlphabets("10#11#12")).isEqualTo("jkab");
    }

    @Test
    public void test2() {
        assertThat(freqAlphabets("1326#")).isEqualTo("acz");
    }

    @Test
    public void test3() {
        assertThat(freqAlphabets("123")).isEqualTo("abc");
    }

    @Test
    public void test4() {
        assertThat(freqAlphabets("25#")).isEqualTo("y");
    }

    @Test
    public void test5() {
        assertThat(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"))
            .isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }

}
