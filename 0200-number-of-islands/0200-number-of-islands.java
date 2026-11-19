import java.util.*;
class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    BFS(i, j, grid, vis);
                    island++;
                }
            }
        }
        return island;
    }
    public void BFS(int row, int col, char[][] grid, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        vis[row][col] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (newR >= 0 && newR < grid.length &&
                    newC >= 0 && newC < grid[0].length &&
                    grid[newR][newC] == '1' &&
                    !vis[newR][newC]) {
                    q.offer(new int[]{newR, newC});
                    vis[newR][newC] = true;
                }
            }
        }
    }
}
