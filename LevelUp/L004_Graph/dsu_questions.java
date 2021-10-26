public class dsu_questions{

    public static int[] par;
    public static int[] size;
    
//Leetcode 695
    public static void MaxAreaIsland(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;

        par=new int[n*m];
        size=new int[n*m];
        int count=0;
        int maxSize=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1) // to get gcc
                {
                    count++;
                }
                par[i*m+j]=i*m+j;
                size[i*m+j]=1;
                
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int p1=findPar(i*m+j);// p1 ko hi humesha global parent bnao

                for(int d=0;d<dir.length;d++)
                {
                    int r=i+dir[d][0];
                    int c=j+dir[d][1];

                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1)
                    {
                        int p2=findPar(r*m+c);
                        if(p1!=p2)
                        {
                            par[p2]=p1;
                            size[p1]+=size[p2];
                            count--;//to get gcc
                            

                        }
                    }
                }
                maxSize=Math.max(maxSize,size[p1]);// size of component is the size of f=global parent i.e p1
            }

        }

    }
//Leetcode 1601-Lexographically smallest equivalent string

public static String lexoSmallest(String s1,String s2,String baseStr)
{
    par=new int[26];
    size=new int[26];

    for(int i=0;i<baseStr.length();i++)
    {
        par[i]=i;
        size[i]=1;
    }

    for(int i=0;i<s1.length();i++)
    {
        int p1=findPar(s1[i]-'a');
        int p2=findPar(s2[i]-'a');

        if(p1<p2)
        {
            par[p1]=p2;
            size[p2]+=size[p1];
        }

        else{
            par[p2]=p1;
            size[p1]+=size[p2];
        }
    }

    StringBuilder sb=new StringBuilder();
    for(int i=0;i<baseStr.length();i++)
    {
        char ch=(char)(findPar(baseStr.charAt(i)-'a')+'a');
        sb.append(ch);
    }
}

public boolean equationsPossible(String[] equations) {
    par =new int[26];
    for(String str:equations)
    {
        char ch0=str.charAt(0);
        char ch1=str.charAt(1);
        char ch3=str.charAt(3);
        

        int p1=findPar(ch0-'a');
        int p2=findPar(ch3-'a');

        if(ch1=='=' && p1!=p2)
        {
            par[p2]=p1;
        }

        else if(ch1=='!' && p1==p2)
        {
            return false;
        }
    
    }
    return true;
}

public static boolean isSimilar(String str1,String str2)
    {
        int n=str1.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
            {
                count++;
                if(count>2)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        
        int n=strs.length;
        par=new int[n];
        int group=n;
        
        for(int i=0;i<n;i++)
        {
            par[i]=i;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                
            
            if(isSimilar(strs[i],strs[j]))
            {
                
            int p1=findPar(i);
            int p2=findPar(j);
            if(p1!=p2)
            {
                par[p2]=p1;
                group--;
            }
                
            }
            }
        }
        return group;
        
    }
}
  
}