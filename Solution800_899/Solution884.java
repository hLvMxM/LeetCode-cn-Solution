//������������ A �� B �� ��������һ���ɿո�ָ��ĵ��ʡ�ÿ�����ʽ���Сд��ĸ��ɡ���
//
//���һ������������һ��������ֻ����һ�Σ�����һ��������ȴû�г��֣���ô������ʾ��ǲ������ġ�
//
//�������в����õ��ʵ��б�
//
//�����԰��κ�˳�򷵻��б�
//
// 
//
//ʾ�� 1��
//
//���룺A = "this apple is sweet", B = "this apple is sour"
//�����["sweet","sour"]
//ʾ�� 2��
//
//���룺A = "apple apple", B = "banana"
//�����["banana"]
// 
//
//��ʾ��
//
//0 <= A.length <= 200
//0 <= B.length <= 200
//A �� B ��ֻ�����ո��Сд��ĸ��
package Solution800_899;

import java.util.HashSet;

public class Solution884 {
	public String[] uncommonFromSentences(String A, String B) {
		HashSet<String> firstSet = new HashSet<String>();
		HashSet<String> moreSet = new HashSet<String>();
		for (String string : (A+" "+B).split(" ")) {
			if (firstSet.contains(string)) {
				moreSet.add(string);
			}
			firstSet.add(string);
		}
		firstSet.removeAll(moreSet);
		String[] result = new String[firstSet.size()];
		firstSet.toArray(result);
		return result;
    }
}

//ִ����ʱ : 7 ms, ��Uncommon Words from Two Sentences��Java�ύ�л�����64.79% ���û�
//�ڴ����� : 34.7 MB, ��Uncommon Words from Two Sentences��Java�ύ�л�����98.10% ���û�