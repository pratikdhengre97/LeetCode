class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.get(u).add(new int[]{v, cost});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,src,0}); // stops, src, code

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int stops = cell[0];
            int node = cell[1];
            int cost = cell[2];

            if(stops > k) continue;

            for(int[] neighbour : adj.get(node)) {
                int nextNode = neighbour[0];
                int wt = neighbour[1];

                if(cost + wt < dist[nextNode]) {
                    dist[nextNode] = cost + wt;

                    q.offer(new int[]{stops+1, nextNode, dist[nextNode]});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}