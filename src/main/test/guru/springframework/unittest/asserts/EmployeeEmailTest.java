package guru.springframework.unittest.asserts;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class EmployeeEmailTest {
    @Test
    public void testValidEmailId() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        /*Act*/
        boolean result = empEmail.isValidEmailId("andy@testdomain.com");
        /*Assert*/
        assertTrue("Valid email ID failed ", result );
    }

    @Test
    public void testInvalidEmailId() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        /*Act*/
        boolean result= empEmail.isValidEmailId("andy@testdomain");
        /*Assert*/
        assertFalse("Invalid email ID passed ", result);
    }

    @Test
    public void testAddEmailId() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        empEmail.addEmployeeEmailId("Emp01","peter@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "mary@testdomain.com");
        /*Act*/
        int size=empEmail.hashMap.size();
        /*Assert*/
        assertEquals("Incorrect collection size ", 2, size);
    }
    @Test
    public void testAddEmailIdWithDuplicateKey() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        empEmail.addEmployeeEmailId("Emp01","peter@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "mary@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "henry@testdomain.com");
        /*Act*/
        int size=empEmail.hashMap.size();
        /*Assert*/
        assertNotEquals("Duplicate key in collection ", 3, size);
    }

    @Test
    public void testGetExistingEmailId() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        empEmail.addEmployeeEmailId("Emp01","peter@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "mary@testdomain.com");
        /*Act*/
        String val = empEmail.getEmployeeEmailId("Emp02");
        /*Assert*/
        assertNotNull("Returned null for existing employee", val);
    }

    @Test
    public void testGetNonExistingEmailId() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail=new EmployeeEmail();
        empEmail.addEmployeeEmailId("Emp01","peter@testdomain.com");
        empEmail.addEmployeeEmailId("Emp02", "mary@testdomain.com");
       /*Act*/
        String val = empEmail.getEmployeeEmailId("Emp05");
       /*Assert*/
        assertNull("Failed to return null for non existing employee", val);
    }

    @Test
    public void testIfObjectsAreSame() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail1=new EmployeeEmail();
        empEmail1.addEmployeeEmailId("Emp01","peter@testdomain.com");
        EmployeeEmail empEmail2=new EmployeeEmail();
        empEmail1.addEmployeeEmailId("Emp02", "mary@testdomain.com");
        /*Act*/
        Map map1=empEmail1.hashMap;
        Map map2=empEmail2.hashMap;
        map1= map2;
        /*Assert*/
        assertSame("Failed because objects are not same ", map1, map2);
    }

    @Test
    public void testIfObjectsAreNotSame() throws Exception {
        /*Arrange*/
        EmployeeEmail empEmail1=new EmployeeEmail();
        empEmail1.addEmployeeEmailId("Emp01","peter@testdomain.com");
        EmployeeEmail empEmail2=new EmployeeEmail();
        empEmail1.addEmployeeEmailId("Emp02", "mary@testdomain.com");
        /*Act*/
        Map map1=empEmail1.hashMap;
        Map map2=empEmail2.hashMap;
        /*Assert*/
        assertNotSame("Failed because objects are same ", map1, map2);
    }


}