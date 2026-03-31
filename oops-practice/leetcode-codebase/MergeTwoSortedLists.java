public class MergeTwoSortedLists {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head=list1;
        if(list1.val>list2.val)     head=list2;
        if(head==list2)     list2=list2.next;
        else    list1=list1.next;
        ListNode curr=head;
        while(list1!=null || list2!=null){
            if(list1==null){
                curr.next=list2;
                break;
            }
            if(list2==null){
                curr.next=list1;
                break;
            }
            if(list1.val<list2.val){
                curr.next=list1;
                list1=list1.next;
            }
            else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        return head;
    }

    ListNode head;

    public MergeTwoSortedLists(int []list) {
        head=new ListNode(0);
        ListNode current = head;
        for(int i: list){
            ListNode newNode = new ListNode(i);
            current.next=newNode;
            current=newNode;
        }
        head=head.next;
    }

    public static void main(String[] args) {

        MergeTwoSortedLists list1 = new MergeTwoSortedLists(new int[]{1,2,4});
        MergeTwoSortedLists list2 = new MergeTwoSortedLists(new int[]{1,3,4});

        ListNode mergedList = mergeTwoLists(list1.head, list2.head);

        ListNode current = mergedList;

        System.out.print("Merged list: ");
        while(current!=null){
            System.out.print(current.val+" ");
            current = current.next;
        }
    }

}
