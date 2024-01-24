/*
Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

Example 1:

    Input: "aappp"
    Output: "papap"
    Explanation: In "papap", none of the repeating characters come next to each other.
* */
package topKElements;

import java.util.*;

public class RearrangeString {
    public static String rearrangeString(String str){
        Map<Character, Integer> map = new HashMap();
        for(Character c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        char[] output = new char[str.length()];
        Arrays.fill(output, ' ');
        int index = 0;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            int freq = entry.getValue();
            char c = entry.getKey();
            while(freq > 0){
                freq -= 1;
                if(index > 0 && output[index-1] == c){
                    return "";
                }
                output[index] = c;
                index += 2;
                if(index >= str.length()){
                    index = 1;
                }
            }
        }
        return new String(output);
    }

    public static void main(String[] args) {
        String str = "aappp";
        //String str = "aaaapp";
        String output = rearrangeString(str);
        System.out.println(output);
    }
}
