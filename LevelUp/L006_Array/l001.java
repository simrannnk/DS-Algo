public class l001{

//Leetcode- 925
    public boolean isLongPressedName(String name, String typed) {

        if(name.length()>typed.length())
        {
            return false;
        }

        if(name[0]!=typed[0])
        {
            return false;
        }

        int i=0;
        int j=0;
        while(i<name.length() && j<typed.length())
        {
            if(name.charAt(i)==typed.charAt(j))
            {
                i++;
                j++;
            }

            else {
                if(name.charAt(i-1)==typed.charAt(j))
                {
                    j++;
                }

                else{
                    return false;
                }
            }
        }

        while(j<typed.length())
        {
            if(name.charAt(i-1)!=typed.charAt(j))
            {
                return false;
            }
            j++;
        }

        return i==name.length();
    }

//leetcode 11
    public int maxArea(int[] height) {
         int i=0;
        int j=height.length-1;int maxWater=0;
        while(i<j){
            int length=j-i;
            int h=Math.min(height[i],height[j]);
            int water=length*h;
            maxWater=Math.max(water,maxWater);
        
        if(height[i]<height[j])
        {
            i++;
        }
        else{
            j--;
        }
        }
        return maxWater;
        
    }

    public static int sortSquares(int[] nums)
    {
        int n=nums.length;
        int[] res=new int[n];

        int i=0;
        int j=n-1;
        int k=n-1;

        
    }

    public static void main(String[] args)
    {

    }
}