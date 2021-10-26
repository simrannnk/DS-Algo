public class l001{

    public static int floodFill(int sr ,int sc,int dr,int dc,String path,boolean[][] vis,int[][] dir, String[] dirs)
    {

        if(sr==dr && sc==dc)
        {
            System.out.println(path);
            return 1;
        }

        int n=vis.length;
        int m=vis[0].length;

        int count=0;

        vis[sr][sc]=true;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<n && c<m && !vis[r][c])
            {
                count+=floodFill(r,c,dr,dc,path+dir[d]+" ",vis,dir ,dirs);
            }
        }

        vis[sr][sc]=false;
        return count;
    }

public static class pathPair
{
    int len=0;
    String psf="";
    int count=0;

    pathPair(int len,String psf,int count)
    {
        this.len=len;
        this.psf=psf;
        this.count=count;
    }
}

public static pathPair floodFill_Longest(int sr,int sc,int dr,int dc,boolean[][] vis,int[][] dir,String[] dirs)
{
    int n=vis.length;
    int m=vis[0].length;

    if(sr==dr && sc==dc)
    {
        return new pathPair(0, "",1);
    }
    vis[sr][sc]=true;

    pathPair myAns=new pathPair(0," ",0);

    for(int d=0;d<dir.length;d++)
    {
        int r=sr+dir[d][0];
        int c=sc+dir[d][1];

        if(r>=0 && c>=0 && r<n && c<m && !vis[r][c])
        {
            pathPair recAns=floodFill_Longest(r,c,dr,dc,vis,dir,dirs);
            if(recAns.len+1>myAns.len)
            {
                myAns.len=recAns.len+1;
                myAns.psf=dirs[d]+recAns.psf;
            }

            myAns.count+=recAns.count;
        }
    }

    vis[sr][sc]=false;
    return myAns;
}

public static pathPair floodFill_Shortest(int sr,int sc,int dr,int dc,boolean[][] vis,int[][] dir,String[] dirs)
{
     int n=vis.length;
    int m=vis[0].length;

        if(sr==dr && sc==dc)
    {
        return new pathPair(0, "",1);
    }
    vis[sr][sc]=true;

    pathPair myAns=new pathPair((int)1e9," ",0);

    for(int d=0;d<dir.length;d++)
    {
        int r=sr+dir[d][0];
        int c=sc+dir[d][1];

        if(r>=0 && c>=0 && r<n && c<m && !vis[r][c])
        {
            pathPair recAns=floodFill_Shortest(r,c,dr,dc,vis,dir,dirs);
            if(recAns.len+1<myAns.len)
            {
                myAns.len=recAns.len+1;
                myAns.psf=dirs[d]+recAns.psf;
            }

            myAns.count+=recAns.count;
        }
    }

    vis[sr][sc]=false;
    return myAns;

}


  public static void main(String[] args)
    {
        
int[][] dir={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
String[] dirs={"u","d","r","l","n","s","e","w"};

int n=4;
int m=4;
boolean[][] vis=new boolean[n][m];

System.out.println(floodFill(0,0,n-1,m-1,"",vis,dir,dirs));
    }

}