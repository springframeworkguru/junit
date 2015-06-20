package guru.springframework.unittest.quickstart;


public class App
{
    public String concatAndConvertString(String str1, String str2){
        String concatedString=str1.concat(str2);
        return concatedString.toUpperCase();
    }
    }
