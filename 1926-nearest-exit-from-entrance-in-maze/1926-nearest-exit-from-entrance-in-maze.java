class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != '+') {
                        if(nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                            return count + 1;
                        }
                        maze[nr][nc] = '+';
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}