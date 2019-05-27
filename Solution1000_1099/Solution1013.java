//����һ���������� A��ֻ�����ǿ��Խ��仮��Ϊ��������ȵķǿղ���ʱ�ŷ��� true�����򷵻� false��
//
//��ʽ�ϣ�������ǿ����ҳ����� i+1 < j ������ (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) �Ϳ��Խ��������ȷ֡�
//
// 
//
//ʾ�� 1��
//
//�����[0,2,1,-6,6,-7,9,1,2,0,1]
//�����true
//���ͣ�0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//ʾ�� 2��
//
//���룺[0,2,1,-6,6,7,9,-1,2,0,1]
//�����false
//ʾ�� 3��
//
//���룺[3,3,6,5,-2,2,5,1,-9,4]
//�����true
//���ͣ�3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
//��ʾ��
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


//ִ����ʱ : 6 ms, ��Partition Array Into Three Parts With Equal Sum��Java�ύ�л�����24.85% ���û�
//�ڴ����� : 51.7 MB, ��Partition Array Into Three Parts With Equal Sum��Java�ύ�л�����53.68% ���û�

