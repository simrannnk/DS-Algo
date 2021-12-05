import java.util.Scanner;

public static void printDecreasing(int n)
{
    if (n == 0)
        return;

    System.out.println(n);
    printDecreasing(n - 1);
}

public static void printIncreasing(int n)
{
    if (n == 0)
        return;

    printIncreasing(n - 1);
    System.out.println(n);
}

public static void printIncDec(int n)
{
    if (n == 0)
        return;
     System.out.println(n);
    printIncDec(n - 1);
    System.out.println(n);
}

public static void printIncDec(int n)
{
    if (n == 0)
        return;
    if (n % 2 != 0)
        System.out.println(n);
    printIncDec(n - 1);
    if (n % 2 == 0)
        System.out.println(n);
}

public static int factorial(int n)
{
    return n == 0 ? 1 : n * factorial(n - 1);
}

public static int factorial(int n)
{
    int recAns = 1;
    if (n > 0)
        recAns = n * factorial(n - 1);

    return recAns;
}

public static int power(int a, int b)
{
    return b == 0 ? 1 : a * power(a, b - 1);
}

public static int powerBtr(int a, int b)
{
    if (b == 0)
        return 1;
    int smallAns = powerBtr(a, b / 2);
    smallAns *= smallAns;
    return b % 2 == 0 ? smallAns : smallAns * a;
}

public static int powerBtr2(int a, int b)
{
    if (b == 0)
        return 1;
    int smallAns = powerBtr2(a, b / 2) * powerBtr2(a, b / 2);
    return b % 2 == 0 ? smallAns : smallAns * a;
}

public static int fibo(int n)
{
    if (n <= 1)
        return n;

    return fibo(n - 1) + fibo(n - 2);
}

public static int tribonacci(int n)
{
    if (n <= 2)
        return n == 2 ? 1 : n;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
}

// Recursion With Array

public static void display(int[] arr, int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    System.out.println(arr[idx]);
    display(arr, idx + 1, n);
}

public static void reverseDisplay(int[] arr, int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    reverseDisplay(arr, idx + 1, n);
    cout << arr[idx] << endl;
}

public static int maxOfArray(int[] arr, int idx, int n)
{
    if (idx == n)
        return -1e9;

    return max(arr[idx], maxOfArray(arr, idx + 1, n));
}

public static int firstIndex(int[] arr, int idx, int x, int n)
{
    if (idx == n)
        return -1;

    if (arr[idx] == x)
        return idx;
    return firstIndex(arr, idx + 1, x, n);
}

public static int lastIndex(int[] arr, int idx, int x, int n)
{
    if (idx == -1)
        return -1;

    if (arr[idx] == x)
        return idx;

    return lastIndex(arr, idx - 1, x, n);
}

public static int[] allIndices(int[] arr,int idx,int x,int fsf)
{
    if(idx==arr.length)
    {
        int[] base =new int[fsf];
        return base;
    }

    if(arr[idx]==x)
    {
        fsf++;
    }

int[] ans=allIndices(arr,idx+1,x,fsf);
    if(arr[idx]==x)
    {
        ans[fsf-1]=idx;
    }
return ans;

}

public static int sumOfDigits(String str,int idx)
{

    if(idx==str.length)
    {
        return 0;
    }

    int recAns=sumOfDigits(str,idx+1);
    return recAns+(str.charAt(0)-'0');
}

public static long StringToNumber(String str,int idx,long pow)
{
    if(idx==-1)
    {
        return 0;
    }
    long recAns=StringToNumber(str,idx-1,pow*10);
    return recAns+(str.charAt(idx)-'0')*pow;   
}

public static boolean checkReverse(String str1,String str2,int idx1,int idx2)
{
    if(idx1==str1.length || idx2==-1)
    {
        return false;
    }

    if(str.charAt(idx1)!=str.charAt(idx2))
    {
        return false;
    }

    return checkReverse(str1,str2,idx1+1,idx2-1);
}

public static String seperateDuplicates(String str)// Faiht -> recursion hume bache hue string mai seperate duplicates krke
//de dega and we will check for first char of the given string
    {
        if(str.length()==1)
        {
            return str;
        }
        char ch=str.charAt(0);
        
        String ros=str.substring(1);
        String recAns=seperateDuplicates(ros);
        
        if(ch==recAns.charAt(0))
        {
            return ch+"*"+recAns;
        }
        
        else{
            return ch+recAns;
        }
    }

public static void seperateDuplicates_wayUp(String str,int idx,String ans)
{
    if(idx==str.length()-1)
    {
        System.out.println(ans+str.charAt(str.length-1));
        return;
    }

char ch=str.charAt(idx);
if(ch==str.charAt(idx+1))
{
    seperateDuplicates_wayUp(str,idx+1,ans+char+"*");
}   
    else{
        seperateDuplicates_wayUp(str,idx+1,ans+ch);
    }
}

public static String removeDuplicates(String str)
{
    if(str.length()==1)
    {
        return str;
    }
    char ch=str.charAt(0);
    String ros=str.substring(1);
    String recAns=removeDuplicates(ros);

    if(ch==ros.charAt(0))
    {
        return recAns;
    }

    else{
        return ch+recAns;
    }
}

public static void removeDuplicates_WayUp(String str,int idx,String ans)
{
    if(idx==str.length()-1)
    {
        System.out.println(ans+str.charAt(idx));

    }

    char ch=str.charAt(idx);
    if(ch==str.charAt(idx+1))
    {
        removeDuplicates_WayUp(str,idx+1,ans);
    }

    else{
        removeDuplicates_WayUp(str,idx+1,ans+ch);
    }
}

https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-22movecharacters/problem

public static void moveCharacters(String str,int idx,String ans1,String ans2,char movech)
{

    if(idx==str.length())
    {
        System.out.println(ans1+ans2);
        return;
    }

    char ch=str.charAt(idx);

    if(ch==movech)
    {
        moveCharacters(str,idx+1,ans1,ans2+ch,movech);
    }

    else{
        moveCharacters(str,idx+1,ans1+ch,ans2,movech);
    }
}

public static String moveCharacters(String str,char movech,int idx)
/*Faith-> bache hue string mai move char at last ho jayege and i will check for the first character 
firstchar== movechar ? then move at last else first pe hi rehne do*/
{
    if(idx==str.length()-1)
    {
        return str;
    }

    char ch=str.charAt(idx);
    String recString=moveCharacters(str,movech,idx+1);

    if(ch==movech)
    {
        return recAns+ch;
    }

    else{
        return ch+recAns;
    }

}
   public static void main(String[] args) {
        
        String str=scn.next();
        char ch=scn.next().charAt(0);
        int idx=scn.nextInt();
        System.out.println(moveCharacters(str,0,ch).charAt(idx));
        moveCharacters(str,0,"","",ch);
    }

public static int countAllHi(String str,int idx)
{
    if(idx>=str.length()-1)
    {
        return 0;
    }
    String s=str.substring(idx,idx+2);
    if(s.equals("hi"))
    {
        return countAllHi(str,idx+2)+1;
    }

    else{
        return countAllHi(str,idx+1);
    }
}

public static void RemoveAllHi(String str, int idx,String ans)
{
    if(idx>=str.length()-1)
    {
        if(idx==str.length()-1)
        {
            ans=ans+str.charAt(idx);
        }
            System.out.println(ans);
            return;
    }

    String s=str.substring(idx,idx+2);
    if(s.equals("hi"))
    {
        RemoveAllHi(str,idx+2,ans);
    }

    else{
        RemoveAllHi(str,idx+1,ans+str.charAt(idx));
    }


public static String RemoveAllHi(String str,int idx)
{
    if(idx>=str.length()-1)
    {
        if(idx==str.length()-1)
        {
            return str.charAt(idx)+" ";
        }

        return "";
    }
    String s=str.substring(idx,idx+2);
    if(s.equals("hi"))
    {
        return RemoveAllHi(str,idx+2);
    }

    else{
        return str.charAt(idx)+RemoveAllHi(str,idx+1);
    }

}


public static String ReplaceHi(String str,int idx)
{
    if(idx>=str.length()-1)
    {
        if(idx==str.length()-1)
        {
            return str.charAt(idx)+" ";
        }

        return "";
    }
    String s=str.substring(idx,idx+2);
    if(s.equals("hi"))
    {
        return "pep"+ReplaceHi(str,idx+2);
    }

    else{
        return str.charAt(idx)+ReplaceHi(str,idx+1);
    }
}


}
