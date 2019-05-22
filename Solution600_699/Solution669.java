//����һ��������������ͬʱ������С�߽�L �����߽� R��ͨ���޼�������������ʹ�����нڵ��ֵ��[L, R]�� (R>=L) ���������Ҫ�ı����ĸ��ڵ㣬���Խ��Ӧ�������޼��õĶ������������µĸ��ڵ㡣
//
//ʾ�� 1:
//
//����: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//���: 
//    1
//      \
//       2
//ʾ�� 2:
//
//����: 
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
//���: 
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


//��⣺���õݹ�ķ�ʽ���жϵ�ǰ�ڵ��Ƿ�����LR֮�䣬Ȼ��������ӽڵ������Ӧ������

//ִ����ʱ : 1 ms, ��Trim a Binary Search Tree��Java�ύ�л�����99.42% ���û�
//�ڴ����� : 39.7 MB, ��Trim a Binary Search Tree��Java�ύ�л�����75.00% ���û�