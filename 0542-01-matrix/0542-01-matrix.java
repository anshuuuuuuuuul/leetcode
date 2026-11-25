class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0, -1}};
        Queue <int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m; i ++){
            for (int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    dis[i][j] = 0;
                    q.offer(new int[]{i, j, 0});
                }
                else{
                    dis[i][j]= -1;
                }
            }
        } 
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            for(int i = 0 ; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && dis[nr][nc] == -1){
                    dis[nr][nc] = d + 1;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        return dis;
    }
}