//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//二叉树的根是数组中的最大元素。
//左子树是通过数组中最大值左边部分构造出的最大二叉树。
//右子树是通过数组中最大值右边部分构造出的最大二叉树。
//通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//Example 1:
//
//输入: [3,2,1,6,0,5]
//输入: 返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
//注意:
//
//给定的数组的大小在 [1, 1000] 之间。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package Solution600_699;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution654 {
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,1,6,0,5};
		(new Solution654()).constructMaximumBinaryTree(nums);
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Integer sortnums[] = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
			sortnums[i] = nums[i];
		}
		TreeNode findMax = findMax(sortnums, 0, nums.length);
		return findMax;
	}
	
	public TreeNode findMax(Integer[] nums,int start,int end) {
		if(start>=end) return null;
		Integer[] sortnums = Arrays.copyOfRange(nums, start, end);
		Arrays.sort(sortnums);
		int maxpoint = Collections.max(Arrays.asList(sortnums));
		int maxposition = map.get(maxpoint);
		TreeNode node = new TreeNode(maxpoint);
		node.left = findMax(nums, start, maxposition);
		node.right = findMax(nums, maxposition+1, end);
		return node;
	}
}

//题解：递归思想

//执行用时 : 206 ms, 在Maximum Binary Tree的Java提交中击败了6.03% 的用户
//内存消耗 : 69.2 MB, 在Maximum Binary Tree的Java提交中击败了5.35% 的用户