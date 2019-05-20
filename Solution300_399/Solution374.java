//我们正在玩一个猜数字游戏。 游戏规则如下：
//我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
//每次你猜错了，我会告诉你这个数字是大了还是小了。
//你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
//
//-1 : 我的数字比较小
// 1 : 我的数字比较大
// 0 : 恭喜！你猜对了！
//示例 :
//
//输入: n = 10, pick = 6
//输出: 6
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

	//官方提供接口，这边不予实现
	private int guess(int intValue) {
		return 0;
	}
}

//题解:较为简单，注意溢出

//执行用时 : 2 ms, 在Guess Number Higher or Lower的Java提交中击败了97.77% 的用户
//内存消耗 : 33.2 MB, 在Guess Number Higher or Lower的Java提交中击败了67.19% 的用户