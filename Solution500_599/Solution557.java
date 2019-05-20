//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//示例 1:
//
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

package Solution500_599;

public class Solution557 {
	public static void main(String[] args) {
		String reverseWords = (new Solution557()).reverseWords("Let's");
		System.out.println(reverseWords);
	}
	
	public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String string : split) {
			StringBuffer reverse = new StringBuffer(string).reverse();
			sb.append(reverse+" ");
		}
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}

//执行用时 : 17 ms, 在Reverse Words in a String III的Java提交中击败了58.01% 的用户
//内存消耗 : 48.5 MB, 在Reverse Words in a String III的Java提交中击败了53.71% 的用户