/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    int index_deserialize ;
    StringBuilder string_serialize ;

    public void recursive_serialize(TreeNode node) {
        if ( node == null ) {
            string_serialize.append("null,") ;
            return ;
        }
        
        string_serialize.append(node.val) ;
        string_serialize.append(",") ;
        recursive_serialize(node.left) ;
        recursive_serialize(node.right) ;       
        
    }
    
    public String serialize(TreeNode root) {
        
        string_serialize = new StringBuilder() ;
        recursive_serialize(root) ;
        return string_serialize.toString() ;
        
    }
    public TreeNode recursive_deserialize(String data) {
        
        String curr_node_val = parseString(data) ;
        if ( curr_node_val.equals("null") ) return null ;
        
        TreeNode node = new TreeNode(Integer.parseInt(curr_node_val)) ;
        node.left = recursive_deserialize(data) ;
        node.right = recursive_deserialize(data) ;
        
        return node ;
        
    }
    
    public String parseString( String tree) {
        
        StringBuilder node_val = new StringBuilder() ;
        
        while ( tree.charAt(index_deserialize) != ',') {
            node_val.append(tree.charAt(index_deserialize++)) ;
        }
        
        index_deserialize += 1 ;
        
        return node_val.toString() ;
        
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if ( data.length() == 0 ) return null ;
        index_deserialize = 0 ;
        TreeNode root = recursive_deserialize(data) ;
        return root ;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
