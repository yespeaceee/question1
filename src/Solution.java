import java.util.*;
import java.io.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

class Result {
    /*
     * Complete the 'customSort' function below.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void customSort(List <Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        // Assign elements and their count in the list and map
        for (int current : arr) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        // Sort the map using Collections CLass
        Collections.sort(outputArray, comp);

        // Final Output
        try {
            for (Integer i : outputArray) {
                System.out.println(i);
            }
        } catch (Exception err) {
            System.out.print(err.getMessage());
        }
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List < Integer > arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        Result.customSort(arr);
        bufferedReader.close();
    }
}

