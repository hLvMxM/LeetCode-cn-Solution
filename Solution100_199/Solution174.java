//一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
//
//骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
//
//有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
//
//为了尽快到达公主，骑士决定每次只向右或向下移动一步。
//
// 
//
//编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
//
//例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
//
//-2 (K)	-3	3
//-5	-10	1
//10	30	-5 (P)
// 
//
//说明:
//
//骑士的健康点数没有上限。
//
//任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
package Solution100_199;

public class Solution174 {
	
	public static void main(String[] args) {
		int[][] dungeon = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println((new Solution174()).calculateMinimumHP(dungeon));
	}
	
	public int calculateMinimumHP(int[][] dungeon) {
		int height = dungeon.length;
		int width = dungeon[0].length;
		
		int[][] cost = new int[height+1][width+1];
		for (int i = 0; i < height; i++) {
			cost[i][width] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= width; i++) {
			cost[height][i] = Integer.MAX_VALUE;
		}
		for (int i = height-1; i >= 0; i--) {
			for (int j = width-1; j >= 0; j--) {
				if(i==height-1 &&j==width-1) {
        			cost[i][j]= dungeon[i][j]>0?1:1-dungeon[i][j];
        			continue;
        		}
				cost[i][j] = Math.max(1, Math.min(cost[i+1][j], cost[i][j+1])-dungeon[i][j]);//最低血量为1
			}
		}
		return cost[0][0];
    }
}

//题解：这道题目难度较高。
//看了答案才学会的，使用动态规划解题，如果从起点到终点进行遍历的话算法要求过更加复杂。
//而反向推更为容易，由公主房间确定所需健康点，一路倒推。即可。


//执行用时 : 4 ms, 在Dungeon Game的Java提交中击败了80.43% 的用户
//内存消耗 : 37 MB, 在Dungeon Game的Java提交中击败了84.89% 的用户
