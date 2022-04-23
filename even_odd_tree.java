class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>() ;
         
        treeNodes.add(root) ;
        
        if ( root.val % 2 == 0 ) return false ;
        
        int countNodes = 0 ;
        int level = 1 ;
        ArrayList<Integer> nodeList = new ArrayList<Integer>() ;
        
        while ( !treeNodes.isEmpty() ) {
            
            TreeNode node = treeNodes.remove() ;
            
            if ( node.left != null ) {
                nodeList.add(node.left.val) ;
                treeNodes.add(node.left) ;
                System.out.print(node.left.val+" ") ;
            }
                
            if ( node.right != null ) {
                nodeList.add(node.right.val) ;
                treeNodes.add(node.right) ;
                System.out.print(node.right.val+" ") ;
            }
                
            countNodes += 2 ;
                     
            if ( countNodes == Math.pow(2,level) ) {
                
                System.out.println() ;
                if ( level % 2 == 0 && !isStrictlyIncreasing(nodeList) ) return false ;
                else if ( level % 2 != 0 && !isStrictlyDecreasing(nodeList)) return false ;
                
                nodeList.clear() ;
                level++ ;
                countNodes = 0 ;
                
            }
        }
        
        return true ;
        
    }
    
    public boolean isStrictlyIncreasing( ArrayList<Integer> list ) {
        
        for ( int i = 0 ; i < list.size() ; i++ ) {
            if ( i < list.size()-1 && list.get(i) >= list.get(i+1) ) return false ;
            if ( list.get(i) % 2 == 0 ) return false ;
            
        }
        return true ;
        
    }
    
    public boolean isStrictlyDecreasing( ArrayList<Integer> list ) {
        
        for ( int i = 0 ; i < list.size() ; i++ ) {
            
            if ( i < list.size()-1 && list.get(i) <= list.get(i+1) ) return false ;
            if ( list.get(i) % 2 != 0) return false ;
            
        }
        return true ;
        
    }
}
