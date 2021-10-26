public class bfs_questions{

    public static int orangesRotting(int[][] grid){
  
        int n=grid.length;
        int m=grid[0].length;
        LinkedList<Integer> que=new LinkedList<>();

        int freshOranges=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    freshOranges++;
                }

                else if(grid[i][j]==2)
                {
                    int idx=i*m+j;
                    que.addLast(idx);
                    grid[i][j]=2;// mark them visited
                }

            }
        }

        if(freshOranges==0)
        {
            return 0;
        }

        int time=0;

        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {

                int rottedOrangeIDX=que.removeFirst();
                int sr=rottedOrangeIDX/m;
                int sc=rottedOrangeIDX%m;

                for(int d=0;d<dir.length;d++)
                {
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];

                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1)
                    {
                        if(--freshOranges==0)
                        {
                            return time+1;
                        }
                        grid[r][c]=2;//jo fresh oranges ab rotten ho gye mark them as 2
                        que.addLast(r*m+c);// 
                    }
                }
            }
            time++;
        }
        return -1;
    }

     public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        LinkedList<Integer> que=new LinkedList<>();
        
        if(n==0 || m==0)
        {
            return 0;
        }
        
        if(grid[0][0]==1 || grid[n-1][m-1]==1)
        {
            return -1;
        }
        
        que.addLast(grid[0][0]);
        grid[0][0]=1;
        
        int shortestPath=1;
        
        while(que.size()!=0)
        {
            int size=que.size();
            
            while(size-->0)
            {
                 int removeIDX=que.removeFirst();
                int sr=removeIDX/m;
                int sc=removeIDX%m;
                
                if(sr==n-1 && sc==m-1)
                {
                    return shortestPath;
                }
                
                for(int d=0;d<dir.length;d++)
                {
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==0)
                    {
                     
                        grid[r][c]=1;
                        que.addLast(r*m+c);
                    }
                }
            }
            shortestPath++;
        }
        return -1;
    }
        public int[][] updateMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return grid;

        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    vis[i][j] = true;
                    que.addLast(i * m + j);
                }
            }
        }

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;

                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                        vis[r][c] = true;
                        grid[r][c] = grid[sr][sc] + 1;
                        que.addLast(r * m + c);
                    }
                }
            }
        }

        return grid;
    }

    import java.util.LinkedList;

public void wallsAndGates(int[][] rooms) {
        // write your code here
        int n=rooms.length;
        int m=rooms[0].length;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};


LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rooms[i][j]==0)
                {
                    int idx=i*m+j;
                    que.addLast(idx);
                   
                }
            }
        }

        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rvtxIDX=que.removeFirst();
                int sr=rvtxIDX/m;
                int sc=rvtxIDX%m;

                for(int d=0;d<dir.length;d++)
                {
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];

                    if(r>=0 && c>=0 && r<n && c<m && rooms[r][c]==2147483647 )
                    {
                        que.addLast(r*m+c);
                        rooms[r][c]=rooms[sr][sc]+1;
                    }
                }
            }
        }
    }
}

public int longestIncreasingPath(int[][] matrix)
{

    int n=matrix.length;
    int m=matrix[0].length;

    LinkedList<Integer> que=new LinkedList<>();
    int[][] indegree=new int[n][m];

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            for(int d=0;d<dir.length;d++)
            {
                int r=i+dir[d][0];
                int c=j+dir[d][1];

                if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[i][j])
                {
                    indegree[r][c]++;
                }


            }
        }
    }

     for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(indegree[i][j]==0)
            {
                int idx=i*m+j;
                que.addLast(idx);
            }
        }
    }

    int level=0;
    while(que.size()!=0)
    {
        int rvtx=que.removeFirst();

        int i = rvtx / m, j = rvtx % m;
         for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

         if (r >= 0 && c >= 0 && r < n && c < m && matrix[i][j] < matrix[r][c] && --indegree[r][c] == 0)
         {
              que.addLast(r * m + c);
         }          
    }

    level++;
        
    }

    return level;

}

}