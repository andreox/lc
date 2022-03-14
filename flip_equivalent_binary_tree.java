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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if ((root1 != null && root2 == null ) || (root1 == null && root2 != null) ) return false ;
        if ( root1 == null && root2 == null ) return true ;
        HashMap<Integer,Pair<Integer,Integer>> subtrees1 = findSubtrees(root1) ;
        HashMap<Integer,Pair<Integer,Integer>> subtrees2 = findSubtrees(root2) ;
        
        for ( Integer i : subtrees1.keySet()) {
            System.out.println(i+" "+subtrees1.get(i).getKey()+" "+subtrees1.get(i).getValue()) ;
        }
        
        for ( Integer i : subtrees2.keySet()) {
            System.out.println(i+" "+subtrees2.get(i).getKey()+" "+subtrees2.get(i).getValue()) ;
        }
        
        boolean flip_equiv = true ;
        
        for ( Integer i : subtrees1.keySet() ) {
            if ( subtrees2.get(i) != null ) {
                int max_child_1 = Math.max(subtrees1.get(i).getKey(),subtrees1.get(i).getValue()) ;
                int max_child_2 = Math.max(subtrees2.get(i).getKey(), subtrees2.get(i).getValue()) ;
                int min_child_1 = Math.min(subtrees1.get(i).getKey(),subtrees1.get(i).getValue()) ;
                int min_child_2 = Math.min(subtrees2.get(i).getKey(),subtrees2.get(i).getValue()) ;
                
                if ( max_child_1 != max_child_2 || min_child_1 != min_child_2 ) flip_equiv = false ;
                
            }
            else flip_equiv = false ;
        }
        
        return flip_equiv ;
    }
    
    public HashMap<Integer,Pair<Integer,Integer>> findSubtrees(TreeNode root) { //perform bfs
        
        Queue<TreeNode> visit_queue = new LinkedList<>() ;
        HashMap<Integer,Pair<Integer,Integer>> subtrees =  new HashMap<Integer,Pair<Integer,Integer>>() ;
        
        visit_queue.add(root) ;
        
        while ( visit_queue.peek() != null ) {
            TreeNode node = visit_queue.remove() ;
            TreeNode left = node.left ;
            TreeNode right = node.right ;
            int left_val = -1 ;
            int right_val = -1 ;
            int root_val = node.val ;
            
            if ( left != null ) {
                left_val = left.val ;
                visit_queue.add(left) ;
            }
            if ( right != null ) {
                right_val = right.val ;
                visit_queue.add(right) ;
            }
            
            if ( left != null || right != null ) subtrees.put( root_val, new Pair<Integer,Integer>(left_val,right_val)) ;
              
        }
        
        return subtrees ;
    }
}
