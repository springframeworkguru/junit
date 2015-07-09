package guru.springframework.unittest.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class EmailIdValidatorTest {

    private String emailId;
    private boolean expected;

    public EmailIdValidatorTest(String emailId, boolean expected) {
        this.emailId = emailId;
        this.expected = expected;
    }
    @Parameterized.Parameters(name= "{index}: isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"mary@testdomain.com", true},
                        {"mary.smith@testdomain.com", true},
                        {"mary_smith123@testdomain.com", true},
                        {"mary@testdomaindotcom", false},
                        {"mary-smith@testdomain", false},
                        {"testdomain.com", false}
                }
        );
    }
    @Test
    public void testIsValidEmailId() throws Exception {
        boolean actual= EmailIdUtility.isValid(emailId);
        assertThat(actual, is(equalTo(expected)));
    }
}