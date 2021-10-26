public class l003_LIS
{
    //Longest Increasing Subsequence - leetcode 300
    //Left to Right

    public static int[] LIS_LR(int[] nums)
    {
        int n=nums.length;
int[] dp=new int[nums.length];
        int maxLen=0;
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

             maxLen=Math.max(maxLen,dp[i]);
        }
       return dp;
    }

//right ot left-> right to left LIS is same as LDS 
public static int[] LIS_RL(int[] nums)
{
    int n=nums.length;
int[] dp=new int[nums.length];
        int maxLen=0;
        for(int i=n-1;i>=0;i--)
        {
            dp[i]=1;
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

             maxLen=Math.max(maxLen,dp[i]);
        }
       return dp;
}

//https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
public static int BitonicSubsequence(int[] nums)
{
    int maxLen=0;
    int n=nums.length;
    int[] LIS=LIS_LR(nums);
    int[] LDS=LIS_RL(nums);

    for(int i=0;i<n;i++)
    {
        int ans=Math.max(maxLen,LIS[i]+LDS[i]-1);
    }
    return ans;
}

//======================================================================================

//LDS:Longest Decreasing Subsequence
//left to right
public static int[] LDS_LR(int[] nums)
    {
        int maxLen=0;
        int n=nums.length;
        int[] dp=new int[n]''
        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]<nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            maxLen=Math.max(maxLen,dp[i]);
        }

        return dp;
    }
//LDS right to left == LIS
public static int[] LDS_RL(int[] nums)
{
    int maxLen=0;
        int n=nums.length;
        int[] dp=new int[n]''
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(nums[i]<nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            maxLen=Math.max(maxLen,dp[i]);
        }

        return dp;
}

public static int[] BitonicSubsequence_02(int[] nums)
{
    int[] LDS=LDS_LR(nums);
    int[] LIS=LDS_RL(nums);
   
        int n = nums.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
        }

        return maxLen;
}
//===================================================================================

//https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    public static int miximumOverlappingBridges(int[][] points)
    {
        Arrays.sort(points,(a,b)->{
            return a[0]-b[0];
        });

        int maxLen=0;
        int n=points.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(points[i][1]>points[j][1])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

 //Ques->  minimum Number of deletion to be performed to make array sorted (array
    // contain -1e7 <= ele <= 1e7)

    public static int minimumDeletions(int[] arr,int n)
    {
      
        int n=nums.length;
        int[] dp=new int[nums.length];
        int maxLen=0;
        for(int i=0;i<n;i++)
        {
            dp[i]=1;;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>=nums[j])//here put a = wla check bcoz 2,2,2,2,1 ans was 6-1=5deletions which is wrong ans should be 5-4=1deletion
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

             maxLen=Math.max(maxLen,dp[i]);
        }
       return n-maxLen;
    }

//https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1#
	public int maxSumIS(int arr[], int n)  
	{ 
    int[] dp=new int[arr.length];
        int maxSum=0;
        for(int i=0;i<n;i++)
        {
            dp[i]=arr[i];
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }

             maxSum=Math.max(maxSum,dp[i]);
        }
       return maxSum;
    }

//https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence1857/1

public static int[] LIS_LR(int[] arr)
    {
        int maxSum1=0;
        int n=arr.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
        {
             dp[i]=arr[i];
            for(int j=i-1;j>=0 ;j--)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            
            maxSum1=Math.max(maxSum1,dp[i]);
        }

        return dp;
    }
    
    public static int[] LIS_RL(int[] arr)
    {
        int maxSum2=0;
        int n=arr.length;
        int[] dp=new int[n];
        for(int i=n-1;i>=0;i--)
        {
             dp[i]=arr[i];
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                dp[i]=Math.max(dp[i],dp[j]+arr[i]);
            }
            
        }
        
        maxSum2=Math.max(maxSum2,dp[i]);
        }
        
        return dp;
    }
    
    public static int maxSumBS(int arr[], int n)
    {
        int maxSum=0;
        int[] LIS=LIS_LR(arr);
        int[] LDS=LIS_RL(arr);
        
    for(int i=0;i<n;i++)
    {
        maxSum=Math.max(maxSum,LIS[i]+LDS[i]-arr[i]);
    }
        
        return maxSum;
    }

     public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b)->{
           return a[0]-b[0]; 
        });
    
        int n=envelopes.length;
        int[] dp=new int[n];
        int maxLen=0;
        
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            for(int j=i-1;j>=0;j--)
            {  
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);      
        }
        return maxLen;
    }

        int LIS_Rec(int n,int[] a,int index,int[] dp)
    {
        if(dp[index]!=0)
        {
            return dp[index];
        }
        int maxLen=1;
        for(int i=index-1;i>=0;i--)
        {
            if(a[index]>a[i])
            {
                Math.max(maxLen,LIS_Rec(n,a,i,dp)+1);
            }
        }       
        return dp[index]=maxLen;
    }
    
    int LIS_rec(int n, int a[])
    {
       int[] dp=new int[n];
       int maxLen=1;
       for(int i=0;i<n;i++)
       {
           return Math.max(maxLen,LIS_Rec(n,a,i,dp));
       }
       return maxLen;
    }

    //leetcode 673
    public static int numberOfLIS(int[] nums,int[] len,int[] count)
    {
        int n=nums.length;
        int maxLen=0;
        int maxCount=0;
        for(int i=0;i<n;i++)
        {
            len[i]=1;
            count[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    if(len[i]<len[j]+1)
                    {
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    }

                    else if(len[i]==len[j]+1)
                    {
                        count[i]=count[i]+count[j];
                    }
                }
            }
            if(len[i]>maxLen)
            {
                maxLen=len[i];
                maxCount=count[i];
            }

            else if(len[i]==maxLen)
            {
                maxCount=maxCount+count[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args)
    {
        
    }
}