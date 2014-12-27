/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBST {
	private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
    	prev = null;
    	return validate(root);
    }


    //in order tranverse, so the previous visited node always has a smaller value.
    public boolean validate(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	if(!validate(root.left)) {
    		return false;
    	}
    	if(prev != null && root.val <= prev.val) {
    		return false;
    	}
    	prev = root;
    	return validate(root.right);
    }
    
    
}