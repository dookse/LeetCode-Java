package explore.challenge30day.may.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        return find(1, n);
    }

    private int find(int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = (end - start) / 2 + start;
        if (isBadVersion(mid)) {
            return find(start, mid - 1);
        } else {
            return find(mid + 1, end);
        }
    }

    // The isBadVersion API is defined in the parent class VersionControl.
    private boolean isBadVersion(int version) {
        return version == 2 || version == 3;
    }

    @Test
    public void test() {
        assertThat(firstBadVersion(3)).isEqualTo(2);
    }

}
