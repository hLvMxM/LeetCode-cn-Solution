//给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
//
//返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
//
// 
//
//示例 1：
//
//输入：[3,2,4,1]
//输出：[4,2,4,3]
//解释：
//我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
//初始状态 A = [3, 2, 4, 1]
//第一次翻转后 (k=4): A = [1, 4, 2, 3]
//第二次翻转后 (k=2): A = [4, 1, 2, 3]
//第三次翻转后 (k=4): A = [3, 2, 1, 4]
//第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。 
//示例 2：
//
//输入：[1,2,3]
//输出：[]
//解释：
//输入已经排序，因此不需要翻转任何内容。
//请注意，其他可能的答案，如[3，3]，也将被接受。
// 
//
//提示：
//
//1 <= A.length <= 100
//A[i] 是 [1, 2, ..., A.length] 的排列
package Solution900_999;

import java.util.ArrayList;
import java.util.List;

public class Solution969 {
	
	public static void main(String[] args) {
		(new Solution969()).pancakeSort(new int[] {3,5,6,8,4,2,1,7});
	}
	
    public List<Integer> pancakeSort(int[] A) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = A.length-1; i >= 0; i--) {
    		int findmaxposition = findmaxposition(A, i);
    		reverse(A, findmaxposition);
    		if(findmaxposition!=0) result.add(findmaxposition+1);
    		reverse(A, i);
    		if(i!=0) result.add(i+1);
		}
    	return result;
    }
    
    public void reverse(int[] A,int k) {
    	for (int i = 0; i < (k+1)/2; i++) {
			int tmp = A[i];
			A[i] = A[k-i];
			A[k-i] = tmp;
		}
    }
    
    public int findmaxposition(int[] A,int length) {
    	int maxposition = 0;
		for (int i = 0; i <= length; i++) {
			if(A[i]>A[maxposition])
				maxposition = i;
		}
		return maxposition;
	}
}

//题解：找到第N大值，反转到第一个，在反转到最后第N位置。

//执行用时 : 5 ms, 在Pancake Sorting的Java提交中击败了83.98% 的用户
//内存消耗 : 35.5 MB, 在Pancake Sorting的Java提交中击败了90.08% 的用户