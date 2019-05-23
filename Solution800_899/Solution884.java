//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
//如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
//返回所有不常用单词的列表。
//
//您可以按任何顺序返回列表。
//
// 
//
//示例 1：
//
//输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
//示例 2：
//
//输入：A = "apple apple", B = "banana"
//输出：["banana"]
// 
//
//提示：
//
//0 <= A.length <= 200
//0 <= B.length <= 200
//A 和 B 都只包含空格和小写字母。
package Solution800_899;

import java.util.HashSet;

public class Solution884 {
	public String[] uncommonFromSentences(String A, String B) {
		HashSet<String> firstSet = new HashSet<String>();
		HashSet<String> moreSet = new HashSet<String>();
		for (String string : (A+" "+B).split(" ")) {
			if (firstSet.contains(string)) {
				moreSet.add(string);
			}
			firstSet.add(string);
		}
		firstSet.removeAll(moreSet);
		String[] result = new String[firstSet.size()];
		firstSet.toArray(result);
		return result;
    }
}

//执行用时 : 7 ms, 在Uncommon Words from Two Sentences的Java提交中击败了64.79% 的用户
//内存消耗 : 34.7 MB, 在Uncommon Words from Two Sentences的Java提交中击败了98.10% 的用户