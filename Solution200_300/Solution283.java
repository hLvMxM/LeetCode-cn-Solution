//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。

package Solution200_300;

public class Solution283 {
	
	public static void main(String[] args) {
		int nums[] = new int[] {1,2,3,0,4,0,0,5,6,0,7,8}; 
		(new Solution283()).moveZeroes(nums);
	}
	
	public void moveZeroes(int[] nums) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
			if(nums[j]!=0) {
				nums[i] = nums[j];
				i++;
			}
		}
        for (int p = i; p < nums.length; p++) {
			nums[p] = 0;
		}
    }
}

//题解思路：i表示当前应该放非零数字的位置。通过循环遍历后通过交换即可完成。

//执行用时 : 0 ms, 在Move Zeroes的Java提交中击败了100.00% 的用户
//内存消耗 : 37.6 MB, 在Move Zeroes的Java提交中击败了95.46% 的用户
