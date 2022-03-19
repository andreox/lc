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
    public TreeNode invertTree(TreeNode root) {
        
        Queue<TreeNode> visited_nodes = new LinkedList<TreeNode>() ;
        
        visited_nodes.add(root) ;
        
        while ( !visited_nodes.isEmpty() ) {
            
            TreeNode curr_node = visited_nodes.poll() ;
            if ( curr_node != null /*&& curr_node.left != null && curr_node.right != null*/ ) { //This comment is put in order to allow treatment of null values
                TreeNode tmp = curr_node.left ;
                curr_node.left = curr_node.right ;
                curr_node.right = tmp ;
            }
            
            if ( curr_node != null && curr_node.left != null ) visited_nodes.add(curr_node.left) ;
            if ( curr_node != null && curr_node.right != null ) visited_nodes.add(curr_node.right) ;
            
        }
        
        return root ;
    }
}
