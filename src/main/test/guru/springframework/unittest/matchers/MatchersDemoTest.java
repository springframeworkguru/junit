package guru.springframework.unittest.matchers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MatchersDemoTest {
    MatchersDemo matchersDemo;
    @Before
    public void setup(){
        matchersDemo=new MatchersDemo();
    }
   @Test
    public void testToConcatedUpperCase() throws Exception {
        String expected="HELLOWORLD";
        String actual=matchersDemo.toConcatedUpperCase("hello","world");
        assertThat(actual, is(equalTo(expected)));
    }
    @Test
    public void testToConcatedUpperCaseStartWith() throws Exception {
        String expected="HELLO";
        String actual=matchersDemo.toConcatedUpperCase("hello","world");
        assertThat(actual, startsWith(expected));
    }

    @Test
    public void testToConcatedUpperCaseContainsString() throws Exception {
        String expected="WORLD";
        String actual=matchersDemo.toConcatedUpperCase("hello","world");
        assertThat(actual, containsString(expected));
    }
   @Test
    public void testToConcatedUpperCaseForAllMatchers() throws Exception {
        String expected="HELLO";
        String actual=matchersDemo.toConcatedUpperCase("hello","world");
        assertThat(actual, is(allOf(notNullValue(), instanceOf(String.class), startsWith(expected), containsString(expected))));
    }

}