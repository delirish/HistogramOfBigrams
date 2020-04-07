import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

public class Tests {
    Map<String, Integer> expectedMap = new HashMap<>();
    {
        expectedMap.put("the quick", 2);
        expectedMap.put("quick brown", 1);
        expectedMap.put("brown fox", 1);
        expectedMap.put("fox and", 1);
        expectedMap.put("and the", 1);
        expectedMap.put("quick blue", 1);
        expectedMap.put("blue hare", 1);
    }

    @Test
    public void testParsingFile(){

       String actual = BigramParsing.parseTextToString("example.txt");
       String expected = "The quick brown fox and the quick blue hare.";
       Assert.assertEquals("File and string contents do not match. Assertion FAILED.", expected, actual);

    }

    @Test
    public void testHistogram(){

        Map actualMap = BigramParsing.createHistogramFromFile("example.txt");

        Assert.assertEquals("Histograms do not match. Assertion FAILED.", expectedMap, actualMap);

    }

    @Test
    public void testHistogramWithSpecialCharacters(){


        Map actualMap = BigramParsing.createHistogramFromFile("specialCharacters.txt");

        Assert.assertEquals("Histograms do not match. Assertion FAILED.", expectedMap, actualMap);

    }

    @Test
    public void testHistogramWithExtraSpaces(){

        Map actualMap = BigramParsing.createHistogramFromFile("extraSpace.txt");

        Assert.assertEquals("Histograms do not match. Assertion FAILED.", expectedMap, actualMap);
    }

}
