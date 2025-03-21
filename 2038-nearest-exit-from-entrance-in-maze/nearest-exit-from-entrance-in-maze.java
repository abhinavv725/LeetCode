class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m; 
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        if(maze[entrance[0]][entrance[1]]=='+')
            return -1;
        Queue<int[]> q= new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]]='+';

        int steps=0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                int[] curr = q.poll();
                int i=curr[0], j=curr[1];
                if((i==0 || j==0 || i== n-1 || j==m-1) && !(i==entrance[0] && j==entrance[1])){
                    return steps;
                }
                for(int k=0;k<=3;k++){
                    int x = curr[0]+dx[k];
                    int y = curr[1]+dy[k];
                    if(isValid(x,y, n,m) && maze[x][y]=='.'){
                        q.add(new int[] {x,y});
                        maze[x][y]='+';
                    }   
                }
            }
            steps++;

        }
        return -1;
    }
}