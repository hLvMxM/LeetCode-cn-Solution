//给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
//
//示例 1:
//
//输入: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//输出: 
//    1
//      \
//       2
//示例 2:
//
//输入: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//输出: 
//      3
//     / 
//   2   
//  /
// 1
package Solution600_699;

public class Solution669 {
	public static void main(String[] args) {
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t3.left = t0;
		t3.right = t4;
		t0.right = t2;
		t2.left = t1;
		int L = 1;
		int R = 3;
		(new Solution669()).trimBST(t3, L, R);
	}
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return null;
        if(root.val<L) return trimBST(root.right, L, R);
        else if(root.val>R) return trimBST(root.left, L, R);
        else {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		}
        return root;
    }
}


class TreeNode {
	 int val;
	 TreeNode left = null;
	 TreeNode right = null;
	 TreeNode(int x) { val = x; }
}


//题解：采用递归的方式，判断当前节点是否是在LR之间，然后对左右子节点完成相应操作。

//执行用时 : 1 ms, 在Trim a Binary Search Tree的Java提交中击败了99.42% 的用户
//内存消耗 : 39.7 MB, 在Trim a Binary Search Tree的Java提交中击败了75.00% 的用户