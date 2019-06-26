import java.util.*;
import java.io.*;

// Implement Comparator Interface to sort the values 
public class SortComparator implements Comparator < Integer > {
    private final Map < Integer,
            Integer > freqMap;

    // Assign the specified map 
    SortComparator(Map < Integer, Integer > tFreqMap) {
        this.freqMap = tFreqMap;
    }

    // Compare the values 
    @Override
    public int compare(Integer k1, Integer k2) {

        // Compare value by frequency 
        int freqCompare = freqMap.get(k1).compareTo(freqMap.get(k2));

        // Compare value if frequency is equal 
        int valueCompare = k1.compareTo(k2);

        // If frequency is equal, then just compare by value, otherwise - 
        // compare by the frequency. 
        if (freqCompare == 0)
            return valueCompare;
        else
            return freqCompare;
    }
}