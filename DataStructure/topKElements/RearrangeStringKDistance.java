/*
Given a string and a number ‘K’, find if the string can be rearranged such that the
same characters are at least ‘K’ distance apart from each other.

Example 1:

    Input: "mmpp", K=2
    Output: "mpmp" or "pmpm"
    Explanation: All same characters are 2 distance apart.
* */
package topKElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistance {
    public static String rearrangeString(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        char[] output = new char[str.length()];
        int index = 0;
        int i = 1;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            char key = entry.getKey();
            int freq = entry.getValue();
            while(freq > 0){
                if(index > 0 && output[index-1] == key){
                    return "";
                }
                output[index] = key;
                freq -= 1;
                index += k;
                if(index >= str.length()){
                    index = i;
                    i += 1;
                }
            }
        }
        return new String(output);
    }

    public static void main(String[] args) {
        String str = "mmpp";
        int k =2;
        String output = rearrangeString(str, k);
        System.out.print(output);

    }
}
