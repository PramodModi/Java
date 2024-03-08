/*
LeetCode: 1209. Remove All Adjacent Duplicates in String II

https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and
equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.

Example 2:
    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation:
    First delete "eee" and "ccc", get "ddbbbdaa"
    Then delete "bbb", get "dddaa"
    Finally delete "ddd", get "aa"

Approach:
    The ask of this problem is to do operation on next element, in place of greater or smaller, ask is on equality.
    This problem also falls under monotonic stack pattern. Diiferent than typical monotonic problem:
        a. we need to compare for equality in place of greateer and smaller
        b. To avoid last entry of duplicate latters which makes duplicate letters of count k, we should first enter then compare
            Ex: s = "bbcggttciiiooisaa"
Steps:
    Stack element wil have letter and its corresponding count
    While appending letters, check if top element's letter in the stack is same as current letter a. If yes, then increase the count in top element b. If no, then append the letter with count = 1
    Check the count in top element, if it is K, then pop the top element from stack.
    join the letters in stack and return.
    While joining, consider the number of same letters.
* */

package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicate(String s, int k){
        Deque<int[]> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()[0]){
                stack.peek()[1] ++;
            }
            else{
                stack.push(new int[]{c,1});
            }
            if(stack.peek()[1] == k){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] letters : stack){
            for(int i = 0; i < letters[1]; i++){
                sb.append((char)letters[0]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String newstr = removeDuplicate(s, k);
        System.out.print(newstr);

    }
}
