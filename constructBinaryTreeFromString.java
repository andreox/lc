class Solution {
    
    int i = 0 ;
    public TreeNode str2tree(String s) {
        
        if ( s.length() == 0 ) return null ;
        else if ( s.length() <= 2 ) return new TreeNode(readChar(s)) ;
        TreeNode root = new TreeNode(readChar(s)) ;
        Stack<TreeNode> nodesStack = new Stack<TreeNode>() ;
        nodesStack.add(root) ;
        
        while ( i < s.length() ) {
            
            if ( s.charAt(i) != '(' && s.charAt(i) != ')') 
                nodesStack.add(new TreeNode(readChar(s))) ;
            else if ( s.charAt(i) == ')') {
                TreeNode node = nodesStack.pop() ;
                TreeNode currNode = nodesStack.peek() ;
                if ( currNode.left == null ) currNode.left = node ;
                else currNode.right = node ;
                i++ ;
            }
            else i++ ;
        }
        
        return root ;
    }
    
    int readChar( String s) {
        
        int startIndex = i ;
        
        while ( i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
            i++ ;
        }
        
        return Integer.parseInt(s.substring(startIndex,i)) ;
        
    }
}
