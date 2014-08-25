import java.util.ArrayList;
import java.util.List;
/*
 * https://oj.leetcode.com/problems/path-sum-ii/
 */
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> left = null, right = null, result = new ArrayList<List<Integer>>();

		if (root != null) {
			
			if (root.left != null) {
				left = pathSum(root.left, sum - root.val);
				if (left.size() > 0) {
					for (int i = 0; i < left.size(); i++) {
						left.get(i).add(0, root.val);
					}
					result.addAll(left);
				}
			}
			
			if (root.right != null) {
				right = pathSum(root.right, sum - root.val);
				if (right.size() > 0) {
					for (int i = 0; i < right.size(); i++) {
						right.get(i).add(0, root.val);
					}
					result.addAll(right);
				}
			}

			if (root.left == null && root.right == null) {
				if (sum - root.val == 0) {
					List<Integer> list = new ArrayList<Integer>();
					result.add(list);
					list.add(0, root.val);
				}

			}

		}

		return result;

	}

}