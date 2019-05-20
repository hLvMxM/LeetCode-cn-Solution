//�����������ֱ�Ϊ x�� �� y�� ��ˮ���Լ����޶��ˮ�����ж��ܷ�ͨ��ʹ��������ˮ�����Ӷ����Եõ�ǡ�� z�� ��ˮ��
//
//������ԣ������������ˮ���е�һ��������ʢ��ȡ�õ� z�� ˮ��
//
//������
//
//װ������һ��ˮ��
//�������һ��ˮ��
//��һ��ˮ��������һ��ˮ����ˮ��ֱ��װ�����ߵ���
//ʾ�� 1: (From the famous "Die Hard" example)
//
//����: x = 3, y = 5, z = 4
//���: True
//ʾ�� 2:
//
//����: x = 2, y = 6, z = 5
//���: False

package Solution300_399;

public class Solution365 {
	public static void main(String[] args) {
		boolean gcd = (new Solution365()).canMeasureWater(4, 3, 5);
		System.out.println(gcd);
	}
	
	public boolean canMeasureWater(int x, int y, int z) {
        return z==0 || (z<=x+y && z % gcd(x, y)==0);
    }
	
	
	public int gcd(int a,int b) {
		if(a<b) {
			return gcd(b, a);
		}
		int n1 = a;
		int n2 = b;
		while(n2!=0) {
			int r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}
}

//��⣺�������ת��Ϊax+by=z�����⣬����ͨ��շת�����������Լ��gcd������z�Ƿ��ڷ�Χ�����ж�z�ܷ�gcd������

//ִ����ʱ : 0 ms, ��Water and Jug Problem��Java�ύ�л�����100.00% ���û�
//�ڴ����� : 32.8 MB, ��Water and Jug Problem��Java�ύ�л�����28.77% ���û�
