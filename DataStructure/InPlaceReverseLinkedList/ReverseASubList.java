/*
*LeetCode: 92. Reverse Linked List II

https://leetcode.com/problems/reverse-linked-list-ii/

Given the head of a singly linked list and two integers left and right where left <= right,
* reverse the nodes of the list from position left to position right, and return the reversed list.
* Example:
   Input: head = [1,2,3,4,5], left = 2, right = 4
   Output: [1,4,3,2,5]
* */
package InPlaceReverseLinkedList;


import java.util.ArrayList;
import java.util.List;

// Node class is already defined in ReverseKGroup file. So, commented Noe class code here.
//class Node{
//    int val;
//    Node next;
//    Node(int v, Node n){val = v; next = n;}
//}
public class ReverseASubList {
    public static Node reverseSubList(Node head, int left, int right){
        Node cur = head;
        Node start = head;
        Node prev = null, end = null;
        while(right > 0){
            if(left > 1){
                prev = start;
                start = start.next;
                left --;
            }
            end = cur;
            cur = cur.next;
            right --;
        }
        end.next = null;
        List<Node> rList = reverse(start);
        if(prev == null){
            head.next = rList.get(0);
        }
        else{
            prev.next = rList.get(0);
        }
        Node rTail = rList.get(1);
        rTail.next = cur;
        return head;
    }

    public static List<Node> reverse(Node head){
        Node cur = head, prev = null;
        while(cur != null){
            Node temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        List<Node> rList = new ArrayList<>();
        rList.add(prev);
        rList.add(head);
        return rList;
    }
    public static void printLinkedList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node newHead = reverseSubList(head, 2, 4);
        printLinkedList(newHead);
    }
}
