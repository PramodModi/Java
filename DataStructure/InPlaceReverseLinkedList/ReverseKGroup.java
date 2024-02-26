package InPlaceReverseLinkedList;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node next;
    Node(int v, Node n){
        val = v;
        next = n;
    }
}
public class ReverseKGroup {
    public static Node reverseKGroup(Node head, int k){
        Node newHead = null;
        Node newTail = null;
        Node cur = head;
        while(cur != null){
            int count = k;
            Node tempHead = cur;
            Node temp = null;
            while(cur != null && count > 0){
                count --;
                temp = cur;
                cur = cur.next;
                if(count == 0){
                    temp.next =  null;
                    List<Node> revList = reverse(tempHead);
                    if(newHead == null){
                        newHead = revList.get(0);
                    }
                    else
                        newTail.next = revList.get(0);
                    revList.get(1).next = cur;
                    newTail = revList.get(1);
                }
            }
        }
        return newHead;
    }

    public static List<Node> reverse(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null){
            Node temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        List<Node> revList = new ArrayList<>();
        revList.add(prev);
        revList.add(head);
        return revList;
    }

    public static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node newHead = reverseKGroup(head, 2);
        printList(newHead);
    }
}
