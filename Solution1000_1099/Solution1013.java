//给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//
//形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
//
// 
//
//示例 1：
//
//输出：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//示例 2：
//
//输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
//示例 3：
//
//输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
//提示：
//
//3 <= A.length <= 50000
//-10000 <= A[i] <= 10000
package Solution1000_1099;

public class Solution1013 {
	
	public static void main(String[] args) {
		(new Solution1013()).canThreePartsEqualSum(new int[] {6,1,1,13,-1,0,-10,20});
	}
	
	public boolean canThreePartsEqualSum(int[] A) {
        int sum = getSum(A);
        if(sum%3!=0) return false;
        int avg = sum / 3;
        int start = 0;
        int end = A.length - 1;
        int r1 = A[0];
        int r2 = A[end];
        while (start<end) {
        	if(r1==avg && r2==avg) {
        		return true;
        	}
        	if(r1!=avg) {
        		r1+=A[++start];
        	}
        	if(r2!=avg) {
        		r2+=A[--end];
        	}
		}
        return false;
    }

	private int getSum(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}
}
//题解：这道题经过提示后不超时。非常巧妙，获取数组和/3，两头找当值为平均数的情况

//执行用时 : 6 ms, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了24.85% 的用户
//内存消耗 : 51.7 MB, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了53.68% 的用户

