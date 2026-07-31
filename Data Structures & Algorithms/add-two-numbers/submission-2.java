/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode current=dummy;

        int carry= 0;


        while(l1 !=null || l2!=null){
            
            int total= 0 + carry;
            
            if(l1 != null){
                total += l1.val;
                l1=l1.next;
            }

             if(l2 != null){
                total += l2.val;
                l2=l2.next;
            }

         carry= total / 10;
         total = total % 10;
        
         
        dummy.next = new ListNode(total);
        dummy=dummy.next;

        }

        if(carry==1) dummy.next=new ListNode(1) ;

        return current.next;
    }
}
