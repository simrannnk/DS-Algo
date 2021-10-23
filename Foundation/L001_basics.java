import java.util.Scanner;
public class L001_basics
{
public static Scanner scn=new Scanner(System.in);

/*public static void findElement(int[][] arr,int data)
{
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(arr[i][j]==data)
            {
                int p=i;
                int q=j;
                System.out.println(p+","+q);
            }
        }
    }
}*/

public static void equiSet(int[] arr,int idx,int sum1,int sum2,String set1,String set2)
{
    if(sum1==sum2)
    {
        System.out.println(set1 +"=" + set2);
        return;
    }
 
    equiSet(arr,idx,sum1+arr[idx],sum2,set1+arr[idx],set2);
    equiSet(arr,idx,sum1,sum2+arr[idx],set1,set2+arr[idx]);
    return;
}


public static void main(String[] args)
{
    /*int n=scn.nextInt();
    int[][] arr = new int[n][n];
    int data = scn.nextInt();
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr[i][j]=scn.nextInt();
        }
    }
    findElement(arr,data);*/
int[] arr={ 20,30,10,60,50,70,90,110};
equiSet(arr,0,0,0,"","");    
}
}