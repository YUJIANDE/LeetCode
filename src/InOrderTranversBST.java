import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InOrderTranversBST {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node =root;
		stack.push(node);
		while(stack.isEmpty()) {
			if(node.left != null) {
				stack.push(node.left);
				node = node.left;
			}else {
				result.add(node.val);
				if(node.right != null) {
					stack.push(node.right);
					node = node.right;
				}else {
					node = stack.pop();
					result.add(node.val);
					node = node.right;
				}
			}	
			
		}
		
		return result;
    }
}
