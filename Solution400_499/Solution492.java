//��Ϊһλweb�����ߣ� ��������ȥ�滮һ��ҳ��ĳߴ��Ǻ���Ҫ�ġ� �ָ���һ������ľ���ҳ�������������������һ������Ϊ L �Ϳ��Ϊ W ����������Ҫ��ľ��ε�ҳ�档Ҫ��
//
//1. ����Ƶľ���ҳ�������ڸ�����Ŀ�������
//
//2. ��� W ��Ӧ���ڳ��� L������֮��Ҫ�� L >= W ��
//
//3. ���� L �Ϳ�� W ֮��Ĳ��Ӧ��������С��
//����Ҫ��˳���������Ƶ�ҳ��ĳ��� L �Ϳ�� W��
//
//ʾ����
//
//����: 4
//���: [2, 2]
//����: Ŀ������� 4�� ���п��ܵĹ��췽���� [1,4], [2,2], [4,1]��
//���Ǹ���Ҫ��2��[1,4] ������Ҫ��; ����Ҫ��3��[2,2] �� [4,1] ���ܷ���Ҫ��. ����������� L Ϊ 2�� ��� W Ϊ 2��
//˵��:
//
//��������������� 10,000,000 ��Ϊ��������
//����Ƶ�ҳ��ĳ��ȺͿ�ȱ��붼����������

package Solution400_499;

public class Solution492 {
	public static void main(String[] args) {
		int[] constructRectangle = (new Solution492()).constructRectangle(14);
	}
	public int[] constructRectangle(int area) {
		double sqrt = Math.sqrt(area);
		Long valueOf = Math.round(sqrt);
		while(valueOf>0) {
			if(isInteger(area*1.0/valueOf)) {
				break;
			}
			else {
				valueOf--;
			}
		}
		int v1 = Integer.valueOf(Long.toString(valueOf));
		int v2 = Integer.valueOf(Long.toString(Math.round(area*1.0/valueOf)));
		return new int[]{v2,v1};
    }
	
	public boolean isInteger(double a) {
		return a==Math.round(a);
	}
}
//˼·����ƽ����������Ѱ�ҷ�������������

//ִ����ʱ : 7 ms, ��Construct the Rectangle��Java�ύ�л�����40.00% ���û�
//�ڴ����� : 34.7 MB, ��Construct the Rectangle��Java�ύ�л�����47.67% ���û�