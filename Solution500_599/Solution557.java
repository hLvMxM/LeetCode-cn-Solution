//����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
//
//ʾ�� 1:
//
//����: "Let's take LeetCode contest"
//���: "s'teL ekat edoCteeL tsetnoc" 
//ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�

package Solution500_599;

public class Solution557 {
	public static void main(String[] args) {
		String reverseWords = (new Solution557()).reverseWords("Let's");
		System.out.println(reverseWords);
	}
	
	public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String string : split) {
			StringBuffer reverse = new StringBuffer(string).reverse();
			sb.append(reverse+" ");
		}
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}

//ִ����ʱ : 17 ms, ��Reverse Words in a String III��Java�ύ�л�����58.01% ���û�
//�ڴ����� : 48.5 MB, ��Reverse Words in a String III��Java�ύ�л�����53.71% ���û�