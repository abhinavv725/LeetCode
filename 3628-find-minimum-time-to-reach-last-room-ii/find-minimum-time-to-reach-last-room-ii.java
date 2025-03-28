class Solution {
    private class Node{
        int i;int j;int time;int step;
        Node(int i, int j, int time, int step){
            this.i=i;
            this.j=j;
            this.time=time;
            this.step=step;
        }
    }
    private boolean isValid(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.time,b.time));
        int n= moveTime.length;
        int m= moveTime[0].length;
        boolean[][] vis = new boolean[n][m];
        pq.add(new Node(0,0,0,0));
        int[][] dir = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] dist = new int[n][m];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Node p = pq.poll();
            int i=p.i;
            int j=p.j;
            int time=p.time;
            int step = p.step;
            if(time>dist[i][j])
                continue;
            for(int[] d: dir){
                int nr = i+d[0];
                int nc = j+d[1];
                if(!isValid(nr,nc,n,m))
                    continue;
                int nt = 1+Math.max(time, moveTime[nr][nc]);
                if(step==1){
                    nt++;
                }
                if(dist[nr][nc]>nt){
                    dist[nr][nc]=nt;
                    if(step==1){
                        pq.add(new Node(nr,nc, nt, 2));

                    }else{
                        pq.add(new Node(nr,nc, nt, 1));

                    }
                }
            }
            
        }
        return dist[n-1][m-1];
    }
}