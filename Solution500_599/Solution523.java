//给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
//
//示例 1:
//
//输入: [23,2,4,6,7], k = 6
//输出: True
//解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
//示例 2:
//
//输入: [23,2,6,4,7], k = 6
//输出: True
//解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
//说明:
//
//数组的长度不会超过10,000。
//你可以认为所有数字总和在 32 位有符号整数范围内。
package Solution500_599;

public class Solution523 {
	public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
        	int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
                if(k==0){
                    if(sum==0 && j-i>=1)
                        return true;
                    else{
                        continue;
                    }
                }
				if(sum%k==0&&j-i>=1) return true;
			}
		}
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(0%-1);
		int[] nums = new int[] {0};
		(new Solution523()).checkSubarraySum(nums, -1);
	}
}


//执行用时 : 64 ms, 在Continuous Subarray Sum的Java提交中击败了21.85% 的用户
//内存消耗 : 48.6 MB, 在Continuous Subarray Sum的Java提交中击败了42.34% 的用户