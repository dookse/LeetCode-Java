package explore.challenge30day.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(final String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        for (final String str : strs) {
            String sortStr = sort(str);
            Integer idx = map.putIfAbsent(sortStr, map.size());
            if (idx == null) {
                List<String> subList = new ArrayList<>();
                subList.add(str);
                answer.add(subList);
            } else {
                answer.get(idx).add(str);
            }
        }
        return answer;
    }

    private String sort(final String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    @Test
    public void test1() {
        List<List<String>> expected = List.of(
            List.of("eat", "tea", "ate"),
            List.of("tan", "nat"),
            List.of("bat")
        );
        assertThat(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})).isEqualTo(expected);
    }


}
