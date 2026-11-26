class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Step 1: Add boundary land cells
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                visited[i][0] = true;
                q.offer(new int[]{i, 0});
            }

            if (grid[i][n-1] == 1 && !visited[i][n-1]) {
                visited[i][n-1] = true;
                q.offer(new int[]{i, n-1});
            }
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                visited[0][j] = true;
                q.offer(new int[]{0, j});
            }

            if (grid[m-1][j] == 1 && !visited[m-1][j]) {
                visited[m-1][j] = true;
                q.offer(new int[]{m-1, j});
            }
        }

        // Step 2: BFS from boundary land
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 1 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 3: Count unvisited land cells
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}