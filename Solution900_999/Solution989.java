//���ڷǸ����� X ���ԣ�X ��������ʽ��ÿλ���ְ������ҵ�˳���γɵ����顣���磬��� X = 1231����ô��������ʽΪ [1,2,3,1]��
//
//�����Ǹ����� X ��������ʽ A���������� X+K ��������ʽ��
//
// 
//
//ʾ�� 1��
//
//���룺A = [1,2,0,0], K = 34
//�����[1,2,3,4]
//���ͣ�1200 + 34 = 1234
//���� 2��
//
//���룺A = [2,7,4], K = 181
//�����[4,5,5]
//���ͣ�274 + 181 = 455
//ʾ�� 3��
//
//���룺A = [2,1,5], K = 806
//�����[1,0,2,1]
//���ͣ�215 + 806 = 1021
//ʾ�� 4��
//
//���룺A = [9,9,9,9,9,9,9,9,9,9], K = 1
//�����[1,0,0,0,0,0,0,0,0,0,0]
//���ͣ�9999999999 + 1 = 10000000000
// 
//
//��ʾ��
//
//1 <= A.length <= 10000
//0 <= A[i] <= 9
//0 <= K <= 10000
//��� A.length > 1����ô A[0] != 0
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

//ִ����ʱ : 17 ms, ��Add to Array-Form of Integer��Java�ύ�л�����67.80% ���û�
//�ڴ����� : 52.1 MB, ��Add to Array-Form of Integer��Java�ύ�л�����29.87% ���û�
