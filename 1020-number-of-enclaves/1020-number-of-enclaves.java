class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 || i == n-1 || j==0 || j == m-1) {
                    if(grid[i][j] == 1) {
                        vis[i][j] = true;

                        q.offer(new int[]{i,j});
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};

            for(int i=0;i<4;i++) {
                int nx = row + delRow[i];
                int ny = col + delCol[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1 && !vis[nx][ny]) {
                    vis[nx][ny] = true;

                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}