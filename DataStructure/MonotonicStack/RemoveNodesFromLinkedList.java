/*
Given the head node of a singly linked list, modify the list such that any node that has a
node with a greater value to its right gets removed. The function should return the head of the modified list.

Example:
    Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
    Output: 7 -> 4 -> 2 -> 1
    Explanation: 5 and 3 are removed as they have nodes with larger values to their right.
* */
package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

class Node{
    int val;
    Node next;
    Node(int v,Node n){val = v; next =n;}
}
public class RemoveNodesFromLinkedList {
    public static Node removeGreaterNode(Node head){
        Deque<Node[]> stack = new ArrayDeque<>();
        Node temp = head;
        Node prev = null;
        while(temp != null){
            while(!stack.isEmpty() && temp.val > stack.peek()[0].val){
                Node[] nodes = stack.pop();
                if(nodes[1] != null)
                {
                    nodes[1].next = nodes[0].next;
                }
                else   head = nodes[0].next;
                nodes[0].next = null;
                nodes[0] = null;

            }
            stack.push(new Node[]{temp, prev});
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val);
            System.out.print("->");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(5, new Node(3, new Node(7, new Node(4, new Node(2, new Node(1, null))))));
        Node newHead = removeGreaterNode(head);
        printList(newHead);
    }
}
