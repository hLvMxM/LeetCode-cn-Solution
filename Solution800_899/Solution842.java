//缁欏畾涓�涓暟瀛楀瓧绗︿覆 S锛屾瘮濡� S = "123456579"锛屾垜浠彲浠ュ皢瀹冨垎鎴愭枑娉㈤偅濂戝紡鐨勫簭鍒� [123, 456, 579]銆�
//
//褰㈠紡涓婏紝鏂愭尝閭ｅ寮忓簭鍒楁槸涓�涓潪璐熸暣鏁板垪琛� F锛屼笖婊¤冻锛�
//
//0 <= F[i] <= 2^31 - 1锛岋紙涔熷氨鏄锛屾瘡涓暣鏁伴兘绗﹀悎 32 浣嶆湁绗﹀彿鏁存暟绫诲瀷锛夛紱
//F.length >= 3锛�
//瀵逛簬鎵�鏈夌殑0 <= i < F.length - 2锛岄兘鏈� F[i] + F[i+1] = F[i+2] 鎴愮珛銆�
//鍙﹀锛岃娉ㄦ剰锛屽皢瀛楃涓叉媶鍒嗘垚灏忓潡鏃讹紝姣忎釜鍧楃殑鏁板瓧涓�瀹氫笉瑕佷互闆跺紑澶达紝闄ら潪杩欎釜鍧楁槸鏁板瓧 0 鏈韩銆�
//
//杩斿洖浠� S 鎷嗗垎鍑烘潵鐨勬墍鏈夋枑娉㈤偅濂戝紡鐨勫簭鍒楀潡锛屽鏋滀笉鑳芥媶鍒嗗垯杩斿洖 []銆�
//
//绀轰緥 1锛�
//
//杈撳叆锛�"123456579"
//杈撳嚭锛歔123,456,579]
//绀轰緥 2锛�
//
//杈撳叆: "11235813"
//杈撳嚭: [1,1,2,3,5,8,13]
//绀轰緥 3锛�
//
//杈撳叆: "112358130"
//杈撳嚭: []
//瑙ｉ噴: 杩欓」浠诲姟鏃犳硶瀹屾垚銆�
//绀轰緥 4锛�
//
//杈撳叆锛�"0123"
//杈撳嚭锛歔]
//瑙ｉ噴锛氭瘡涓潡鐨勬暟瀛椾笉鑳戒互闆跺紑澶达紝鍥犳 "01"锛�"2"锛�"3" 涓嶆槸鏈夋晥绛旀銆�
//绀轰緥 5锛�
//
//杈撳叆: "1101111"
//杈撳嚭: [110, 1, 111]
//瑙ｉ噴: 杈撳嚭 [11,0,11,11] 涔熷悓鏍疯鎺ュ彈銆�
//鎻愮ず锛�
//
//1 <= S.length <= 200
//瀛楃涓� S 涓彧鍚湁鏁板瓧銆�

package Solution800_899;

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


// 鎵ц缁撴灉
//鎵ц鐢ㄦ椂 : 380 ms, 鍦⊿plit Array into Fibonacci Sequence鐨凧ava鎻愪氦涓嚮璐ヤ簡5.26% 鐨勭敤鎴�
//鍐呭瓨娑堣�� : 47.7 MB, 鍦⊿plit Array into Fibonacci Sequence鐨凧ava鎻愪氦涓嚮璐ヤ簡12.25% 鐨勭敤鎴�
