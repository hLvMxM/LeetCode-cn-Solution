//����������һ����������Ϸ�� ��Ϸ�������£�
//�Ҵ� 1 �� n ѡ��һ�����֡� ����Ҫ����ѡ�����ĸ����֡�
//ÿ����´��ˣ��һ��������������Ǵ��˻���С�ˡ�
//�����һ��Ԥ�ȶ���õĽӿ� guess(int num)�����᷵�� 3 �����ܵĽ����-1��1 �� 0����
//
//-1 : �ҵ����ֱȽ�С
// 1 : �ҵ����ֱȽϴ�
// 0 : ��ϲ����¶��ˣ�
//ʾ�� :
//
//����: n = 10, pick = 6
//���: 6
package Solution300_399;

public class Solution374 {
	public int guessNumber(int n) {
        long min = 0L;
        long max = new Long(n)+1L;
        Long v = (min + max)/2;
        int guess = guess(v.intValue());
        while(guess!=0){
            if(guess>0){
                min = (max+min)/2;
            }else{
                max = (max+min)/2;
            }
            guess = guess(new Long((max + min) / 2).intValue());
        }
        return new Long((max+min)/2).intValue();
    }

	//�ٷ��ṩ�ӿڣ���߲���ʵ��
	private int guess(int intValue) {
		return 0;
	}
}

//���:��Ϊ�򵥣�ע�����

//ִ����ʱ : 2 ms, ��Guess Number Higher or Lower��Java�ύ�л�����97.77% ���û�
//�ڴ����� : 33.2 MB, ��Guess Number Higher or Lower��Java�ύ�л�����67.19% ���û�