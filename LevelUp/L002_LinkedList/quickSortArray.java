import java.util.Random;
public class quickSortArray{

public static Random rand=new Random();
  
    public static void swap(int[] arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static int segregate(int[] arr,int sp,int ep,int pivotIdx){

        swap(arr,pivotIdx,ep);

        int ptr=sp-1;
        int itr=sp;

        while(itr<=ep)
        {
            if(arr[itr]<=arr[pivotIdx])
            {
                ptr++;
                swap(arr,ptr,itr);
                itr++;
            }

            else{
                itr++;
            }
        }

        return ptr;
    }

    public static void quickSortArray(int[] arr,int si,int ei)
    {

        if(si>ei)
        {
            return;
        }

        // int pivotIdx=rand.nextInt(ei-si+1)+si;//random index as pivot 
         int pivotIdx=ei; //Last index as pivot
        pivotIdx=segregate(arr,si,ei,pivotIdx);

        boolean flag=true;
        for(int i=si+1;i<=ei;i++)
        {
            if(arr[si-1]>arr[si])
            {
                flag=false;
                break;
            }
        }
        
        if(flag)
        {
            return;
        }

        quickSortArray(arr,si,pivotIdx-1);
        quickSortArray(arr,pivotIdx+1,ei);

    }

    public static void main(String[] args){

        int[] arr={9,5,7,2,6,4};
        int n=arr.length-1;
        quickSortArray(arr,0,n);
        for(int ele:arr)
        {
            System.out.println(ele);
        }

    }
}