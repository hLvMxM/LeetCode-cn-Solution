//作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
//
//1. 你设计的矩形页面必须等于给定的目标面积。
//
//2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
//
//3. 长度 L 和宽度 W 之间的差距应当尽可能小。
//你需要按顺序输出你设计的页面的长度 L 和宽度 W。
//
//示例：
//
//输入: 4
//输出: [2, 2]
//解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
//但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
//说明:
//
//给定的面积不大于 10,000,000 且为正整数。
//你设计的页面的长度和宽度必须都是正整数。

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
//思路，求平方根后向下寻找符合条件的数字

//执行用时 : 7 ms, 在Construct the Rectangle的Java提交中击败了40.00% 的用户
//内存消耗 : 34.7 MB, 在Construct the Rectangle的Java提交中击败了47.67% 的用户