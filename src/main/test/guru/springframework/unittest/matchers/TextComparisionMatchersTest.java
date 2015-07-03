package guru.springframework.unittest.matchers;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TextComparisionMatchersTest {
    MatchersDemo matchersDemo;
    String actual;
    @Before
    public void setup(){
        matchersDemo=new MatchersDemo();
        actual= matchersDemo.toConcatedUpperCase("Hello","World");
    }

    @Test
    public void testIgnoringCase()throws Exception
    {
        assertThat(actual, equalToIgnoringCase("HeLLoWORld"));
    }

    @Test
    public void testIgnoringWhitespace()throws Exception
    {
        assertThat(actual, equalToIgnoringWhiteSpace("  HELLOWORLD "));
    }

    @Test
    public void testContainsInOrder()throws Exception
    {
        assertThat("Actual string under test", stringContainsInOrder(Arrays.asList("Actual", "string", "under","test")));
    }

}
