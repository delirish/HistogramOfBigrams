import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class BigramParsing {


    public static String parseTextToString(String path){
        StringBuilder sb = new StringBuilder();
        try(Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)){
            stream.forEach(s -> sb.append(s).append(" "));
        }catch (IOException e){
            e.printStackTrace();
        }

       String result = sb.toString().trim();
        return result;
    }

    public static Map createHistogramFromFile(String path){
        String text = parseTextToString(path);
        String [] arr = text.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");

        Map<String, Integer> bigramCounter = new HashMap<String, Integer>();

        for(int i = 0; i < arr.length-1; i++){
            String bigram = arr[i] + " " + arr[i+1];

            if(!bigramCounter.containsKey(bigram)){
                bigramCounter.put(bigram, 1);
            }else{
                bigramCounter.put(bigram, bigramCounter.get(bigram) + 1);
            }
        }

        return bigramCounter;
    }


}
