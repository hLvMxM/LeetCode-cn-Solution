//����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
//
//ʾ��:
//
//����: [0,1,0,3,12]
//���: [1,3,12,0,0]
//˵��:
//
//������ԭ�����ϲ��������ܿ�����������顣
//�������ٲ���������

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

//���˼·��i��ʾ��ǰӦ�÷ŷ������ֵ�λ�á�ͨ��ѭ��������ͨ������������ɡ�

//ִ����ʱ : 0 ms, ��Move Zeroes��Java�ύ�л�����100.00% ���û�
//�ڴ����� : 37.6 MB, ��Move Zeroes��Java�ύ�л�����95.46% ���û�
