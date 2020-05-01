package explore.challenge30day.april.week3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            left += c == '(' ? 1 : -1;
            right += c != ')' ? 1 : -1;
            if (right < 0) {
                break;
            }
            left = Math.max(left, 0);
        }
        return left == 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "(*)", "(*))", "(((******))"})
    public void testTrue(String input) {
        assertThat(checkValidString(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"(", ")", "(()", ")("})
    public void testFalse(String input) {
        assertThat(checkValidString(input)).isFalse();
    }


}
