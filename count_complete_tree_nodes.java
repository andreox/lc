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
class Solution {
    public int countNodes(TreeNode root) {
        
        if ( root == null ) return 0 ;
        
        Queue<TreeNode> bfs_nodes = new LinkedList<TreeNode>() ;
        bfs_nodes.add(root) ;
        int h = findHeight(root) ;
        if ( h == 0 ) return 1 ;
        
        System.out.println(h) ;
        int count_last_nodes = 0 ;
        int count_nodes = 0 ;
        while ( bfs_nodes.peek() != null ) {
            
            TreeNode curr_node = bfs_nodes.remove() ;
            count_nodes++ ;
            if ( logBase2(count_nodes) == (h-1) ) {
                if ( curr_node.left != null ) count_last_nodes++ ;
                if ( curr_node.right != null ) count_last_nodes++ ;
            }
            
            else if ( logBase2(count_nodes) > (h-1)) break ;
            if ( curr_node.left != null ) bfs_nodes.add(curr_node.left) ;
            if ( curr_node.right != null ) bfs_nodes.add(curr_node.right) ;
            
        }
        
        System.out.println(count_last_nodes) ;
        int return_value = (int)Math.pow(2,(h-1)) + count_last_nodes ;
        
        return ((int)(Math.pow(2,(h)))+count_last_nodes-1) ;
        
    }
    
    public int findHeight( TreeNode root ) {
        
        if ( root == null ) return 0 ;
        int count = 0 ;
        while ( root.left != null ) {
            count++ ;
            root = root.left ;
        }
        
        return count ;
    }
    
    public int logBase2( int val ) {
        
        return (int) ( Math.log(val) / Math.log(2) ) ;
        
    }
    
}
