//最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
//
//Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
//Paste (粘贴) : 你可以粘贴你上一次复制的字符。
//给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
//
//示例 1:
//
//输入: 3
//输出: 3
//解释:
//最初, 我们只有一个字符 'A'。
//第 1 步, 我们使用 Copy All 操作。
//第 2 步, 我们使用 Paste 操作来获得 'AA'。
//第 3 步, 我们使用 Paste 操作来获得 'AAA'。
//说明:
//
//n 的取值范围是 [1, 1000] 。

package Solution600_699;

public class Solution650 {
	public int minSteps(int n) {
        int sum = 0;
        int k = 2;
        while(n>1) {
        	if(n%k==0) {
        		sum += k;
        		n /= k;
        		continue;
        	}
        	k++;
        }
        return sum;
    }
}

//题解：大概是难在原理，其实就是求质因数分解后的和

//执行用时 : 1 ms, 在2 Keys Keyboard的Java提交中击败了99.41% 的用户
//内存消耗 : 33.1 MB, 在2 Keys Keyboard的Java提交中击败了72.09% 的用户