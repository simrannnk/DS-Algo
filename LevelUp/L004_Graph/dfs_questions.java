
import java.util.HashSet;
public class questions_dfs{

     public void dfs_NumIsland(char[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = '2';
        int n = grid.length, m = grid[0].length;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == '1')
                dfs_NumIsland(grid, r, c, dir);
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, componentCount = 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs_NumIsland(grid, i, j, dir);
                    componentCount++;
                }
            }
        }
// when we changes the entire graph by making all the cells 1 so usko thik krna hoga 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }

        return componentCount;
    }

    public static int AreaIsland_dfs(int[][] grid,int[][] dir,int i,int j)
    {
        grid[i][j]=0;//jisko visit kra 0 mark kro
        int size=0;

        for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=j+dir[d][1];

            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1)//dfs call only when neighbours are 1
            {
                size+=AreaIsland_dfs(grid,dir,r,c);//gives the size of the neighbours
            }
        }

        return size+1;//neighbour's size +1 i.e uska size
    }

    public static int MaxAreaIsland(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int maxSize=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==1)
                {
                    int s=AreaIsland_dfs(grid,dir,i,j);
                    if(s>maxSize)
                    {
                        return s;
                    }

                    return maxSize;
                }
            }
        }
    }

    public static int PermieterIsland(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dir={{1,0},{0,1}};

        int onceCount=0;
        int nbrCount=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    onceCount++;
                    for(int d=0;d<2;d++)
                    {
                        int r=i+dir[d][0];
                        int c=dir[d][1];

                        if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1)
                        {
                            nbrCount++;
                        }
                    }
                }
            }
        }

        int ans=4*onceCount-2*nbrCount;
        return ans;
    }

    public static void surrounded_dfs(char[][] grid,int i,int j,int[][] dir)
    {
        grid[i][j]='$';//jidr paani katha ni hora udr $ aajayega

        for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=j+dir[d][1];

            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='O')
            {
                surrounded_dfs(grid,r,c,dir);
            }
        }
        
    }

    public static void surroundedRegions(char[][] grid)
    {

        int n=grid.length;
        int m=grid[0].length;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]=='O')//we will start from the boundary coz we know udr paani katha ni hoga
                {
                    surrounded_dfs(grid,i,j,dir);// only O marked cell ke liye call hoga 
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='$')
                {
                    grid[i][j]='O';// jidr paani katha ni hora udr $ h so make it O
                }

                else{
                    grid[i][j]='X';//idr paani katha hora h so udr building bna do so mark it as x
                }
            }
        }
    }

    //leetcode ques 694- Number of Distict Islands (Lintcode Ques 860)
    public static NumberOfDistinctIsland_dfs(int[][] grid,int i,int j,int[][] dir,String[] dirs,String ans)
    {
        
        int n=grid.length;
        int m=grid[0].length;

        grid[i][j]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=dir[d][1];

            if(r>=0 && c>=0  &&& r<n && c<m && grid[r][c]=='1')
            {
                ans.append(dirs[d]);
                NumberOfDistinctIsland_dfs(grid,r,c,dir,dirs,ans);
                ans.append("b");
            }
        }
    }

    public static int NumberOfDistinctIsland(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        String[] dirs={"R","L","D","U"};

        StringBuilder ans;
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    ans=new StringBuilder();// imp-> jha bi 1 hoga udr new StringBuilder bnega
                    NumberOfDistinctIsland_dfs(grid,i,j,dir,dirs,ans);
                    set.add(ans.toString());
                }
                
            }
        }

        return set.size();
    }

  
    public static boolean countSubIsland_dfs(int[][] grid1,int[][] grid2,int i,int j,int[][] dir)
    {
        int n=grid1.length;
        int m=grid1[0].length;

        grid2[i][j]=0;
        boolean res=true;
        for(int d=0;d<dir.length;d++)
        {
            int r=i+dir[d][0];
            int c=dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m&& grid2[i][j]=1)
            {
                 res=countSubIsland_dfs(grid1,grid2,r,c) && res;
            }
        }

        return res && grid[i][j]==1;
    }

    public static int countSubIsland(int[][] grid1,int[][] grid2)
    {
        int count=0;
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

        int n=grid1.length;
        int m=grid1[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1)
                {
                    boolean ans=countSubIsland_dfs(grid1,grid2,i,j,dir);
                    if(ans)
                    {
                        count++;
                    }
                    i
                }
            }
        }

        return count;
    }

    }

}

