import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InOrderTranversBST {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node =root;

		while(!stack.isEmpty() || node != null) {
			if(node != null) {
				stack.push(node);
				node =node.left;
			}else {
				TreeNode pop = stack.pop();
				result.add(pop.val);
				node = pop.right;
			}
		}
		
		return result;
    }
}
