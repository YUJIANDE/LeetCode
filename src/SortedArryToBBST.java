
public class SortedArryToBBST {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length-1);
	}

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		
		if(start > end){
			return null;
		}

		
		int m = (start + end)/2;
		TreeNode result = new TreeNode(num[m]);
		result.left = sortedArrayToBST(num, start, m-1);
		result.right = sortedArrayToBST(num, m+1, end);

		
		return result;
	}	
}
