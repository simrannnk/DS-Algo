public class l002_StringSet{

516
    public int longestPalindromeSubseq(String s,int i ,int j,int[][] dp)
    {
        if(i>=j)
        {
            return dp[i][j]=(i==j)?1:0;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int count=0;
        if(s.charAt(i)==s.charAt(j))
        {
            return dp[i][j]=longestPalindromeSubseq(s,i+1,j-1,dp)+2;
        }
        
        else{
            int ans=Math.max(longestPalindromeSubseq(s,i+1,j,dp),longestPalindromeSubseq(s,i,j-1,dp));
            return dp[i][j]=ans;
        }   
    }

    public static int longestPalindromeSubseq_Tabu(String s,int I,int J,int[][] dp)
    {
        int n=s.length();
        for(int jump=0;jump<n;jump++)
        {
            for(int i=0,j=jump;j<n;i++,j++)
            {
                if(i>=j)
        {
           dp[i][j]=(i==j)?1:0;
           continue;
        }

        int count=0;
        if(s.charAt(i)==s.charAt(j))
        {
           dp[i][j]=dp[i+1][j-1]+2;
        }
        
        else{
            int ans=Math.max(dp[i+1][j],dp[i][j-1]);
            dp[i][j]=ans;
        }   
            }
        }

        return dp[I][J];
    }

public static String longestPalindromeSubseq_RevEng(String s,int si,int ei,int[][] dp)
{ 
    if(si>=ei)
    {
        return (si==ei)?s.charAt(si)+"":"";
    }

    if(s.charAt(si)==s.charAt(ei))
    {
        return s.charAt(si)+longestPalindromeSubseq_RevEng(s,si+1,ei-1,dp)+s.charAt(ei);
    }

    else if(dp[si+1][ei]>dp[si][ei-1])
    {
        return longestPalindromeSubseq_RevEng(s,si+1,ei,dp);
    }

    else{
        return longestPalindromeSubseq_RevEng(s,si,ei-1,dp);
    }
}

//1143
public static int longestCommonSubseq(String str1,String str2,int n,int m,int[][] dp)
{
    if(n==0 || m==0)
    {
        return dp[n][m]=0;
    }

    if(dp[n][m]!=-1)
    {
        return dp[n][m];
    }
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        return dp[n][m]=longestCommonSubseq(str1,str2,n-1,m-1,dp)+1;
    }

    else{
        return dp[n][m]=Math.max(longestCommonSubseq(str1,str2,n-1,m,dp),longestCommonSubseq(str1,str2,n,m-1,dp));
    }
}

public static int longestCommonSubseq_Tabu(String str1,String str2,int N,int M)
{
    for(int n=0;n<=N;n++)
    {
        for(int m=0;m<=M;m++)
        {
            if(n==0 || m==0)
            {
                dp[n][m]=0;
                continue;
            }
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        dp[n][m]=ldp[n-1][m-1]+1;      
    }

    else{
       dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
    }

        }
    }
    return dp[N][M];
}
public static int longestCommonSubseq(String str1,String str2)
{
    int n=str1.length();
    int m=str2.length();
    int[][] dp=new int[n][m];
    for(int[] d:dp)
    {
        Arrays.fill(d,-1);
    }
    return longestCommonSubseq(str1,str2,n,m,dp);
}

public static String longestCommonSubseq_RevEng(String str1,String str2,int n, int m, int[][] dp)
{
    if(n==0 || m==0)
    {
        return "";
    }
    
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        return longestCommonSubseq_RevEng(str1,str2,n-1,m-1,dp)+str1.charAt(n-1);
    }

    else if(dp[n-1][m]>dp[n][m-1])
    {
        return longestCommonSubseq_RevEng(str1,str2,n-1,m,dp);
    }
    else{
        return longestCommonSubseq_RevEng(str1,str2,n,m-1,dp);
    }
}

public static String longestPalindromicSubstring(String str)
{

    int n=str.length();
    boolean[][] dp=new boolean[n][n];

    int si=0;
    int maxLen=0;
    for(int gap=0;gap<n;gap++)
    {
        for(int i=0,j=gap;j<n;i++,j++)
        {
            if(gap==0)
            {
                dp[i][j]=true;
            }

            else if(gap==1 && str.charAt(i)==str.charAt(j))
            {
                dp[i][j]=true;
            }

            else
            {
                if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1])
                {
                    dp[i][j]=true;
                }
            }

            if(dp[i][j] && j-i+1>maxLen)
            {
                maxLen=j-i+1;
                si=i;
            }
        }
    }

    return str.substring(si,si+maxLen);
}

//1458

public static int maximum(int... arr)
{
    int max=arr[0];
    for(int ele:arr)
    {
       max=Math.max(max,ele);
    }

    return max;
}
public static int maxDotProduct(int[] nums1,int nums2[],int n,int m)
{
    if(n==0 || m==0)
    {
        return dp[n][m]=-(int)1e8;
    }

    if(dp[n][m]!=-(int)1e9)
    {
        return dp[n][m];
    }
    int val=nums1[n-1]*nums2[m-1];
    int acceptBoth=maxDotProduct(nums1,nums2,n-1,m-1,dp)+val;
    int ans1=maxDotProduct(nums1,nums2,n-1,m,dp);
    int ans2=maxDotProduct(nums1,nums2,n,m-1,dp);

    return dp[n][m]=maximum(val,acceptBoth,ans1,ans2);
}

//1035
 public int maxUncrossedLines(int[] nums1, int[] nums2,int n,int m,int[][] dp) { //using longest common subsequence

        if(n==0 || m==0)
        {
            return dp[n][m]=0;
        }

        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }

        if(nums1[n-1]==nums2[m-1])
        {
            return dp[n][m]=maxUncrossedLines(nums1,nums2,n-1,m-1,dp)+1;
        }

        else{
            return dp[n][m]=Math.max(maxUncrossedLines(nums1,nums2,n-1,m,dp),maxUncrossedLines(nums1,nums2,n,m-1,dp));
        }    
}

//72
public static int editDistance(String word1, String word2, int n,int m,int[][] dp)
{
    if(n==0)
    {
        return dp[n][m]=m;//agr word1 ki length 0 ho jaye then to make it word2 we will perform m inserts in word1
    }

    else if(m==0)
    {
        return dp[n][m]=n;//agr word2 ki length 0 ho jaye then to make it word1 we will perform n deletes in word1
    }
      if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        
    if(word1.charAt(n-1)==word2.charAt(m-1))
    {
        return dp[n][m]=editDistance(word1,word2,n-1,m-1,dp);
    }

    int insert=editDistance(word1,word2,n,m-1,dp);
    int delete=editDistance(word1,word2,n-1,m,dp);
    int replace=editDistance(word1,word2,n-1,m-1,dp);

    return dp[n][m]=Math.min(Math.min(insert,delete),replace)+1;//+1 bcoz kuch bhi kra ho ek operation to kra hi khud ko convert krne ke liye
}

//583
 public int minDistance(String word1,String word2,int n,int m,int[][] dp)
    {
        if(n==0)
        {
            return dp[n][m]=m;
        }
        
        else if(m==0)
        {
            return dp[n][m]=n;
        }
        
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        
        if(word1.charAt(n-1)==word2.charAt(m-1))
        {
            return dp[n][m]=minDistance(word1,word2,n-1,m-1,dp);
        }
        
        int deleteFirst=minDistance(word1,word2,n-1,m,dp);
        int deleteSecond=minDistance(word1,word2,n,m-1,dp);
        
        return dp[n][m]=Math.min(deleteFirst,deleteSecond)+1;   
    }
    
                                       //OR

public static int minDistance(String word1,String word2)
{
    int n=word1.length();
    int m=word2.length();

    int[][] dp=new int[n+1][m+1];
    for(int[] d:dp)
    {
        Arrays.fill(d,-1);
    }

    return n+m-2*longestCommonSubseq(word1,word2,n,m,dp);
}

//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
class Solution
{
    public static int longestCommonSubseq(String str1,String str2,int n,int m,int[][] dp)
{
    if(n==0 || m==0)
    {
        return dp[n][m]=0;
    }

    if(dp[n][m]!=-1)
    {
        return dp[n][m];
    }
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        return dp[n][m]=longestCommonSubseq(str1,str2,n-1,m-1,dp)+1;
    }

    else{
        return dp[n][m]=Math.max(longestCommonSubseq(str1,str2,n-1,m,dp),longestCommonSubseq(str1,str2,n,m-1,dp));
    }
}

	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n=str1.length();
	   int m=str2.length();
	   int[][] dp=new  int[n+1][m+1];
	   for(int[] d:dp)
	   {
	     Arrays.fill(d,-1);  
	   }
	   
	   return m+n-2*longestCommonSubseq(str1,str2,n,m,dp);  
	}}

//115
public static int numDistinct(String str1,String str2,int n,int m,int[][] dp)
{
    if(n<m || m==0)
    {
        return dp[n][m]=(m==0)?1:0;
    }
    if(dp[n][m]!=-1)
    {
        return dp[n][m];
    }
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        return dp[n][m]=numDistinct(str1,str2,n-1,m-1,dp)+numDistinct(str1,str2,n-1,m,dp);
    }

    else{
        return dp[n][m]=numDistinct(str1,str2,n-1,m,dp);
    }
}

public static int numDistinct_DP(String str1,String str2,int N,int M,int[][]dp)//Tabulation
{
    for(int n=0;n<=N,n++)
    {
        for(int m=0;m<=M,m++)
        {
            if(n<m || m==0)
        {
         dp[n][m]=(m==0)?1:0;
         continue;
        }
   
    if(str1.charAt(n-1)==str2.charAt(m-1))
    {
        dp[n][m]=dp[n-1][m-1]+dp[n-1][m];
    }

    else{
        dp[n][m]=dp[n-1][m];
    }
        }
    }
    return dp[N][M];
}

//https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/

public static int fun(String s)
{
    int emptyCount=1;
    long aCount=0;
    long bCount=0;
    long cCount=0;

    for(int i=0;i<n;i++)
    {
        if(str.charAt(i)=='a')1
        {
            aCount=aCount+(aCount+emptyCount);// notInclude  + Include (prev + self)
        }

        else if(str.charAt(i)=='b')
        {
            bCount=bCount+(bCount+aCount);// notInclude  + Include (prev + self)
        }

        else{
            cCount=cCount+(cCount+bCount);// notInclude  + Include (prev + self)
        }
    }

    return (int)(cCount%mod);
}

//https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1

//Count All Palindromic Subseq
public static long countPS(String s,int n,int i,int j,long[][] dp)
{
    int mod=(int)1e9+7;
    if(i>=j)
    {
        return dp[i][j]=(i==j)?1:0;
    }

    if(dp[i][j]!=-1)
    {
        return dp[i][j];
    }

    long common=countPS(s,n,i+1,j-1,dp)+1;
    long excludingFirst=countPS(s,n,i+1,j,dp);
    long excludingLast=countPS(s,n,i,j-1,dp);

    if(str.charAt(i)==str.charAt(j))
    {
        return dp[i][j]=(excludingFirst+excludingLast+1)%mod;
    }

    else{
        return dp[i][j]=(excludingFirst+excludingLast-common+mod)%mod;
    }
}

//since i and j are moving in opp direction thus using GAP STRATEGY
public static long countPS_Tabu(String s,int I,int J,long[][] dp)
{
    int n=s.length();
    for(int jump=0;jump<n;jump++)
    {
        for(int i=0,j=jump;j<n;j++,i++)
        {
             if(i>=j)
            {
                dp[i][j]=(i==j)?1:0;
                continue;
            }
            
    int mod=(int) 1e9+7;

    long common=dp[i+1][j-1];
    long excludingFirst=dp[i+1][j];
    long excludingLast=dp[i][j-1];

    if(s.charAt(i)==s.charAt(j))
    {
        dp[i][j]=(excludingLast+excludingFirst+1)%mod;
    }

    else{
        dp[i][j]=(excludingFirst+excludingLast-common+mod)%mod;
    }
        }
    }
    return dp[I][J];
}

//leetcode 44
    public static String removeStars(String str)
    {
        int n=str.length();
        if(str.length()==0)
        {
            return "";
        }
        StringBuilder sb=new StringBuilder();
        char ch=str.charAt(0);
        sb.append(ch);
        
        int i=1;
        while(i<n)
        {
            while(i<n && sb.charAt(sb.length()-1)=='*' && str.charAt(i)== '*')
            {
                i++;
            }            
            if(i<n)
            {
                sb.append(str.charAt(i));
                i++;
            }
        }    
        return sb.toString();
    }

public int isMatch(String s, String p,int n,int m,int[][] dp) {

    if(n==0 || m==0)
    {
        if(n==0 && m==0)
        {
            return dp[n][m]=1;
        }

        else if(m==1 && p.charAt(m-1)=='*')
        {
            return dp[n][m]=1;
        }

        else{
            return dp[n][m]=0;
        }
    }

    if(dp[n][m]!=-1)
    {
        return dp[n][m];
    }

    char ch1=s.charAt(n-1);
    char ch2=p.charAt(m-1);

    if(ch1==ch2 || ch2=='?')
    {
        return dp[n][m]=isMatch(s,p,n-1,m-1,dp);
    }

    else if(ch2=='*')
    {
        boolean res=false;
        res=res || isMatch(s,p,n-1,m,dp)==1;
        res=res || isMatch(s,p,n,m-1,dp)==1;

        if(res)
        {
            return dp[n][m]=1;
        }

        else{
            return dp[n][m]=0;
        }
    }

    else{
        return dp[n][m]=0;//non equal characters
    }
}

public static boolean isMatch(String s,String p)
{
     p=removeStars(p);
        int n=s.length();
        int m=p.length();
       int[][] dp=new int[n+1][m+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
         int ans=isMatch(s,p,n,m,dp);
    if(ans==1)
    {
        return true;
    }
    else
        return false;
    
}

//leetcode 132
public static int minCut_Memo(String s,int si,int[] dp, boolean[][] isPalindromedp)
{
    if(isPalindromedp[si][s.length()-1])
    {
        return dp[si]=0;
    }

    if(s.length()==1)
    {
        return dp[si]=0;
    }

    if(dp[si]!=-1)
    {
        return dp[si];
    }

    int minAns=(int)1e9;
    for(int cut=si;cut<s.length();cut++)
    {
        if(isPalindromedp[si][cut])
        {
            minAns=Math.min(minAns,minCut_Memo(s,cut+1,dp,isPalindromedp)+1);
        }
    }
    return dp[si]=minAns;
}

public int minCut(String s) {
    int n=s.length();
    boolean[][] isPalindromedp=new boolean[n][n];
    for(int gap=0;gap<n;gap++)
    {
        for(int i=0,j=gap;j<n;i++,j++)
        {
            if(gap==0)
            {
                 isPalindromedp[i][j]=true;
            }

            else if(gap==1 && s.charAt(i)==s.charAt(j))
            {
                 isPalindromedp[i][j]=true;
            }

            else{
                isPalindromedp[i][j]=s.charAt(i)==s.charAt(j) && isPalindromedp[i+1][j-1];
            }
        }
    }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return minCut_Memo(s,0,dp,isPalindromedp);
}

public static void main(String[] args)
    {
        String str1="abcde";
        String str2="ace";
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        System.out.println(longestCommonSubseq_RevEng(str1,str2,n,m,dp));
        
    }
}