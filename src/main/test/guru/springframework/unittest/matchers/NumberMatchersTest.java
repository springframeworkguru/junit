package guru.springframework.unittest.matchers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class NumberMatchersTest {
    MatchersDemo matchersDemo;
    double actual;
    @Before
    public void setup(){
        matchersDemo=new MatchersDemo();
        actual= matchersDemo.floatingPointMultiplication(2.32,3);
    }

    @Test
    public void testFloatingPointMultiplication()throws Exception
    {
        assertThat(actual, closeTo(6.96, 0.0005));
    }

    @Test
    public void testFloatingPointMultiplicationGreaterThan()throws Exception
    {
        assertThat(actual, greaterThan(6.0));
    }


}
