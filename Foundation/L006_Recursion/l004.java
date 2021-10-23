//Equi-Set
import java.util.*;

public class l004{

public static int equiSet(int[] arr,String set1,String set2,int idx,int sum1,int sum2)
{
    if(idx==arr.length)
    {
        if(sum1==sum2)
        {
            System.out.println(set1+"="+set2);
            return 1;
        }

        else{
            return 0;
        }
    }

    int count=0;
    count+=equiSet(arr,set1+arr[idx]+" ",set2,idx+1,sum1+arr[idx],sum2);
    count+=equiSet(arr,set1,set2+arr[idx]+" ",idx+1,sum1,sum2+arr[idx]);

    return count;

}

public static void main(String[]args)
{
    int[] arr={ 20, 30, 10, 60, 50, 70, 90, 110 };
    System.out.println(equiSet(arr," "," ",0,0,0));
    //System.out.println(equiSet(arr,arr[0]+" "," ",1,arr[0],0));// to remove the mirror image answers
}

}