package problems.easy;

import java.util.stream.IntStream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1304. Find N Unique Integers Sum up to Zero
public class P1304 {

    public int[] sumZero(final int n) {
        int[] answer = new int[n];
        int num = n / 2 * -1;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
            num++;
        }
        if (n % 2 == 0) {
            answer[n - 1] += n / 2;
        }
        return answer;
    }

    @Test
    public void test1() {
        test(5);
    }

    @Test
    public void test2() {
        test(3);
    }

    @Test
    public void test3() {
        test(1);
    }

    @Test
    public void test4() {
        test(2);
    }

    @Test
    public void test5() {
        test(999);
    }

    @Test
    public void test6() {
        test(1000);
    }

    private void test(final int n) {
        final int[] arr = sumZero(n);
        assertThat(IntStream.of(arr).sum()).isEqualTo(0);
    }

}
