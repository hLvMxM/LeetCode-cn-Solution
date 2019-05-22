//����һ�������ظ�Ԫ�ص��������顣һ���Դ����鹹�������������������£�
//
//�������ĸ��������е����Ԫ�ء�
//��������ͨ�����������ֵ��߲��ֹ����������������
//��������ͨ�����������ֵ�ұ߲��ֹ����������������
//ͨ�����������鹹�������������������������ĸ��ڵ㡣
//
//Example 1:
//
//����: [3,2,1,6,0,5]
//����: ��������������ĸ��ڵ㣺
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
//ע��:
//
//����������Ĵ�С�� [1, 1000] ֮�䡣

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

//��⣺�ݹ�˼��

//ִ����ʱ : 206 ms, ��Maximum Binary Tree��Java�ύ�л�����6.03% ���û�
//�ڴ����� : 69.2 MB, ��Maximum Binary Tree��Java�ύ�л�����5.35% ���û�