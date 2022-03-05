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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if ( head.next == null ) return null ;
        
        ListNode h = head ;
        HashMap<Integer, Pair<ListNode,ListNode>> save_with_predec = new HashMap<>() ;
        int dimension = 1 ;
        while ( h.next != null ) {
            
            Pair<ListNode,ListNode> curr_pair = new Pair(h, h.next) ;
            save_with_predec.put(dimension++, curr_pair) ;
            h = h.next ;
            
        }
        
        if ( dimension == n ) head = head.next ;
        
        else {
            int index = dimension - n  ;
            Pair<ListNode,ListNode> to_remove = save_with_predec.get(index) ;
            to_remove.getKey().next = to_remove.getValue().next ;
        }
        
        return head ;
        
    }
}
