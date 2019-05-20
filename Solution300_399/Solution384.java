//打乱一个没有重复元素的数组。
//
//示例:
//
//// 以数字集合 1, 2 和 3 初始化数组。
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
//solution.shuffle();
//
//// 重设数组到它的初始状态[1,2,3]。
//solution.reset();
//
//// 随机返回数组[1,2,3]打乱后的结果。
//solution.shuffle();

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

package Solution300_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Solution384 {
	private int[] nums;
	
	public static void main(String[] args) {
		
	}
	
	public Solution384(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] newnums = Arrays.copyOf(nums,nums.length);
    	List<Integer> list = new ArrayList<Integer>(nums.length);
    	for (int i = 0; i < newnums.length; i++) {
			list.add(nums[i]);
		}
    	Collections.shuffle(list, new Random(System.currentTimeMillis()));
    	for (int i = 0; i < newnums.length; i++) {
			newnums[i] = list.get(i);
		}
    	return newnums;
    }
}

//题解：随机

//执行用时 : 397 ms, 在Shuffle an Array的Java提交中击败了5.04% 的用户
//内存消耗 : 81.8 MB, 在Shuffle an Array的Java提交中击败了58.55% 的用户