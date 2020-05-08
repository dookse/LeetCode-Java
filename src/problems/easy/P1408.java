package problems.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1408. String Matching in an Array
public class P1408 {

    public List<String> stringMatching(String[] words) {
        List<String> answer = new LinkedList<>();
        for (String word : words) {
            for (String word2 : words) {
                if (!word.equals(word2) && word2.contains(word)) {
                    answer.add(word);
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    public void test1() {
        String[] input = {"mass", "as", "hero", "superhero"};
        List<String> expected = Arrays.asList("as", "hero");
        assertThat(stringMatching(input)).isEqualTo(expected);
    }

    @Test
    public void test2() {
        String[] input = {"blue", "green", "bu"};
        List<String> expected = Collections.emptyList();
        assertThat(stringMatching(input)).isEqualTo(expected);
    }

}
