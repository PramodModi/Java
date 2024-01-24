/*
Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
    Input: s = "tree"
    Output: "eert"
    Explanation: 'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
    Input: s = "cccaaa"
    Output: "aaaccc"
    Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
    Note that "cacaca" is incorrect, as the same characters must be together.
* */
package topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String frequencySort(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(Character c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            Character c = entry.getKey();
            Integer f = entry.getValue();
            while(f>0){
                sb.append(c);
                f -= 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Aarav";
        String result = frequencySort(s);
        System.out.println(result);
    }
}
