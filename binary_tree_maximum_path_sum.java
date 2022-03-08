/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Find the subtree with the greatest sum. It can't be otherwise, because a binary tree with more than 3 nodes, in order to be explored, I need to pass one of the nodes at least twice.

class Solution {
    
    int max_sum = Integer.MIN_VALUE ;
    
    public int maxPathSum(TreeNode root) {
        
        maxsum(root) ;
        
        
        return max_sum ;
        
    }
    
    public int maxsum(TreeNode node) {
        
        if ( node != null && node.left == null && node.right == null ) {
            max_sum = Math.max(max_sum,node.val) ;
            return node.val ;
        }
        
        if ( node != null ) {
            
            
            int leftMax = Math.max(0,maxsum(node.left)) ;
            int rightMax = Math.max(0,maxsum(node.right)) ;
            int curr_sum = node.val + leftMax + rightMax ;
                        
            System.out.println("current sum : "+(curr_sum)) ;
            max_sum = Math.max(max_sum,curr_sum) ;
            System.out.println("max without node values : "+max_sum) ;
            return node.val + Math.max(rightMax,leftMax) ;
            
        }
        
        return 0 ;
        
    }
}
