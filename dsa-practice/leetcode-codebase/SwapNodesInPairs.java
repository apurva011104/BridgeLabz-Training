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

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode next=current.next;
        current.next=next.next;
        next.next=current;
        head=next;
        ListNode prev=current;
        current=current.next;
        while(current!=null && current.next!=null){
            next=current.next;
            current.next=next.next;
            next.next=current;
            prev.next=next;
            prev=current;
            current=current.next;
        }
        return head;
    }

    public void display(ListNode head){
        if(head == null){
            System.out.println("[]");
            return;
        }
        ListNode current = head;
        System.out.print("[");
        while(current.next!=null){
            System.out.print(current.val+", ");
            current=current.next;
        }
        System.out.println(current.val+"]");
    }

    public static void main(String[] args) {
        SwapNodesInPairs nodes = new SwapNodesInPairs();
        ListNode head = new ListNode(1 , 
                        new ListNode ( 2 , 
                        new ListNode(3 , 
                        new ListNode(4, 
                        new ListNode(5)))));
        
        nodes.display(head);

        ListNode swapped = nodes.swapPairs(head);

        nodes.display(swapped);
    }
}
