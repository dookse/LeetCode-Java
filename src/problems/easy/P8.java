package problems.easy;//Implement atoi which converts a string to an integer.
//
//    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//    If no valid conversion could be performed, a zero value is returned.
//
//    Note:
//
//    Only the space character ' ' is considered as whitespace character.
//    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//    Example 1:
//
//    Input: "42"
//    Output: 42
//    Example 2:
//
//    Input: "   -42"
//    Output: -42
//    Explanation: The first non-whitespace character is '-', which is the minus sign.
//    Then take as many numerical digits as possible, which gets 42.
//    Example 3:
//
//    Input: "4193 with words"
//    Output: 4193
//    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//    Example 4:
//
//    Input: "words and 987"
//    Output: 0
//    Explanation: The first non-whitespace character is 'w', which is not a numerical
//    digit or a +/- sign. Therefore no valid conversion could be performed.
//    Example 5:
//
//    Input: "-91283472332"
//    Output: -2147483648
//    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//    Thefore INT_MIN (−231) is returned.

import java.math.BigInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P8 {

    public int myAtoi(final String str) {
        char[] input = str.trim().split(" ")[0].toCharArray();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            char inputChar = input[i];
            if (isNumberOrSign(inputChar, i)) {
                output.append(inputChar);
            } else if (inputChar != ' ') {
                break;
            }
        }
        try {
            BigInteger result = new BigInteger(output.toString());
            if (result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            } else if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            } else {
                return result.intValue();
            }
        } catch (final NumberFormatException e) {
            return 0;
        }
    }

    private static boolean isNumberOrSign(final char inputChar, final int i) {
        return ('0' <= inputChar && inputChar <= '9') || ((inputChar == '-' || inputChar == '+') && i == 0);
    }


    @Test
    public void test01() {
        assertEquals(42, myAtoi("42"));
    }

    @Test
    public void test02() {
        assertEquals(-42, myAtoi("   -42"));
    }

    @Test
    public void test03() {
        assertEquals(4193, myAtoi("4193 with words"));
    }

    @Test
    public void test04() {
        assertEquals(0, myAtoi("words and 987"));
    }

    @Test
    public void test05() {
        assertEquals(-2147483648, myAtoi("-91283472332"));
    }

    @Test
    public void test06() {
        assertEquals(0, myAtoi(".1"));
    }

    @Test
    public void test07() {
        assertEquals(3, myAtoi("3.14159"));
    }

    @Test
    public void test08() {
        assertEquals(0, myAtoi("-"));
    }

    @Test
    public void test09() {
        assertEquals(0, myAtoi("+"));
    }

    @Test
    public void test10() {
        assertEquals(0, myAtoi("+-2"));
    }

    @Test
    public void test11() {
        assertEquals(1, myAtoi("+1"));
    }

    @Test
    public void test12() {
        assertEquals(2147483647, myAtoi("20000000000000000000"));
    }

    @Test
    public void test13() {
        assertEquals(-5, myAtoi("-5-"));
    }


}
