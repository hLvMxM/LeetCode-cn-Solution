//����Ҫ�ڶ�������ÿһ�����ҵ�����ֵ��
//
//ʾ����
//
//����: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//���: [1, 3, 9]

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

//ִ����ʱ : 7 ms, ��Find Largest Value in Each Tree Row��Java�ύ�л�����55.56% ���û�
//�ڴ����� : 39.1 MB, ��Find Largest Value in Each Tree Row��Java�ύ�л�����87.16% ���û�


