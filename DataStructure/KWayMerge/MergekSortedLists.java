/*
* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
  Example:
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
* */
package KWayMerge;
import java.util.PriorityQueue;

class Node{
    int val;
    Node next;
    public Node(int val, Node next ){

        this.val = val;
        this.next = next;
    }
}
public class MergekSortedLists {

    private Node mergeKLists(Node[] lists){
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(Node n : lists){
            minHeap.add(n);
        }
        Node head = null;
        Node tail = null;

        while(!minHeap.isEmpty()){
            Node  n = minHeap.poll();
            if(head == null){
                head = n;
                tail = n;
            }
            else{
                tail.next = n;
                tail = n;
            }
            if(n.next != null){
                minHeap.add(n.next);
            }
        }

        return head;
    }

    private void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new Node(4, new Node(5, null)));
        Node node2 = new Node(1, new Node(3, new Node(4, null)));
        Node node3 = new Node(2, new Node(6, null));
        Node[] lists = {node1, node2, node3};
        MergekSortedLists mainClass = new MergekSortedLists();
        Node head = mainClass.mergeKLists(lists);
        mainClass.printList(head);
    }

}
