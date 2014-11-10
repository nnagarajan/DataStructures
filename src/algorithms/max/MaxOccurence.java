package algorithms.max;

import java.util.*;

/**
 * Created by nanagarajan on 11/5/2014.
 */
public class MaxOccurence {

    /**
     * Fill out the body of the below method which returns the character found most frequently in the input string. If there is multiple characters with the same frequency then throw an exception.
     * Example input => outputs
     * “a” => ‘c'
     * “aaabcdef” => ‘a’
     * “aabb” => [exception]
     */
    public static char getMaxOccurances(String input) {

        // throw exception when input is empty
        if (input == null)
            throw new RuntimeException("input string is empty");

        char[] arrayInput = input.toCharArray();

        Map<Character, Integer> mapOfOccurrence = new HashMap<Character, Integer>();

        int maxOccurrence = 0;

        char maxOccurredChar = 1;

        int noOfMaxOccurrence = 0;


        for (int i = 0; i < arrayInput.length; i++) {
            Character ch = arrayInput[i];
            if (mapOfOccurrence.keySet().contains(ch)) {
                int val = mapOfOccurrence.get(ch);
                mapOfOccurrence.put(ch, ++val);
                if (maxOccurrence < val) {
                    maxOccurrence = val;
                    noOfMaxOccurrence = 0;
                    maxOccurredChar = ch;
                }
                if (maxOccurrence == val) {
                    ++noOfMaxOccurrence;
                }

            } else {
                mapOfOccurrence.put(ch, 1);
                if (maxOccurrence < 1) {
                    maxOccurrence = 1;
                    maxOccurredChar = ch;
                }
            }
            if (i == arrayInput.length - 1) {
                if (noOfMaxOccurrence > 1) {
                    throw new RuntimeException("More than one char with max occurrence");
                }
            }

        }

        return maxOccurredChar;
    }

}
