//����һ����Կ�ַ���S��ֻ������ĸ�������Լ� '-'�����ۺţ���N �� '-' ���ַ����ֳ��� N+1 �顣����һ������ K�����¸�ʽ���ַ��������˵�һ���������⣬ÿ������Ҫ���� K ���ַ�����һ����������Ҫ���� 1 ���ַ�����������֮���� '-'�����ۺţ����������ҽ����е�Сд��ĸת��Ϊ��д��ĸ��
//
//�����ǿ��ַ��� S ������ K���������������Ĺ�����и�ʽ����
//
//ʾ�� 1��
//
//���룺S = "5F3Z-2e-9-w", K = 4
//
//�����"5F3Z-2E9W"
//
//���ͣ��ַ��� S ���ֳ����������֣�ÿ���� 4 ���ַ���
//     ע�⣬������������ۺ���Ҫɾ����
//ʾ�� 2��
//
//���룺S = "2-5g-3-J", K = 2
//
//�����"2-5G-3J"
//
//���ͣ��ַ��� S ���ֳ��� 3 �����֣�����ǰ��Ĺ�����������һ���ֵ��ַ��������ڸ��������������ಿ�ֽ�Ϊ 2 ���ַ���
// 
//
//��ʾ:
//
//S �ĳ��Ȳ����� 12,000��K Ϊ������
//S ֻ������ĸ���֣�a-z��A-Z��0-9���Լ����ۺ�'-'
//S �ǿ�
package Solution400_499;

public class Solution482 {
	
	public static void main(String[] args) {
		(new Solution482()).licenseKeyFormatting("5F3Z-2e-9-w", 4);
	}
	
	public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        if(S.length()==0)
        	return "";
        S = S.toUpperCase();
        int length = S.length();
        int first = length % K;
        if(first==0) first = K;
        length = (length-first) / K;
        StringBuffer sb = new StringBuffer();
        String tmp;
		sb.append(S.substring(0,first));
        for (int i = 0; i < length; i++) {
			sb.append("-"+S.substring(first+i*K,first+(i+1)*K));
		}
        return sb.toString();
    }
	
}

//ִ����ʱ : 34 ms, ��License Key Formatting��Java�ύ�л�����65.48% ���û�
//�ڴ����� : 36.8 MB, ��License Key Formatting��Java�ύ�л�����99.36% ���û�