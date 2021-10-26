public class questions{

https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

     public static int paths(int sr,int sc,int dr,int dc,int[][] dir,String[] dirs,int[][] vis,String psf,ArrayList<String> res)
    {
        
        if(sr==dr && sc==dc)
        {
            res.add(psf);
            return 1;
        }
        
        int count=0;
        vis[sr][sc]=0;

        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            
            if(r>=0 && c>=0 && r<=dr && c<=dc && vis[r][c]==1)
            {
                count+=paths(r,c,dr,dc,dir,dirs,vis,psf+dirs[d],res);
            }
        }
        vis[sr][sc]=1;
        return count;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code 
   int[][] dir={{1,0},{0,-1},{0,1},{-1,0}};
        String[] dirs={"D","L","R","U"};
        ArrayList<String> res =new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0)
        {
            return res;
        }
        int ans= paths(0,0,n-1,n-1,dir,dirs,m,"",res);
        return res;
        
    }

    public static void main(String[] args)
    {

    }
}