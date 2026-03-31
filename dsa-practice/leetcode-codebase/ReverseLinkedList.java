//Leetcode question 206

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return current;
    }

    public static void display(ListNode head){
        if(head == null){
            System.out.print("[]");
            return;
        }
        System.out.print("["+head.val);
        ListNode current = head.next;
        while(current!=null){
            System.out.print(", "+current.val);
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(5);
        display(head);
        head = reverseList(head);
        display(head);

    }
}
