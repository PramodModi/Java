/*
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

Example 1:

    Input
    ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
    [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
    Output
    [null, null, null, null, null, null, null, 5, 7, 5, 4]

    Explanation
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
* */

package topKElements;

import java.util.*;

public class FrequencyStack {
    Map<Integer, Integer> freqMap;
    List<Stack<Integer>> stackList;
    public FrequencyStack(){
        freqMap = new HashMap<>();
        stackList = new ArrayList<>();
        stackList.add(new Stack<>());
    }
    public void push(int value){
        freqMap.put(value, freqMap.getOrDefault(value, 0)+1);
        int freq = freqMap.get(value);
        if(freq == stackList.size()){
            stackList.add(new Stack<>());
        }
        stackList.get(freq).push(value);
    }
    public int pop(){
        Stack<Integer> list = stackList.get(stackList.size()-1);
        int value = list.pop();
        if(list.isEmpty()){
            stackList.remove(stackList.size()-1);
        }
        int freq = freqMap.get(value);
        freqMap.put(value, freq-1);
        return value;
    }

    public static void main(String[] args) {
        FrequencyStack fs =  new FrequencyStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }

}
