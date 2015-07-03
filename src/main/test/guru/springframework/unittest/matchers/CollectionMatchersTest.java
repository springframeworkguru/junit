package guru.springframework.unittest.matchers;

import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CollectionMatchersTest {
    MatchersDemo matchersDemo;
    @Before
    public void setup(){
        matchersDemo=new MatchersDemo();
        matchersDemo.addStringToCollection("First string");
        matchersDemo.addStringToCollection("Second string");
        matchersDemo.addStringToCollection("Third string");
    }

    @Test
    public void testForCollectionSize() throws Exception{
        Set<String> actual=matchersDemo.getStringCollection();
        int expected=3;
        assertThat(actual, hasSize(expected));
    }


    @Test
    public void testForMultipleItemsInCollection()throws Exception{
        Set<String> actual=matchersDemo.getStringCollection();
        String expected1="First string";
        String expected2="Third string";
        assertThat(actual, hasItems(expected1, expected2));
    }

    @Test
    public void testForMultipleItemsWithAnyOrderInCollection() throws Exception{
        Set<String> actual=matchersDemo.getStringCollection();
        String expected1="First string";
        String expected2="Second string";
        String expected3="Third string";
        assertThat(actual, containsInAnyOrder(expected1, expected2, expected3));
    }


}
