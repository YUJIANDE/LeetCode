import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root != null){
	        if(root.left == null && root.right == null){
	        	result.add(root.val);
	        }else{
	        	if(root.left != null){
	            	result.addAll(this.postorderTraversal(root.left));
	            }
	        	if(root.right != null){
	        		result.addAll(this.postorderTraversal(root.right));
	        	}
	        	result.add(root.val);
	        }
    	}
        return result;
    }
}
