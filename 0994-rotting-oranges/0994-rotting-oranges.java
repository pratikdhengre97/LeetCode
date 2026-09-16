class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int total = 0;
        int cnt = 0;

        Queue<int[]> rotten = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if(grid[i][j] == 2) {
                    rotten.offer(new int[]{i,j});
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int days = 0;

        while(!rotten.isEmpty()) {
            int k = rotten.size();

            cnt += k;

            for(int i=0;i<k;i++) {
                int[] pos = rotten.poll();
                int x = pos[0];
                int y = pos[1];

                for(int d=0;d<4;d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    rotten.add(new int[]{nx, ny});
                }
            }
            if(!rotten.isEmpty()) days++;

            
        }
        return total == cnt ? days : -1;

    }
}