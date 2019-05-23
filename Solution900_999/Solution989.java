//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
//给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
// 
//
//示例 1：
//
//输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
//解释 2：
//
//输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
//示例 3：
//
//输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
//示例 4：
//
//输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
//提示：
//
//1 <= A.length <= 10000
//0 <= A[i] <= 9
//0 <= K <= 10000
//如果 A.length > 1，那么 A[0] != 0
package Solution900_999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution989 {
	
	public static void main(String[] args) {
		(new Solution989()).addToArrayForm(new int[] {1,2,0,0}, 34);
	}
	
    public List<Integer> addToArrayForm(int[] A, int K) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int A_length = A.length - 1;
    	int fromlastvalue = 0;
    	while (true) {
			int value = (K % 10) + (A_length>=0?A[A_length]:0) + fromlastvalue;
			fromlastvalue = value / 10;
			result.add(value % 10);
    		A_length--;
    		K = K / 10;
    		if(A_length<0&&K==0) break;
		}
    	if(fromlastvalue!=0) result.add(fromlastvalue);
    	Collections.reverse(result);
    	return result;
    }
}

//执行用时 : 17 ms, 在Add to Array-Form of Integer的Java提交中击败了67.80% 的用户
//内存消耗 : 52.1 MB, 在Add to Array-Form of Integer的Java提交中击败了29.87% 的用户
