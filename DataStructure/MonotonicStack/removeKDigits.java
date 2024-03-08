/*
https://leetcode.com/problems/remove-k-digits/

Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
* */
package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class removeKDigits {
    public static String removeKDigits(String nums, int k){
        Deque<Character> stack = new ArrayDeque<>();
        for(char n : nums.toCharArray()){
            while(!stack.isEmpty() && n < stack.peek() && k > 0){
                k --;
                stack.pop();
            }
            stack.push(n);
        }
        while (k > 0 && !stack.isEmpty()){
            k --;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char c = stack.pollLast();
            if(c == '0' && sb.length() == 0)
                continue;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String nums = "1432219";
        int k = 3;
        String result = removeKDigits(nums, k);
        System.out.println(result);
    }
}
