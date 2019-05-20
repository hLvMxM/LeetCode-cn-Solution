//����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
//
//�����У�һ�ø߶�ƽ�����������Ϊ��
//
//һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��
//
//ʾ�� 1:
//
//���������� [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//���� true ��
//
//ʾ�� 2:
//
//���������� [1,2,2,3,3,null,null,4,4]
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//���� false ��

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package Solution100_199;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
    	if(root==null) return true;
        boolean a = Math.abs(getTreeDepth(root.left)-getTreeDepth(root.right))<=1;
        return a && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getTreeDepth(TreeNode node) {
    	if(node==null) return 0;
    	return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
