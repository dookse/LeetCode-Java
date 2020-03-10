package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1119. Remove Vowels from a String
public class P1119 {

    public String removeVowels(final String s) {
        return s.replaceAll("[aeiou]", "");
    }

    @Test
    public void test1() {
        assertThat(removeVowels("leetcodeisacommunityforcoders")).isEqualTo("ltcdscmmntyfrcdrs");
    }

    @Test
    public void test2() {
        assertThat(removeVowels("aeiou")).isEqualTo("");
    }
}
