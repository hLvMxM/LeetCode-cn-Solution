//����һ��û���ظ�Ԫ�ص����顣
//
//ʾ��:
//
//// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
//solution.shuffle();
//
//// �������鵽���ĳ�ʼ״̬[1,2,3]��
//solution.reset();
//
//// �����������[1,2,3]���Һ�Ľ����
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

//��⣺���

//ִ����ʱ : 397 ms, ��Shuffle an Array��Java�ύ�л�����5.04% ���û�
//�ڴ����� : 81.8 MB, ��Shuffle an Array��Java�ύ�л�����58.55% ���û�