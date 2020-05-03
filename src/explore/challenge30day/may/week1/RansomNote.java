package explore.challenge30day.may.week1;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> wordMap = new HashMap<>();
        char[] magazineChars = magazine.toCharArray();
        for (char c : magazineChars) {
            wordMap.computeIfPresent(c, (key, value) -> value + 1);
            wordMap.putIfAbsent(c, 1);
        }
        char[] ransomWords = ransomNote.toCharArray();
        for (char c : ransomWords) {
            Integer count = wordMap.get(c);
            if (count == null || count < 1) {
                return false;
            }
            wordMap.computeIfPresent(c, (key, value) -> value - 1);
        }
        return true;
    }

    @Test
    public void test1() {
        assertThat(canConstruct("a", "b")).isEqualTo(false);
    }

    @Test
    public void test2() {
        assertThat(canConstruct("aa", "ab")).isEqualTo(false);
    }

    @Test
    public void test3() {
        assertThat(canConstruct("aa", "aab")).isEqualTo(true);
    }

    @Test
    public void test4() {
        assertThat(canConstruct("abc", "aaabbbcc")).isEqualTo(true);
    }
}
