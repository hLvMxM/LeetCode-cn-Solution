package Solution1000_1099;

import java.util.HashSet;
import java.util.Set;

public class Solution1012 {
	
	public static void main(String[] args) {
		int numDupDigitsAtMostN = (new Solution()).numDupDigitsAtMostN(2999);
		System.out.println(numDupDigitsAtMostN);
	}
	
	public int numDupDigitsAtMostN(int N) {
		String num = String.valueOf(N); //转成字符串用于获取长度
		int length = num.length();      //长度
		int nodup = 0;                  //不重复个数
		for(int i=1;i<=length;i++)     
			nodup += 9*factorial(9)/factorial(10-i);  //分别判断例如从100~999，10~99，1~9的不重复数字并累计和
		Set<Integer> dup = new HashSet<>();           //set用于重复情况
		for(int i=0;i<length;i++){					  
			//获取第i位的数，为a，那么就要减掉第i位从a+1~9的不重复数
			char charAt = num.charAt(i);
			String valueOf = String.valueOf(charAt);
			Integer a = Integer.valueOf(valueOf);
			
			for (int j = a+1; j < 10; j++) {//例如 减去4000~9999（或者3200~3299）的重复数量
				if(!dup.contains(j))
					nodup -= factorial(9-dup.size())/factorial(10+i-length-dup.size());
			}
			if(dup.contains(a)) //如果N的前几位就有重复。后续不必再继续算下去了
				break;
			dup.add(a);
		}
		return N-nodup;
	}
	
	//阶乘函数
	private int factorial(int N) {
		int r = 1;
		for (int i = 1; i <= N; i++) {
			r*=i;
		}
		return r;
	}
}