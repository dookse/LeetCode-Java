package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1213. Intersection of Three Sorted Arrays
public class P1213 {

    public List<Integer> arraysIntersection(final int[] arr1, final int[] arr2, final int[] arr3) {
        List<Integer> answer = new ArrayList<>();
        for (final int num : arr1) {
            if (contains(arr2, num) && contains(arr3, num)) {
                answer.add(num);
            }
        }
        return answer;
    }

    private boolean contains(final int[] arr, final int target) {
        return Arrays.binarySearch(arr, target) >= 0;
    }

    @Test
    public void test1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        assertThat(arraysIntersection(arr1, arr2, arr3)).isEqualTo(Arrays.asList(1, 5));
    }

    @Test
    public void test2() {
        int[] arr1 = {2, 3, 4, 5};
        int[] arr2 = {2, 3};
        int[] arr3 = {5, 6};
        assertThat(arraysIntersection(arr1, arr2, arr3)).isEqualTo(Collections.EMPTY_LIST);
    }

}
