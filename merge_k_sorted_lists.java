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
    
    ListNode sol = new ListNode(0) ;
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k = lists.length ;
        ListNode head = null ;
        boolean tr = true ; //tr checks if all lists are empty
        
        while ( tr ) {
            
            tr = false ;
            int min = Integer.MAX_VALUE ;
            int min_index = -1 ;
            
            for ( int i = 0 ; i < k ; i++ ) {
                if ( lists[i] != null && lists[i].val < min ) {
                    min = lists[i].val ;
                    tr = true ;
                    min_index = i ;
                }
            }
            
            if ( min != Integer.MAX_VALUE ) {
                ListNode min_node = new ListNode(min) ;
                head = insertHead(head,min_node) ;
            }
            
            if ( min_index != -1 ) lists[min_index] = lists[min_index].next ;
            
        }
        
        printReversed(head) ;
        return sol.next ;
    }
    
    public ListNode insertHead(ListNode head, ListNode node) {
        
        if ( head != null ) {
            node.next = head ;
            return node ;
        }
        
        return node ;
        
    }
    
    public void insertEnd( ListNode head, int val ) {
        
        
            ListNode tmp = head ;
            while ( tmp.next != null ) tmp = tmp.next ;
            ListNode n = new ListNode(val) ;
            tmp.next = n ;
        
        
    }
    
    public void printReversed(ListNode head) {
        if ( head != null ) {
            printReversed(head.next) ;
            System.out.println(head.val) ; //substitute this with add to LinkedList
            insertEnd(this.sol, head.val) ;
        }
    }
}
