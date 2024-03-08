/*
LeetCode : 316. Remove Duplicate Letters

https://leetcode.com/problems/remove-duplicate-letters/

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your
result is the smallest in lexicographical order among all possible results.

Example 1:
    Input: s = "bcabc"
    Output: "abc"
Example 2:
    Input: s = "cbacdcbc"
    Output: "acdb"

Approach:
    As the problem states that result should have in lexicographocal order, that means, result should have next
    greater letter. So, this problem belongs to monotonic stack pattern.
    Additionaly, as all letters should have visted only once and no missing letter. So, will use set to have
    visited letter. While pushing the letter in stack, will add the letter in visited set.
    And while popping from stack, will remove from set.
    Since all letters should have in the result, so before popping from stack, check if the letter is available at
    the later. For this we should have final position of each letter in the hashmap.
* */
package MonotonicStack;

import java.util.*;

public class RemoveAdjuscentDuplicateString {
    public static String removeDuplicate(String str){
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> visited = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), i);
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!visited.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    visited.remove(stack.pop());
                }
                stack.push(c);
                visited.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast()); //Print the string from first to last.
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        String result = removeDuplicate(str);
        System.out.println(result);
    }
}
