//����һ�������ַ��� S������ S = "123456579"�����ǿ��Խ����ֳ�쳲�����ʽ������ [123, 456, 579]��
//
//��ʽ�ϣ�쳲�����ʽ������һ���Ǹ������б� F�������㣺
//
//0 <= F[i] <= 2^31 - 1����Ҳ����˵��ÿ������������ 32 λ�з����������ͣ���
//F.length >= 3��
//�������е�0 <= i < F.length - 2������ F[i] + F[i+1] = F[i+2] ������
//���⣬��ע�⣬���ַ�����ֳ�С��ʱ��ÿ���������һ����Ҫ���㿪ͷ����������������� 0 ����
//
//���ش� S ��ֳ���������쳲�����ʽ�����п飬������ܲ���򷵻� []��
//
//ʾ�� 1��
//
//���룺"123456579"
//�����[123,456,579]
//ʾ�� 2��
//
//����: "11235813"
//���: [1,1,2,3,5,8,13]
//ʾ�� 3��
//
//����: "112358130"
//���: []
//����: ���������޷���ɡ�
//ʾ�� 4��
//
//���룺"0123"
//�����[]
//���ͣ�ÿ��������ֲ������㿪ͷ����� "01"��"2"��"3" ������Ч�𰸡�
//ʾ�� 5��
//
//����: "1101111"
//���: [110, 1, 111]
//����: ��� [11,0,11,11] Ҳͬ�������ܡ�
//��ʾ��
//
//1 <= S.length <= 200
//�ַ��� S ��ֻ�������֡�

package Solution800_900;

import java.util.ArrayList;
import java.util.List;

public class Solution843 {

	public static void main(String[] args) {
		List<Integer> splitIntoFibonacci = 
				(new Solution843()).splitIntoFibonacci("1101111");
		System.out.println(splitIntoFibonacci);
	}
	
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> result = new ArrayList<Integer>();
		int length = S.length();
		int i= 1;
		int j= 1;
		boolean flag = false;
		for (i = 1; i < length; i++) {
			for (j = 1; j < length; j++) {
				if(i+j>=length)
					break;
				try {
					if(isFibonacci(S, i, j)) {
						flag = true;
						break;
					}
				}catch(Exception e) {
					
				}
			}
			if(flag) {
				break;
			}
		}
		if(flag) {
			int sumlength = i+j;
			String firstnum = S.substring(0, i);
			String secondnum = S.substring(i,i+j);
			result.add(Integer.parseInt(firstnum));
			result.add(Integer.parseInt(secondnum));
			while(sumlength!=S.length()) {
				String nextnum = String.valueOf(Integer.parseInt(firstnum)+Integer.parseInt(secondnum));
				sumlength += nextnum.length();
				firstnum = secondnum;
				secondnum = nextnum;
				result.add(Integer.parseInt(nextnum));
			}
		}
		return result;
    }
	
	public boolean isFibonacci(String s,int firstlength,int secondlength) {
		StringBuffer sb = new StringBuffer("");
		int firstnum = Integer.parseInt(s.substring(0, firstlength));
		int secondnum = Integer.parseInt(s.substring(firstlength,firstlength+secondlength));
		int sum = firstlength + secondlength;
		sb.append(firstnum);
		sb.append(secondnum);
		while(sum<s.length()) {
			int nextnum = firstnum + secondnum;
			int nextnumlength = String.valueOf(nextnum).length();
			sb.append(nextnum);
			if(!sb.toString().equals(s.substring(0,sum+nextnumlength))) {
				return false;
			}
			sum += nextnumlength;
			firstnum = secondnum;
			secondnum = nextnum;
		}
		return true;
	}

}


// ִ�н��
//ִ����ʱ : 380 ms, ��Split Array into Fibonacci Sequence��Java�ύ�л�����5.26% ���û�
//�ڴ����� : 47.7 MB, ��Split Array into Fibonacci Sequence��Java�ύ�л�����12.25% ���û�