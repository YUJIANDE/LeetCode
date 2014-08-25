/**
 * https://oj.leetcode.com/problems/path-sum/
 * @author jiandeyu
 *
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        
        if(root != null) {
		    if(root.left == null && root.right == null) {
		    	return sum - root.val == 0;
		    }
		    if(!result && root.left != null) {
		    	result = hasPathSum(root.left, sum - root.val);
		    }
			if (!result && root.right != null) {
				result = hasPathSum(root.right, sum - root.val);
			}
        
        }
        return result;
    	
    	
    }
    
}