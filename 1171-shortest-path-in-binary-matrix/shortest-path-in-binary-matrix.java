
class Solution {
    private class Node{
        int i, j, len;
        Node(int i, int j, int len){
            this.i=i;
            this.j=j;
            this.len=len;
        }
    }
    private boolean isValid(int i, int j, int n){
        if(i>=0 && j>=0 && i<n && j<n){
            return true;
        }
        return false;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis= new boolean[n][n];
        q.add(new Node(0,0,1));
        vis[0][0]=true;
        if(grid[0][0]==1)return -1;
        if(grid[0][0]==0 && n==1)return 1;
        while(!q.isEmpty()){
            Node x = q.poll();
            int i=x.i, j=x.j, len=x.len;

            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    int dx = i+a;
                    int dy = j+b;
                    if(isValid(dx,dy,n) && !vis[dx][dy] && grid[dx][dy]==0){
                        vis[dx][dy]=true;
                        q.add(new Node(dx,dy, len+1));
                        if(dx==n-1 && dy==n-1){
                            return len+1;
                        }
                    }

                }
            }
            

        } 
        return -1;

    }
}