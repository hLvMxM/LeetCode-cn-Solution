//������������ʻ��Ŀ�ĵأ���Ŀ�ĵ�λ�ڳ���λ�ö��� target Ӣ�ﴦ��
//
//��;�м���վ��ÿ�� station[i] ����һ������վ����λ�ڳ���λ�ö��� station[i][0] Ӣ�ﴦ�������� station[i][1] �����͡�
//
//����������������������޵ģ���������� startFuel ��ȼ�ϡ���ÿ��ʻ 1 Ӣ��ͻ��õ� 1 �����͡�
//
//�������������վʱ��������ͣ�������ͣ����������ʹӼ���վת�Ƶ������С�
//
//Ϊ�˵���Ŀ�ĵأ���������Ҫ����ͼ��ʹ����Ƕ��٣�����޷�����Ŀ�ĵأ��򷵻� -1 ��
//
//ע�⣺��������������վʱʣ��ȼ��Ϊ 0������Ȼ������������͡������������Ŀ�ĵ�ʱʣ��ȼ��Ϊ 0����Ȼ��Ϊ���Ѿ�����Ŀ�ĵء�
//
// 
//
//ʾ�� 1��
//
//���룺target = 1, startFuel = 1, stations = []
//�����0
//���ͣ����ǿ����ڲ����͵�����µ���Ŀ�ĵء�
//ʾ�� 2��
//
//���룺target = 100, startFuel = 1, stations = [[10,100]]
//�����-1
//���ͣ������޷��ִ�Ŀ�ĵأ������޷������һ������վ��
//ʾ�� 3��
//
//���룺target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//�����2
//���ͣ�
//���ǳ���ʱ�� 10 ��ȼ�ϡ�
//���ǿ������������ 10 Ӣ�ﴦ�ļ���վ������ 10 ��ȼ�ϡ������ʹ� 0 ���ӵ� 60 ����
//Ȼ�����Ǵ� 10 Ӣ�ﴦ�ļ���վ���� 60 Ӣ�ﴦ�ļ���վ������ 50 ��ȼ�ϣ���
//�������ʹ� 10 ���ӵ� 50 ����Ȼ�����ǿ����ִ�Ŀ�ĵء�
//������;��1��������վͣ�������Է��� 2 ��
// 
//
//��ʾ��
//
//1 <= target, startFuel, stations[i][1] <= 10^9
//0 <= stations.length <= 500
//0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target

package Solution800_899;

import java.util.Arrays;

public class Solution871 {
	
	public static void main(String[] args) {
		int[][] stations = new int[][] {
			{25,30},
		};
		(new Solution871()).minRefuelStops(100, 50, stations);
	}
	
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] usedstations = new int[stations.length];
        int[] search = new int[stations.length];
        Arrays.fill(usedstations, 0);
        Arrays.fill(search, 0);
        int Fuel = startFuel;
        int count = 0;
        while (Fuel<target) {
        	for (int i = 0; i < stations.length; i++) { //�ҵ����Եִ�ļ���վ
        		if(stations[i][0]<=Fuel)
        			search[i] = 1;
        	}
        	int maxposition = -1;
        	for (int i = 0; i < search.length; i++) {
        		if(search[i]==0) break;
				if(maxposition==-1 && usedstations[i]==0) { 
					maxposition = i; 
				}
				else if(usedstations[i]==0){
					if(stations[maxposition][1]<stations[i][1])
						maxposition = i;
				}
			}
        	if(maxposition==-1) return -1;
        	usedstations[maxposition] = 1;
        	count++;
        	Fuel += stations[maxposition][1];
		}
        return count;
    }
}


//ִ����ʱ : 12 ms, ��Minimum Number of Refueling Stops��Java�ύ�л�����52.83% ���û�
//�ڴ����� : 48.5 MB, ��Minimum Number of Refueling Stops��Java�ύ�л�����15.25% ���û�