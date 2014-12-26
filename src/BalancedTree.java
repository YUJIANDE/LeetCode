
public class BalancedTree {
	public boolean isBalanced(TreeNode root) {

		if(root == null) {
			return true;
		}
		int left = depth(root.left),
				right = depth(root.right); 
		
		return  left >= 0 && 
				 right >= 0 &&
				Math.abs(left - right) <=1;
	}
	
	
	private int depth(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int left = depth(root.left),
					right = depth(root.right);
			if(left == -1 || right == -1 || Math.abs(left-right) > 1) {
				return -1;
			}else {
				return 1 + Math.max(left, right);
			}
		}
		
	}
}
