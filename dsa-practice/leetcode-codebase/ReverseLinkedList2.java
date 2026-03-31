//Leetcode question 92

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

public class ReverseLinkedList2 {

    public static ListNode reverse(ListNode current, ListNode tail){
        if(current.next==tail)       return current;
        ListNode head=reverse(current.next,tail);
        current.next.next=current;
        current.next=tail;
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1,head);
        ListNode current=dummy;
        for(int i=0;i<left-1;i++)       current=current.next;
        ListNode tail=current.next;
        for(int i=left;i<=right;i++)    tail=tail.next;
        current.next=reverse(current.next,tail);
        while(current.next!=tail)        current=current.next;
        current.next=tail;
        return dummy.next;
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

        int left = 2;
        int right = 4;

        System.out.print("Before reversing: ");
        display(head);

        head =reverseBetween(head, left, right);
        
        System.out.print("After reversing: ");
        display(head);

    }
}
