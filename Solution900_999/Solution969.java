//�������� A�����ǿ��Զ�����м����ת������ѡ��һЩ������ k <= A.length��Ȼ��ת A ��ǰ k ��Ԫ�ص�˳������Ҫִ����λ��μ����ת����˳��һ�ν�һ�εؽ��У�����ɶ����� A ������
//
//������ʹ A ����ļ����ת��������Ӧ�� k ֵ���С��κν����������ҷ�ת������ 10 * A.length ��Χ�ڵ���Ч�𰸶������ж�Ϊ��ȷ��
//
// 
//
//ʾ�� 1��
//
//���룺[3,2,4,1]
//�����[4,2,4,3]
//���ͣ�
//����ִ�� 4 �μ����ת��k ֵ�ֱ�Ϊ 4��2��4���� 3��
//��ʼ״̬ A = [3, 2, 4, 1]
//��һ�η�ת�� (k=4): A = [1, 4, 2, 3]
//�ڶ��η�ת�� (k=2): A = [4, 1, 2, 3]
//�����η�ת�� (k=4): A = [3, 2, 1, 4]
//���Ĵη�ת�� (k=3): A = [1, 2, 3, 4]����ʱ��������� 
//ʾ�� 2��
//
//���룺[1,2,3]
//�����[]
//���ͣ�
//�����Ѿ�������˲���Ҫ��ת�κ����ݡ�
//��ע�⣬�������ܵĴ𰸣���[3��3]��Ҳ�������ܡ�
// 
//
//��ʾ��
//
//1 <= A.length <= 100
//A[i] �� [1, 2, ..., A.length] ������
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

//��⣺�ҵ���N��ֵ����ת����һ�����ڷ�ת������Nλ�á�

//ִ����ʱ : 5 ms, ��Pancake Sorting��Java�ύ�л�����83.98% ���û�
//�ڴ����� : 35.5 MB, ��Pancake Sorting��Java�ύ�л�����90.08% ���û�