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
