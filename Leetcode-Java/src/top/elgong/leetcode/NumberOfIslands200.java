package top.elgong.leetcode;

public class NumberOfIslands200 {

    /*
思路： 对值为 '1' 的点dfs, 查到的为'1'的值标记为‘0’，避免重复dfs 统计‘1’出现的次数
time:  O(MN)
space: O(MN)

*/

    // 以‘1’ 为核心，向四周递归搜索，并做处理
    private void dfs(char[][] grid, int x, int y){
        int lenX = grid.length;
        int lenY = grid[0].length;

        // 边界溢出 或者 无岛屿
        if(x<0 || y<0 || x>=lenX || y>=lenY || grid[x][y] == '0'){
            return ;
        }

        // 剩下就等于1
        // 先标记为‘0’， 再向四周搜索
        grid[x][y] = '0';

        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);

    }
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0 ){
            return 0;
        }

        int lenX = grid.length;
        int lenY = grid[0].length;

        int count = 0;

        // 对grid 的每一个点都做一次搜索
        for(int i=0; i<lenX; i++){
            for(int j=0; j<lenY; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

}
