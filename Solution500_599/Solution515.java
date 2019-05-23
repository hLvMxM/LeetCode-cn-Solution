//您需要在二叉树的每一行中找到最大的值。
//
//示例：
//
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package Solution500_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution515 {
	public static void main(String[] args) {
		(new Solution515()).largestValues(null);
	}
	
	public HashMap<Integer,Integer> maxMap = new HashMap<Integer,Integer>();
	public int height = -1;
	public List<Integer> largestValues(TreeNode root) {
        findLargestValue(root, 0);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= height; i++) {
			result.add(maxMap.get(i));
		}
        return result;
    }
	public void findLargestValue(TreeNode root,int height) {
		if(root == null) return;
		if(this.height<height) this.height = height;
		if(maxMap.containsKey(height)) {
			Integer val = maxMap.get(height);
			if(val<root.val) maxMap.put(height, root.val);
		}else {
			maxMap.put(height, root.val);
		}
		findLargestValue(root.left, height+1);
		findLargestValue(root.right, height+1);
		return;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//执行用时 : 7 ms, 在Find Largest Value in Each Tree Row的Java提交中击败了55.56% 的用户
//内存消耗 : 39.1 MB, 在Find Largest Value in Each Tree Row的Java提交中击败了87.16% 的用户


