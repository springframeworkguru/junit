package guru.springframework.unittest.matchers;

import java.util.HashSet;
import java.util.Set;

public class MatchersDemo {

    public String toConcatedUpperCase(String str1,String str2){

        return str1.concat(str2).toUpperCase();
    }
    public double floatingPointMultiplication(double num1, double num2) {
        return num1 * num2;
    }

    private Set<String> stringCol = new HashSet<>();
    public boolean addStringToCollection(final String newString)
    {
       return this.stringCol.add(newString);
    }
    public Set<String> getStringCollection()
    {
        return this.stringCol;
    }

}
