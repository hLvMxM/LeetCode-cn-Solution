//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
//
//如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
//
//你允许：
//
//装满任意一个水壶
//清空任意一个水壶
//从一个水壶向另外一个水壶倒水，直到装满或者倒空
//示例 1: (From the famous "Die Hard" example)
//
//输入: x = 3, y = 5, z = 4
//输出: True
//示例 2:
//
//输入: x = 2, y = 6, z = 5
//输出: False

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

//题解：问题可以转换为ax+by=z的问题，首先通过辗转相除法求得最大公约数gcd。根据z是否在范围内再判断z能否被gcd整除。

//执行用时 : 0 ms, 在Water and Jug Problem的Java提交中击败了100.00% 的用户
//内存消耗 : 32.8 MB, 在Water and Jug Problem的Java提交中击败了28.77% 的用户
