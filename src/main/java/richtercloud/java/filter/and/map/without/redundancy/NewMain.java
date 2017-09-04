package richtercloud.java.filter.and.map.without.redundancy;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.text.similarity.LevenshteinDistance;

/**
 *
 * @author richter
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String x = "some string";
        Collection<String> strings = new LinkedList<>(Arrays.asList("not some string",
                "some other string"));
        int levenshteinLimit = 10;
        Map<Integer, String> stringsLevenshteinMap = strings.stream()
                .filter(string -> LevenshteinDistance.getDefaultInstance().apply(x, string) < levenshteinLimit)
                .collect(Collectors.toMap(string -> LevenshteinDistance.getDefaultInstance().apply(x, string), Function.identity()));
        System.out.println(stringsLevenshteinMap);
    }
    
}
