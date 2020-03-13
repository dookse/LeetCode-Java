package problems.easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 760. Find Anagram Mappings
public class P760 {

    public int[] anagramMappings(final int[] a, final int[] b) {
        int[] answer = new int[a.length];
        Map<Integer, Integer> anagramMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            anagramMap.put(b[i], i);
        }
        for (int i = 0; i < b.length; i++) {
            answer[i] = anagramMap.get(a[i]);
        }
        return answer;
    }

    @Test
    public void test1() {
        assertThat(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}))
            .isEqualTo(new int[]{1, 4, 3, 2, 0});
    }

}
