package explore.challenge30day.may.week1;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.computeIfPresent(c, (key, value) -> value + 1);
            map.putIfAbsent(c, 1);
        }
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.getOrDefault(s.charAt(i), -1) == 1) {
                return i;
            }
        }
        return answer;
    }


    @Test
    public void test1() {
        assertThat(firstUniqChar("leetcode")).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(firstUniqChar("loveleetcode")).isEqualTo(2);
    }

}
