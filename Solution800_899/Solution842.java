//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
//形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//
//0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
//F.length >= 3；
//对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//
//返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
//
//示例 1：
//
//输入："123456579"
//输出：[123,456,579]
//示例 2：
//
//输入: "11235813"
//输出: [1,1,2,3,5,8,13]
//示例 3：
//
//输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
//示例 4：
//
//输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
//示例 5：
//
//输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
//提示：
//
//1 <= S.length <= 200
//字符串 S 中只含有数字。

package Solution800_900;

import java.util.ArrayList;
import java.util.List;

public class Solution842 {

	public static void main(String[] args) {
		List<Integer> splitIntoFibonacci = 
				(new Solution842()).splitIntoFibonacci("1101111");
		System.out.println(splitIntoFibonacci);
	}
	
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> result = new ArrayList<Integer>();
		int length = S.length();
		int i= 1;
		int j= 1;
		boolean flag = false;
		for (i = 1; i < length; i++) {
			for (j = 1; j < length; j++) {
				if(i+j>=length)
					break;
				try {
					if(isFibonacci(S, i, j)) {
						flag = true;
						break;
					}
				}catch(Exception e) {
					
				}
			}
			if(flag) {
				break;
			}
		}
		if(flag) {
			int sumlength = i+j;
			String firstnum = S.substring(0, i);
			String secondnum = S.substring(i,i+j);
			result.add(Integer.parseInt(firstnum));
			result.add(Integer.parseInt(secondnum));
			while(sumlength!=S.length()) {
				String nextnum = String.valueOf(Integer.parseInt(firstnum)+Integer.parseInt(secondnum));
				sumlength += nextnum.length();
				firstnum = secondnum;
				secondnum = nextnum;
				result.add(Integer.parseInt(nextnum));
			}
		}
		return result;
    }
	
	public boolean isFibonacci(String s,int firstlength,int secondlength) {
		StringBuffer sb = new StringBuffer("");
		int firstnum = Integer.parseInt(s.substring(0, firstlength));
		int secondnum = Integer.parseInt(s.substring(firstlength,firstlength+secondlength));
		int sum = firstlength + secondlength;
		sb.append(firstnum);
		sb.append(secondnum);
		while(sum<s.length()) {
			int nextnum = firstnum + secondnum;
			int nextnumlength = String.valueOf(nextnum).length();
			sb.append(nextnum);
			if(!sb.toString().equals(s.substring(0,sum+nextnumlength))) {
				return false;
			}
			sum += nextnumlength;
			firstnum = secondnum;
			secondnum = nextnum;
		}
		return true;
	}

}


// 执行结果
//执行用时 : 380 ms, 在Split Array into Fibonacci Sequence的Java提交中击败了5.26% 的用户
//内存消耗 : 47.7 MB, 在Split Array into Fibonacci Sequence的Java提交中击败了12.25% 的用户
