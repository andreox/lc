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
        
        ListNode result = new ListNode() ;
        result.val = -1 ;
        
        int carry = 0 ;
        while ( l1 != null && l2 != null ) {
            
            int val = l1.val + l2.val + carry ;
            if ( val >= 10 ) {
                val -= 10 ;
                carry = 1 ;
            }
            
            else carry = 0 ;
            l1 = l1.next ;
            l2 = l2.next ;
            
            insertEnd(result,val) ;//add val at the end of the result list
        }
        
        if ( l1 == null ) {
            while ( l2 != null ) {
                int val = l2.val + carry ;
                if ( val >= 10 ) {
                    val -= 10 ;
                    carry = 1 ;
                }
                else carry = 0 ;
                insertEnd(result,val) ;//insert val at end of the list 
                l2 = l2.next ;
            }
        }
        
        else if ( l2 == null ) {
            
            while ( l1 != null ) {
                int val = l1.val + carry ;
                if ( val >= 10 ) {
                    val -= 10 ;
                    carry = 1 ;
                }
                else carry = 0 ;
                insertEnd(result,val) ;//insert val at end of the list
                
                l1 = l1.next ;
            }
        }
        
        if ( carry == 1 ) {
            insertEnd(result,1) ;
        }
        
        return result ;
    }
    
    public void insertEnd(ListNode head,int val) {

		if ( head.val == -1 ) head.val = val ;

		else {
			while ( head.next != null ) {
			    head = head.next ;
			}
            
			head.next = new ListNode(val) ;
		}

	}
}
