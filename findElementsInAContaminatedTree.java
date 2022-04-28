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
class FindElements {

    TreeNode recoveredRoot ;
    
    public FindElements(TreeNode root) {
        
        recoveredRoot = root ;
        Queue<TreeNode> visitTree = new LinkedList<>() ;
        recoveredRoot.val = 0 ;
        visitTree.add(recoveredRoot) ;
        
        while ( !visitTree.isEmpty() ) {
            
            TreeNode tmp = visitTree.remove() ;
            if ( tmp.left != null ) {
                tmp.left.val = 2*tmp.val +1 ;
                visitTree.add(tmp.left) ;
            }
            
            if ( tmp.right != null ) {
                tmp.right.val = 2*tmp.val+2 ;
                visitTree.add(tmp.right) ;
                
            }
        }
    }
    
    public boolean find(int target) {
        
        Queue<TreeNode> visitTree = new LinkedList<>() ;
        visitTree.add(recoveredRoot) ;
        
        while ( !visitTree.isEmpty() ) {
            
            TreeNode tmp = visitTree.remove() ;
            if ( tmp.val == target ) return true ;
            
            if ( tmp.left != null ) visitTree.add(tmp.left) ;
            if ( tmp.right != null ) visitTree.add(tmp.right) ;
            
        }
        
        return false ;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
