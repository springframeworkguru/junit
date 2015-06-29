package guru.springframework.unittest.asserts;
import org.junit.*;
import java.util.Map;
import static org.junit.Assert.*;

public class EmployeeEmailAnnotationsTest {
    EmployeeEmail empEmail;
    static int num;
    @BeforeClass
    public static void oneTimeSetup(){
     num=1;
     System.out.println("JUnit Call:"+num+" @BeforeClass oneTimeSetup");
    }
    @Before
    public void setup(){
        num+=1;
        System.out.println("JUnit Call:"+num+" @Before setUp");
        empEmail=new EmployeeEmail();
        empEmail.addEmployeeEmailId("Emp01","peter@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "mary@testdomain.com");
    }
    @After
    public void cleanup()
    {
        num+=1;
        System.out.println("JUnit Call:" + num + " @After cleanup");
        empEmail.hashMap.clear();
    }
    @AfterClass
    public static void oneTimeCleanup()
    {
        num+=1;
        System.out.println("JUnit Call:"+num+" @AfterClass oneTimeCleanup");
        num=0;
    }
    @Test(timeout = 100)
    public void testDataAccessTimeout(){
        num+=1;
        System.out.println("JUnit Call:"+num+" @Test testDataAccessTimeout");
        String val = empEmail.getEmployeeEmailId("Emp02");
    }
    @Test
    @Ignore("Test code not ready")
    public void testWithMoreData(){
        /*ToDO: */
    }
    @Test(expected = IllegalArgumentException.class)
    public void testForIllegalArgumentException()
    {
        num+=1;
        System.out.println("JUnit Call:" + num + " @Test testForIllegalArgumentException");
        String val = empEmail.getEmployeeEmailId(1);

    }
}
