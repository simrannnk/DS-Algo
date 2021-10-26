import java.util.*;
public class l001_TwoPointer{

// //  1. Faith 2. Recursive Tree 3. Recursion Code 4. Convert Recursion code into
// //  memoization 5. Observation 6. Tabulation 7. Optimization

   public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            display(ar);
        }
        System.out.println();
    }


//fibo(n)=fibo(n-1)+fibo(n-2)
    public static int fibo_memo(int n,int[] dp)
    {
        if(n<=1)
        {
            return dp[n]=n;// base case bi value store krni h 
        }

        if(dp[n]!=0)// taking 0 as the default value
        {
            return dp[n];
        }

        int ans=fibo_memo(n-1,dp)+fibo_memo(n-2,dp);
        return dp[n]=ans;
    }

    public static int fibo_tab(int N,int[] dp)
    {
        for(int n=0;n<N;n++)
        {
            if(n<=1)
            {
                dp[n]=n;// base case bi value store krni h 
                continue;
            }

        int ans=dp[n-1]+dp[n-2];//fibo_memo(n-1,dp)+fibo_memo(n-2,dp);
        dp[n]=ans;
        }
        
        return dp[N];
    }

    public static int fibo_opti(int n)
    {
        int a=0;
        int b=1;
        for(int i=0;i<n;i++)
        {
            int sum=a+b;
            a=b;
            b=sum;
        }

        return a;
    }

    public static void fiboSet()
    {
        int n=5;
        int[] dp=new int[n+1];// +1 bcoz last number ke liye bi value store krni h in the dp
        System.out.println(fibo_memo(n,dp));


    }

//-----------------------------------------------------------------------------------

//Total Paths=paths(H) +paths(V)+paths(D)
    public static int MazePath_memo(int sr,int sc,int dr,int dc,int[][] dp,int[][] dir)
    {

        if(sr==dr && sr==dc)
        {
            return dp[sr][sc]=1;
        }

        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }

        int paths=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<=dr && c<=dc)
            {
                paths+=MazePath_memo(r,c,dr,dc,dp,dir);
            }
        }
        return dp[sr][sc]=paths;
    }

    public static int MazePath_tabu(int SR,int SC,int dr,int dc,int[][] dp,int[][] dir)
    {
        for(int sr=dr;sr>=SR;sr--) // loop 0 tk ni jha tk starting point dia vha tk chlega i.e SR AND SC
        {
            for(int sc=dc;sc>=SC;sc--)
            {
                
        if(sr==dr && sr==dc)
        {
            dp[sr][sc]=1;
            continue;
        }

        int paths=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<=dr && c<=dc)
            {
                paths+=dp[r][c];//MazePath_memo(r,c,dr,dc,dp,dir);
            }
        }

         dp[sr][sc]=paths;

            }
        }

        return dp[SR][SC];
    }

    public static int MaxePathJump_memo(int sr,int sc,int dr,int dc,int[][] dp,int[][] dir)
    {
    
        if(sr==dr && sc==dc)
        {
            return dp[sr][sc]=1;
        }

        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }
        int path=0;

        for(int[] d:dir)
        {
            int r=sr+d[0];
            int c=sc+d[1];

            while(r>=0 && c>=0 && r<=dr && c<=dc)
            {
                r+=d[0];
                c+=d[1];
               path+= MaxePathJump_memo(r,c,dr,dc,dp,dir);
            }
        }

        return dp[sr][sc]=path;
    }

    
    public static int MaxePathJump_tabu(int SR,int SC,int dr,int dc,int[][] dp,int[][] dir)
    {
        for(int sr=dr;sr>=SR;sr++)
        {
            for(int sc=dc;sc>=SC;sc++)
            {

            if(sr==dr && sc==dc)
            {
                dp[sr][sc]=1;
                continue;
            }
        int path=0;
            for(int[] d:dir)
            {
                int r=sr+d[0];
                int c=sc+d[1];

                while(r>=0 && c>=0 && r<=dr && c<=dc)
                {
                    r+=d[0];
                    c+=d[1];
                    path+= dp[r][c]; //MaxePathJump_memo(r,c,dr,dc,dp,dir);
                }
            }

            dp[sr][sc]=path;
            }
        }

        return dp[SR][SC];
    }

    public static int MazePath_Set()
    {
        int sr=0;
        int sc=0;
        int dr=4;
        int dc=4;
        int[][] dp=new int[dr+1][dc+1];
        int[][] dir={{1,0},{1,1},{0,1}};
    }

    public static int goldMine_Memo(int sr,int sc,int er,int ec,int[][] mat,int[][]dir)
    {
        if(sc==ec)
        {
            return dp[sr][sc]=mat[sr][sc];
        }

        if(dp[sr][sc]!=-1)
        {
            return dp[sr][sc];
        }

        int maxGold=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length)
            {
                maxGold=Math.max(maxGold,goldMine_Memo(sr,sc,er,ec,mat,dir,dp)+mat[sr][sc]);
            }
        }

        return maxGold;
    }

    public static int goldMine_Memo_(int n,int m,int[][] mat)
    {
        int[][] dir={{1,1},{-1,1},{0,1}};
        int[][] dp=new int[n][m];

        for(int[] d:dir)
        {
             Arrays.fill(dp,-1);
        }
       
        int maxGold=0;
        for(int r=0;r<n;r++)
        {
            maxGold=Math.max(maxGold,goldMine_Memo(r,0,n-1,m-1,mat,dir,dp));
        }
        return dp[sr][sc]=maxGold;
    }


    public static int goldMine_Tabu(int SR,int SC,int er,int ec,int[][]dir)
    {
        for(int sr=er;i>=0;i--)
        {
            for(int sc=ec;j>=0;j--)
            {
            if(sc==ec)
            {
                dp[sr][sc]=mat[sr][sc];
                continue;
            }


        int maxGold=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];

            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length)
            {
                maxGold=Math.max(maxGold,dp[r][c]+mat[sr][sc]);
            }
        }

        int maxGold=0;
        for(int r=0;r<n;r++)
        {
            maxGold=Math.max(maxGold,dp[r][0]);
        }
return maxGold;
      
            }
        }
    }

    
    // Leetcode -70
    public int climbingStairs_Memo(int n,int[] dp)
    {
        if(n<=1)
        {
           return dp[n]=1;
        }
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
        int ans=climbingStairs(n-1,dp)+climbingStairs(n-2,dp);
        
        return dp[n]=ans;
    }
    
    }
    public int climbStairs_Opti(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

    // 746

    public int minCost_memo(int n, int[] cost, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != 0)
            return dp[n];

        int minCost = Math.min(minCost_memo(n - 1, cost, dp), minCost_memo(n - 2, cost, dp));//n-1 means ki piche se start kr rhe hai 

        return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        return minCost_memo(n, cost, dp);
    }
                                // OR 

                                
    public int minCost(int[] cost,int n,int si,int[] dp)
    {
        if(n<=1)
        {
            return dp[n]=cost[n];
        }     
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
        int c=Math.min(minCost(cost,n-1,si,dp),minCost(cost,n-2,si,dp));
        
        if(n<cost.length)
        {
            c= c+cost[n];
        }
        
        return dp[n]=c;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
        int[] dp=new int[n+1];
        
        int a1=minCost(cost,n,0,dp);
        int a2=minCost(cost,n,1,dp);
        
        return Math.min(a1,a2);        
    }

    public int minCostClimbingStairs_Opti(int[] cost)
    {
        int a=cost[0];
        int b=cost[1];

        for(int n=2;n<=cost.length;n++)
        {
            int minCost=Math.min(a,b)+(n==cost.length?0:cost[n]);
            a=b;
            b=minCost;
        }

        return b;
    }

    // board Path
    public static int boardPath_memo(int sp, int ep, int[] dp) {
        if (sp == ep) {
            return dp[sp] = 1;
        }
        if (dp[sp] != 0)
            return dp[sp];

        int count = 0;
        for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
            count += boardPath_memo(sp + dice, ep, dp);
        }

        return dp[sp] = count;
    }

    public static int boardPath_tabu(int SP, int ep, int[] dp) {
        for (int sp = ep; sp >= SP; sp--) {
            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                count += dp[sp + dice];// boardPath_memo(sp + dice, ep, dp);
            }
            dp[sp] = count;
        }

        return dp[SP];
    }

    public static int boardPath_Opti(int n) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(1);
        for (int i = 2; i <= n; i++) {
            if (ll.size() <= 6)
                ll.addLast(ll.getLast() * 2);
            else
                ll.addLast(ll.getLast() * 2 - ll.removeFirst());
        }

        return ll.getLast();
    }


    public static void board_path() {
        int sp = 0, ep = 20;
        int[] dp = new int[ep + 1];
        System.out.println(boardPath_tabu(sp, ep, dp));
        display(dp);
    }

//solving in terms of idx

    public static int Decode_Memo(String s,int n,int[] dp)
    {
        if(n==0)
        {
            return dp[n]=1;
        }

        if(dp[n-1]!=-1)
        {
            return dp[n];
        }

        int count=0;
        if(s.charAt(n-1)>'0')
        {
            count+=Decode_Memo(s,n-1,dp);
        }

        if(n>1)
        {
            int num=(str.charAt(n-2)-'0')*10+str.charAt(n-1)-'0';
            if(num<=26 && num>=10)
            {
                count+=Decode_Memo(s,n-2,dp);
            }
        }
        return dp[n]=count;
    }

//solving from front    
 public static int Decode_Memo2(String s,int idx,int[] dp)
    {
        if(idx==s.length())
        {
            return dp[idx]=1;
        }

        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
         
         if(s.charAt(idx)=='0')
         {
             return dp[idx]= 0;
         }

        int count=0;
            count+=Decode_Memo2(s,idx+1,dp);

        if(idx<s.length()-1)
        {
            int num=(s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0';
            if(num<=26)
            {
                count+=Decode_Memo2(s,idx+2,dp);
            }
        }
        return dp[idx]=count;
    }

    public static int Decode(String s)
    {
        int n=s.length();
        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);

        return Decode_Memo(s,n,dp);
    }

public static int Decode_Tabu(String s,int IDX,int[] dp)
{
    for(int idx=s.length();idx>=IDX;idx++)
    {
        if(idx==s.length())
        {
            dp[idx]=1;
            continue;
        }

         if(s.charAt(idx)=='0')
         {
             dp[idx]= 0
             continue;
         }

        int count=0;

            count+=dp[idx+1];

        if(idx<s.length()-1)
        {
            int num=(s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0';
            if(num<=26)
            {
                count+=dp[idx+2];
            }
        }
        dp[idx]=count;
    }
    return dp[IDX];   
}

 
public long numDecodings_withStar(String str,int idx,long[] dp)
    {
        if(idx==str.length())
        {
            return dp[idx]=1;
        }
        
         if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        
        if(str.charAt(idx)=='0')
        {
            return dp[idx]=0;
        }
        
      
      long count=0;
         int mod = (int) 1e9 + 7;
        char ch1=str.charAt(idx);
        
        if(ch1=='*')
        {
            count=(count+9*numDecodings_withStar(str,idx+1,dp))%mod;
            
            if(idx<str.length()-1)
            {
                
                if(str.charAt(idx+1)=='*')
                {
                    count=(count+15*numDecodings_withStar(str,idx+2,dp))%mod;
                }
            
            else if(str.charAt(idx+1)>='0' && str.charAt(idx+1)<='6')
            {
                    count=(count+2*numDecodings_withStar(str,idx+2,dp))%mod;
                }
                
                else if(str.charAt(idx+1)>='7')
                {
                    count=(count+1*numDecodings_withStar(str,idx+2,dp))%mod;
                }
            } 
                
            }
        
        else{
            
            count=(count+numDecodings_withStar(str,idx+1,dp))%mod;
            
            if(idx<str.length()-1){
                  
            if(str.charAt(idx+1)!='*'){
                int num=(str.charAt(idx)-'0')*10+(str.charAt(idx+1)-'0');
                if(num<=26)
                {
                    count=(count+numDecodings_withStar(str,idx+2,dp))%mod;
                }
            }
            else
            {
                if(ch1=='1')
                {
                    count=(count+9*numDecodings_withStar(str,idx+2,dp))%mod;
                }
                
                else if(ch1=='2')
                {
                    count=(count+6*numDecodings_withStar(str,idx+2,dp))%mod;
                }
            }
          
            }
        }
        
        return dp[idx]= count;      
    }
    
public static int numDecodings_withStarTabu(String str,int IDX)
{
    for(int i=str.length();i>=IDX;i--)
    {
         if(idx==str.length())
        {
            dp[idx]=1;
            continue;
        }
   
        if(str.charAt(idx)=='0')
        {
            dp[idx]=0;
             continue;
        }
        
      
         long count=0;
         int mod = (int) 1e9 + 7;
        char ch1=str.charAt(idx);
        
        if(ch1=='*')
        {
            count=(count+9*dp[idx+1])%mod;
            
            if(idx<str.length()-1)
            {
                
                if(str.charAt(idx+1)=='*')
                {
                    count=(count+15*dp[idx+2])%mod;
                }
            
            else if(str.charAt(idx+1)>='0' && str.charAt(idx+1)<='6')
            {
                    count=(count+2*dp[idx+2])%mod;
                }
                
                else if(str.charAt(idx+1)>='7')
                {
                    count=(count+1*dp[idx+2])%mod;
                }
            } 
                
            }
        
        else{
            
            count=(count+dp[idx+1])%mod;
            
            if(idx<str.length()-1){
                  
            if(str.charAt(idx+1)!='*'){
                int num=(str.charAt(idx)-'0')*10+(str.charAt(idx+1)-'0');
                if(num<=26)
                {
                    count=(count+dp[idx+2])%mod;
                }
            }
            else
            {
                if(ch1=='1')
                {
                    count=(count+9*dp[idx+2])%mod;
                }
                
                else if(ch1=='2')
                {
                    count=(count+6*dp[idx+2])%mod;
                }
            }
          
            }
        }
    dp[idx]= count;  
    }
}

    return dp[IDX];
}

//https://www.geeksforgeeks.org/friends-pairing-problem/

public static long friendsPairing(int n,long[] dp)
{

    if(n<=1)
    {
        return 1;
    }

    if(dp[n]!=0)
    {
        return dp[n];
    }

    int mod=(int)1e9+7;

    long single=friendsPairing(n-1,dp);

    long pairUp=friendsPairing(n-2,dp)*(n-1);

    return dp[n]=(single+pairUp)%mod;
}

public static long friendsPairing_Tabu(int N,long[] dp)
{
    for(int n=0;n<=N;n++)
    {

    if(n<=1)
    {
        dp[n]=1;
        continue;
    }


    int mod=(int)1e9+7;

    long single=dp[n-1];

    long pairUp=dp[n-2]*(n-1);

    dp[n]=(single+pairUp % mod)%mod;
    }
    
    return dp[N];
}
    
public static long friendsPairing_Tabu(int N,long[] dp)
{
    for(int n=0;n<=N;n++)
    {

    if(n<=1)
    {
        dp[n]=1;
        continue;
    }


    int mod=(int)1e9+7;

    long single=dp[n-1];

    long pairUp=dp[n-2]*(n-1);

    dp[n]=(single+pairUp % mod)%mod;
    }
    
    return dp[N];
}
    
    public static long friendsPairing_Tabu(int N,long[] dp)
{
    for(int n=0;n<=N;n++)
    {

    if(n<=1)
    {
        dp[n]=1;
        continue;
    }


    int mod=(int)1e9+7;

    long single=dp[n-1];

    long pairUp=dp[n-2]*(n-1);

    dp[n]=(single+pairUp % mod)%mod;
    }
    
    return dp[N];
}

//https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/

public static int divideInKgroups(int n,int k,int[][] dp)
{
    if(n==k || k==1)
    {
        return dp[n][k]=1;
    }


    if(dp[n][k]!=-1)
    {
        return dp[n][k];
    }
    int ownSet=divideInKgroups(n-1,k-1,dp);
    int PartOfSet=divideInKgroups(n-1,k,dp)*k;

    int ans=ownSet+PartOfSet;

    return dp[n][k]=ans;
}

public static int divideInKgroups_Tabu(int n,int k)//Tabu is better then memo in this ques as no of calls are reduced here
{
    for(int n=1;n<=N;n++)//n ==0 and k==0 pe koi way ni h so loop 1 se chlayege 
    {
        for(int k=1;k<=K;k++)
        {
            if(n==k || k==1)
            {
                dp[n][k]=1;
                continue;
            }

            if(k>n) // jb k>n ho then answer nhi aa skta so return 0
            {
                dp[n][k]=0;
                continue;
            }

            int ownSet=dp[n-1][k-1];
            int PartOfSet=dp[n-1][k]*k;

            dp[n][k]=ownSet+PartOfSet;
        }
    }

    return dp[N][K];
}


public static void divideInKgroups()
{
    int n=24,k=5;
    int[][] dp=new int[n+1][k+1];
    for(int[] d:dp)
    {
        Arrays.fill(d,-1);
    }
   System.out.println(divideInKgroups(n,k,dp));

}
    public static void main(String[] args)
    {
        divideInKgroups();
    }



 
}