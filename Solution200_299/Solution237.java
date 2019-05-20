//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点�?
//
//现有�?个链�? -- head = [4,5,1,9]，它可以表示�?:
//
//https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/237_example.png
//
//示例 1:
//
//输入: head = [4,5,1,9], node = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//示例 2:
//
//输入: head = [4,5,1,9], node = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
//说明:
//
//链表至少包含两个节点�?
//链表中所有节点的值都是唯�?的�??
//给定的节点为非末尾节点并且一定是链表中的�?个有效节点�??
//不要从你的函数中返回任何结果�?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package Solution200_299;

public class Solution237 {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		(new Solution237()).deleteNode(l1);
		
	}
	
	public static void printNode(ListNode l1) {
		ListNode l = l1;
		while(l.next!=null) {
			System.out.println(l.val);
			l = l.next;
		}
		return;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

//执行用时 : 1 ms, 在Delete Node in a Linked List的Java提交中击败了85.98% 的用�?
//内存消�?? : 36 MB, 在Delete Node in a Linked List的Java提交中击败了67.02% 的用�?


// 题解：只给一个Node节点，由于肯定不是最后的节点，所以可以与后一位交换�?�，再删除后�?位的节点