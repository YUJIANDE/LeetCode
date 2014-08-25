import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * not a recursive solution, but 'iterative'
 * @author jiandeyu
 *
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root != null){
    		Stack<TreeNode> stack = new Stack<TreeNode>();
    	    stack.push(root);
    		while(!stack.isEmpty()){
    			TreeNode parent = stack.pop();
    			if(parent.right!=null){
    		        stack.push(parent.right);
    		    }
    		    if(parent.left != null){
    			    stack.push(parent.left);
    		    }
    			result.add(parent.val);
    		}
    		
    	}
        return result;
    }
}