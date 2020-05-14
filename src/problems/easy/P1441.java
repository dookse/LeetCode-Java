package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1441. Build an Array With Stack Operations
public class P1441 {

    public List<String> buildArray(int[] target, int n) {
        int num = 0;
        List<String> answer = new ArrayList<>();
        for (int value : target) {
            num++;
            if (value > num) {
                for (int j = 0; j < value - num; j++) {
                    answer.add("Push");
                    answer.add("Pop");
                }
                num = value;
            }
            answer.add("Push");
        }
        return answer;
    }

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("Push", "Push", "Pop", "Push");
        assertThat(buildArray(new int[]{1, 3}, 3)).isEqualTo(expected);
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList("Push", "Push", "Push");
        assertThat(buildArray(new int[]{1, 2, 3}, 3)).isEqualTo(expected);
    }

    @Test
    public void test3() {
        List<String> expected = Arrays.asList("Push", "Push");
        assertThat(buildArray(new int[]{1, 2}, 4)).isEqualTo(expected);
    }

    @Test
    public void test4() {
        List<String> expected = Arrays.asList("Push", "Pop", "Push", "Push", "Push");
        assertThat(buildArray(new int[]{2, 3, 4}, 4)).isEqualTo(expected);
    }

}
