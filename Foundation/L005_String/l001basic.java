public class l001basic{
 
    public static void test1(){
        String str = "szcszxvwesz";
        String str1 = str; // O(1)

        str += 'g'; // O(n)
        char ch = str.charAt(3);
    }

    public static void test2(){
        String str = "";
        for(int i=0;i < (int)1e6;i++){
            str += i;
        }

        System.out.println(str);
    }

    public static void test3(){
        StringBuilder sb = new StringBuilder();
        sb.append('d');  // O(1)
        StringBuilder sb1 = sb; // O(1)
        StringBuilder sb2 = new StringBuilder(sb); // O(n)

        char ch = sb.charAt(3);

        String str = sb.toString(); // O(n) 
        System.out.println(str);
    }

    
    public static void test4(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i < (int)1e6;i++){
            str.append(i);
        }

        System.out.println(str);
    }
// --------------------------------------------------------------------------

//String str="abaabbbcd"
//String compress1="a1b1a2b3c1d1"
//String compress2="a3b4c1d1"

public static String compress1(String str)//O(N)
    {
        if(str.length()==0)
        {
            return " ";
        }

        StringBuilder sb=new StringBuilder();

        char prevChar=str.charAt(0);
        int idx=1;


        while(idx<=str.length())
        {
            
            int count=1;
            while(idx<str.length() && prevChar==str.charAt(idx))
            {
                count++;
                prevChar=str.charAt(idx);
                idx++;
            }

            sb.append(prevChar);
            sb.append(count);

            if(idx==str.length())
            {
                break;
            }

            prevChar=str.charAt(idx);
            idx++;
        }

        return sb.toString();
    }

public static String compress2(String str)
{
    StringBuilder sb=new StringBuilder();
    int[] freqArray=new int[26];
    for(int i=0;i<str.length();i++)
    {
        char ch=str.charAt(i);
        freqArray[ch-'a']++;
    }

    for(int i=0;i<freqArray.length;i++)
    {
        if(freqArray[i]>0)
        {
             sb.append((char)(i + 'a'));
             sb.append(freqArray[i]);
        }
    }

    return sb.toString();
}

    
    public static void main(String[] args)
    {
        System.out.println(compress2("abxxxxaaaab"));

    }
}