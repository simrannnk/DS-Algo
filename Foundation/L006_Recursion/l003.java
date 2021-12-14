public class l003{

    public static int floodFill(int sr,int sc,int dr,int dc,boolean[][] vis,int[][] dir,String[] dirs,String ans)
    {
        int n=vis.length;
        int m=vis[0].length;

        if(sr==dr && sc==dc)
        {
            System.out.println(ans);
            return;
        }

        int count=0;
        vis[sr][sc]=true;//aate hi mark the visited as true

        for(int d=0;d<dirs.length();d++)//using for loop to write 4 directions 
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
        
//check krlo ki jha jane vale ho voh boundary ke andr h ki ni 
        if(r>=0 && c>=0 && r<dr && c<dc &&vis[r][c]=false)
        {
            count+=floodFill(r,c,dr,dc,vis,dir,dirs,ans+dirs[d]);
        }

        }
    
        vis[sr][sc]=false;//free the location after all the calls in all the directions
    }

    public static int floodFill_Jump(int sr,int sc,int dr,int dc,boolean[][] vis,int[][] dir,String[] dirs,String ans)
    {
         int n=vis.length;
        int m=vis[0].length;

        if(sr==dr && sc==dc)
        {
            System.out.println(ans);
            return;
        }

        int count=0;
        vis[sr][sc]=true;//aate hi mark the visites as true
//uisng for loop to write 4 directions 
 for(int rad=1;rad<=Math.max(n,m);rad++)
            {
        for(int d=0;d<dirs.length();d++)
            {
            int r=sr+rad*dir[d][0];
            int c=sc+rad*dir[d][1];
              
//check krlo ki jha jane vale ho voh boundary ke andr h ki ni 
        if(r>=0 && c>=0 && r<dr && c<dc &&vis[r][c]=false)
        {
            count+=floodFill(r,c,dr,dc,vis,dir,dirs,ans+dirs[d]+rad);
        }

        }
    }
    
        vis[sr][sc]=false;//free the location
    }

public static void displayBoard(int[][] arr)
{
    for(int =0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]);
        }
        System.out.println();
    }

    System.out.println();
}

//tnc:total no of cells
    public static void knightMove(int sr,int sc,int moves,int tnc,int[][] vis,int[][] dir)
    {
        if(moves==tnc)
        {
            vis[sr][sc]=moves;
            displayBoard(vis);
            vis[sr][sc]=0;
            return;
        }
        vis[sr][sc]=moves;
        int n=vis.length;
        int m=vis[0].length;  

        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0)
            {
                knightMove(r,c,moves+1,tnc,vis,dir);// keep increasing the moves until no of moves= tnc 
            }
        }

        vis[sr][sc]=0;
    }

public static void knightTour(int sr,int sc,int n)
{
    int[][] vis=new int[n][n];
   int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
    knightMove(sr,sc,1,n*n,vis,dir);

}

public static int findSum(int[] nums,int S,int ssf,int idx)
 {
     //ssf: sum so far
     if(idx==nums.length)
     {
         if(S==ssf)
         {
             return 1;
         }
         else{
             return 0;
         }
         
     }
     
     
     int ans1=findSum(nums,S,ssf+nums[idx],idx+1);
     int ans2=findSum(nums,S,ssf+(-nums[idx]),idx+1);
     
     return ans1+ans2;
 }

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public static void paths(int sr,int sc,int dr,int dc,int[][] dir,String[] dirs,int[][] vis,String psf,ArrayList<String> res)
    {
        
        if(sr==dr && sc==dc)
        {
            res.add(psf);
            return ;
        }
      
        vis[sr][sc]=0;

        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            
            if(r>=0 && c>=0 && r<=dr && c<=dc && vis[r][c]==1)
            {
                paths(r,c,dr,dc,dir,dirs,vis,psf+dirs[d],res);
            }
        }
        vis[sr][sc]=1;
        
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here   
        int[][] dir={{1,0},{0,-1},{0,1},{-1,0}};
        String[] dirs={"D","L","R","U"};
        ArrayList<String> res =new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0)
        {
            ArrayList<String> base=new ArrayList<>();
           return base;
        }
       paths(0,0,n-1,n-1,dir,dirs,m,"",res);
        return res;
    }
// https://practice.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1

    public static void main(String[] args)
    {

    }
}