//����һ�������Ǹ����������һ��Ŀ������ k����дһ���������жϸ������Ƿ��������������飬���С����Ϊ 2���ܺ�Ϊ k �ı��������ܺ�Ϊ n*k������ n Ҳ��һ��������
//
//ʾ�� 1:
//
//����: [23,2,4,6,7], k = 6
//���: True
//����: [2,4] ��һ����СΪ 2 �������飬���Һ�Ϊ 6��
//ʾ�� 2:
//
//����: [23,2,6,4,7], k = 6
//���: True
//����: [23,2,6,4,7]�Ǵ�СΪ 5 �������飬���Һ�Ϊ 42��
//˵��:
//
//����ĳ��Ȳ��ᳬ��10,000��
//�������Ϊ���������ܺ��� 32 λ�з���������Χ�ڡ�
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


//ִ����ʱ : 64 ms, ��Continuous Subarray Sum��Java�ύ�л�����21.85% ���û�
//�ڴ����� : 48.6 MB, ��Continuous Subarray Sum��Java�ύ�л�����42.34% ���û�