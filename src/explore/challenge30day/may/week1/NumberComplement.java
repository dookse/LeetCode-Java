package explore.challenge30day.may.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberComplement {

    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    @Test
    public void test1() {
        assertThat(findComplement(5)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(findComplement(1)).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(findComplement(2)).isEqualTo(1);
    }
}