package problems.easy;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1417. Reformat The String
public class P1417 {

    public String reformat(String s) {
        LinkedList<Character> alphas = new LinkedList<>();
        LinkedList<Character> numerics = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                alphas.add(c);
            } else {
                numerics.add(c);
            }
        }
        if (Math.max(alphas.size(), numerics.size()) - Math.min(alphas.size(), numerics.size()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean alphaStart = true;
        if (alphas.size() > numerics.size()) {
            sb.append(alphas.removeFirst());
        } else {
            alphaStart = false;
            sb.append(numerics.removeFirst());
        }
        int n = alphas.size() + numerics.size();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (alphaStart) {
                    sb.append(numerics.removeFirst());
                } else {
                    sb.append(alphas.removeFirst());
                }
            } else {
                if (alphaStart) {
                    sb.append(alphas.removeFirst());
                } else {
                    sb.append(numerics.removeFirst());
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        assertThat(reformat("a0b1c2")).isEqualTo("0a1b2c");
    }

    @Test
    public void test2() {
        assertThat(reformat("covid2019")).isEqualTo("c2o0v1i9d");
    }


}
