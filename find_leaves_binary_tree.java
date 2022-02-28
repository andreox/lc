class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashSet<TreeNode> set = new HashSet<TreeNode>();
		//Exit condition is when the root has been included as a leaf in the last iteration
        while(!set.contains(root)){
            List<Integer> ls = new ArrayList<>();
            dfs(root, set, ls);
            res.add(ls);
        }
        return res;
    }
    
    public void dfs(TreeNode root, HashSet<TreeNode> set, List<Integer> ls){
		//this condition is explained below
        if((root.left == null || set.contains(root.left)) && (root.right == null || set.contains(root.right)) && !set.contains(root)) {
            ls.add(root.val);
            set.add(root);
        }
        if(root.left != null) dfs(root.left, set, ls);
        if(root.right != null) dfs(root.right, set, ls);
    }
}
