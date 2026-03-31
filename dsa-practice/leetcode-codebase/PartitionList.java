//Leetcode Problem Number 86

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

public class PartitionList {
    
    public static ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode greaterThanOrEqualToX = new ListNode(0);
        ListNode lessThanX = new ListNode(0);
        lessThanX.next = greaterThanOrEqualToX;
        head = lessThanX;

        while(current!= null){
            if(current.val < x){
                ListNode temp = lessThanX.next;
                lessThanX.next = current;
                current = current.next;
                lessThanX = lessThanX.next;
                lessThanX.next = temp;
            }
            else{
                greaterThanOrEqualToX.next = current;
                current = current.next;
                greaterThanOrEqualToX = greaterThanOrEqualToX.next;
                greaterThanOrEqualToX.next = null;
            }
        }
        lessThanX.next = lessThanX.next.next;
        return head.next;
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
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(2);

        int x = 3;
        System.out.print("Before partitioning: ");
        display(head);
        head = partition(head, x);
        System.out.print("After partitioning: ");
        display(head);
    }
}
;