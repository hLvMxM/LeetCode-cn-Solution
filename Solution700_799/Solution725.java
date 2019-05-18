//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
//
//每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
//
//这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
//
//返回一个符合上述规则的链表的列表。
//
//举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
//
//示例 1：
//
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
//示例 2：
//
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
//提示:
//
//root 的长度范围： [0, 1000].
//输入的每个节点的大小范围：[0, 999].
//k 的取值范围： [1, 50].

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package Solution700_799;

import java.awt.List;
import java.util.ArrayList;

public class Solution725 {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(1);
		ListNode a4 = new ListNode(1);
//		ListNode a5 = new ListNode(1);
//		ListNode a6 = new ListNode(1);
//		ListNode a7 = new ListNode(1);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = null;
//		a5.next = a6;
//		a6.next = a7;
//		a7.next = null;
		(new Solution725()).splitListToParts(a1, 5);
	}
	
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode tmp = root;
		int count = 0;
		while (tmp!=null) {
			count++;
			tmp = tmp.next;
		}
		int nums = count / k;
		int times = count % k;
		ArrayList<ListNode> list = new ArrayList<>();
		ListNode sign = root;
		for (int i = 0; i < k; i++) {
			int length = nums;
			if(times!=0) {
				length ++;
				times--;
			}
			if(length!=0) {
				list.add(sign);
				ListNode lastsign = sign;
				for (int j = 0; j < length; j++) {
					lastsign = sign;
					sign = sign.next;
				}
				lastsign.next = null;
			}else {
				list.add(null);
			}
		}
		ListNode[] a = new ListNode[k];
		return list.toArray(a);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//解题思路：首先获取链表长度count，除以k获取每列个数。遍历k次获取链表，并记录最后一个链表并指向null

//执行用时 : 1 ms, 在Split Linked List in Parts的Java提交中击败了99.26% 的用户
//内存消耗 : 36.1 MB, 在Split Linked List in Parts的Java提交中击败了88.79% 的用户
