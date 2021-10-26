
import java.util.*;
public class l004_TargetSet{

    public static int permutation_Memo(int[] arr,int tar,int[] dp)
    {
        int count=0;
        if(tar==0)
        {
            return dp[tar]=1;
        }
        if(dp[tar]!=-1)
        {
            return dp[tar];
        }
        for(int ele:arr)
        {
            if(tar-ele>=0)
            {
                count+=permutation_Memo(arr,target-ele,dp);
            }
        }
        return dp[tar]=count;
    }

    public static int permutation_Tabu(int[] arr,int TAR ,int[] dp)
    {
        for(int tar=0;tar<=TAR;tar++)
        {

        int count=0;
        if(tar==0)
        {
            dp[tar]=1;
            continue;
        }
       
        for(int ele:arr)
        {
            if(tar-ele>=0)
            {
                count+=dp[tar-ele];
            }
        }
         dp[tar]=count;

        }

        return dp[TAR];
    }

    public static int combination_Memo(int[] arr,int tar,int n,int[][] dp)
    {
        if(tar==0)
        {
            return dp[tar][n]=1;
        }

        if(dp[tar][n]!=-1)
        {
            return dp[tar][n];
        }
        int count = 0;
        for(int i=n-1;i>=0;i--)
        {
            if(tar-arr[i]>=0)
            {
                count+=combination_Memo(arr,tar-arr[i],i+1,dp);// i+1 isliye kyuki aage bhjena length tha and i index hai
            }
        }
        return dp[tar][n]=count;
    }

    public static int combination_Tabu(int[] arr,int TAR,int[] dp)//using 1d DP
    {
    
        int[] dp=new int[target+1];
        for(int ele:arr)
        {

            for(int tar=0;tar<=TAR;tar++)
            {
                if(tar==0)
                {
                    dp[tar]=1;
                    continue;
                }

                if(tar-ele>=0)
                {
                    dp[tar]+=dp[tar-ele];
                }
            }
        }
         return dp[TAR];
    }

    //Leetcode 518
class Solution {
    public int change(int Tar,int[] coins,int[] dp)
    {
        for(int ele:coins)
        {
             for(int tar=0;tar<=Tar;tar++)
            {
                 if(tar==0)
                 {
                     dp[tar]=1;
                     continue;
                 }
                  if(tar-ele>=0)
                  {
                      dp[tar]+=dp[tar-ele];
                  }
            }
        }
        return dp[Tar];
    }
    
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        return change(amount,coins,dp);
        
    }
}

//322 
    public int coinChange(int[] arr,int tar,int[] dp)
    {
        if(tar==0)
        {
            return dp[tar]=0;
        }
        
        if(dp[tar]!=(int)1e9)
        {
            return dp[tar];
        }
        
        int minCount=(int)1e8;
        for(int ele:arr)
        {
            if(tar-ele>=0)
            {
                minCount=Math.min(minCount,coinChange(arr,tar-ele,dp)+1);
            }
            
        }
        
        return dp[tar]=minCount>=(int)1e8 ? (int)1e8:minCount;
    }
    
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,(int)1e9);
        
        int ans=coinChange(coins,amount,dp);
        return ans>=(int)1e8?-1:ans;
        
    }

  public int coinChange_Tabu(int[] arr,int Tar,int[] dp)
{
    for(int tar=0;tar<=Tar;tar++)
    {
          if(tar==0)
            {
                dp[tar]=0;
                continue;
            }
         int minCount=(int)1e8;
        for(int ele:arr)
        {
            if(tar-ele>=0)
            {
                minCount=Math.min(minCount,dp[tar-ele]+1);
            }
        }   
        dp[tar]=minCount>=(int)1e8 ? (int)1e8 :minCount;
    }
    return dp[Tar];
}

//https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/

public static int EquationSolutions(int[] coeff,int Rhs,int[] dp)
{
    for(int ele:coeff)
    {
    for(int rhs=0;rhs<=Rhs;rhs++)
    {
        if(rhs==0)
        {
            dp[rhs]=1;
            continue;
        }

        if(rhs-ele>=0)
        {
            dp[rhs]+=dp[rhs-ele];
        }
    }
    }
    return dp[Rhs];
}

public static int EquationSolutions_Memo(int[] coeff,int n,int rhs,int[][] dp)
{
    int count=0;
    if(rhs==0)
    {
        return dp[rhs][n]=1;
    }

    if(dp[rhs][n]!=-1)
    {
        return dp[rhs][n];
    }

    for(int i=n-1;i>=0;i--)
    {
        if(rhs-coeff[i]>=0)
        {
            count+=EquationSolutions_Memo(coeff,i+1,rhs-coeff[i],dp);
        }
    }

    return dp[rhs][n]=count;
}
//Leetcode 377
 public int combination(int[] nums,int target, int[] dp)
    {
        int count=0;
        if(target==0)
        {
            return dp[target]=1;
        }
        
        if(dp[target]!=-1)
        {
            return dp[target];
        }
        
        for(int ele:nums)
        {
            if(target-ele>=0)
            {
                count+=combination(nums,target-ele,dp);
            }
        }
        return dp[target]=count;
    }

public static int TargetSum(int[] arr,int tar,int n,int[][] dp)
{
    if(tar==0 || n==0)
    {
        return dp[tar][n]=(tar==0 ? 1:0);
    }

    if(dp[tar][n]!=-1)
    {
        return dp[tar][n];
    }
    int count=0;
        if(tar-arr[n-1]>=0)
        {
            count+=TargetSum(arr,tar-arr[n-1],n-1,dp);
        }
        count+=TargetSum(arr,tar,n-1,dp);
    
    return dp[tar][n]=count;
}

public static int TargetSum_Tabu(int[] arr,int Tar,int N,int[][] dp)
{
    for(int n=0;n<=N;n++)
    {
        for(int tar=0;tar<=Tar;tar++)
        {
            if(tar==0 || n==0)
        {
            dp[tar][n]=(tar==0 ? 1:0);
            continue;
        }
        int count=0;
        if(tar-arr[n-1]>=0)
        {
            count+=dp[tar-arr[n-1]][n-1];
        }
        count+=dp[tar][n-1];
         dp[tar][n]=count;
        }
    }
    return dp[Tar][N];
}

      public static int TargetSum2(int[] arr,int tar,int n,int[][] dp)
    {
        if(tar==0)
        {
            return dp[tar][n]=1;
        }

        if(dp[tar][n]!=-1)
        {
            return dp[tar][n];
        }
        int count = 0;
        for(int i=n-1;i>=0;i--)
        {
            if(tar-arr[i]>=0)
            {
                count+=TargetSum2(arr,tar-arr[i],i+1,dp);// i+1 isliye kyuki aage bhjena length tha and i index hai
            }
        }
        return dp[tar][n]=count;
    }

    public static void coinSet()
    {
        int[] arr={2,3,5,7};
        int n=arr.length;
        int tar=10;
        int[][] dp=new int[tar][n];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        System.out.println(combination_Memo(arr,tar,0,dp));
    }

    public static void main(String[] args)
    {
        int[] arr={2,3,5,7};
        int n=arr.length;
        int tar=10;
        //int[] dp=new int[Rhs+1];
        int[][] dp=new int[tar+1][n+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        System.out.println(TargetSum2(arr,tar,n,dp));
    }
}