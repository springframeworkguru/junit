package guru.springframework.unittest.quickstart;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

   @Test
    public void testConcatAndConvertString() throws Exception {
       String expectedValue="HELLOWORLD";
       App app=new App();
       String actualValue=app.concatAndConvertString("Hello", "World");
       assertEquals(expectedValue, actualValue);
    }
}



