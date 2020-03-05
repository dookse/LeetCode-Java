package problems.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P1108 {

    public String defangIPaddr(final String address) {
        return address.replace(".", "[.]");
    }

    @Test
    public void test1() {
        assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
    }

    @Test
    public void test2() {
        assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }
}
