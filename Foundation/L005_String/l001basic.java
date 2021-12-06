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

public static String compres3(String str)
{
    StringBuilder sb=new StringBuilder();
    char prevChar=str.charAt(0);
    int idx=1;
    while(idx<=str.length())
    {
        int count=0;

        while(idx<str.length && prevChar==str.charAt(idx))
        {
            count++;
            idx++;
        }

        sb.append(prevChar);

        if(idx==str.length())
        {
            break;
        }
        prevChar=str.charAt(idx);
        idx++;
    }

    return sb.toString();
}

public static String toggleCase(String str){	
		StringBuilder  sb=new StringBuilder();
		for(char c=0;c<str.length();c++)
		{
		    char ch=str.charAt(c);
		    if(ch>='a' && ch<='z')
		    {
		        int code=ch-'a';
		        ch=(char)(code+'A');
		        sb.append(ch);
		    }
		    
		    else{
		        int code=ch-'A';
		        ch=(char)(code+'a');
		        sb.append(ch);
		    }
		}

		return sb.toString();
	}

public static boolean isPalindrome(String str)
{
    int i=0;
    int j=str.length()-1;

    while(i<j)
    {
        if(str.charAt(i)!=str.charAt(j))
        {
            return false;
        }
        i++;
        j--;
    }
}
public static void PalindromicSubString(String str)
{
    for(int i=0;i<str.length();i++)
    {
        for(int j=i;j<str.length();j++)
        {
            String s=str.substring(i,j+1);
            if(isPalindrome(s))
            {
                System.out.println(s);
            }
        }
    }
}

public static String consecutiveCharacter(String str){
   	if(str.length()<=1)
    {
        return str;
    }

    StringBuilder sb=new StringBuilder();
    
    for(int i=0;i<=str.length()-2;i++)
    {
         char c1=str.charAt(i);
         char c2=str.charAt(i+1);
         int diff=c2-c1;

         sb.append(c1);
         sb.append(diff);
    }
     
    sb.append(str.charAt(str.length()-1));

    return sb.toString();
} 

public static ArrayList<String> permutation(String str)
{
    ArrayList<String> ans=new ArrayList<>();
    ans.add(str.charAt(0));

    for(int i=1;i<str.length();i++)//to iterate over the string
    {
        char ch=str.charAt(i);
        for(String s:ans)
        {
            ArrayList<String> smallAns=new ArrayList<>();
            for(int j=0;j<=s.length();j++)
            {
                String newString=s.substring(0,i)+ch+s.substring(i);
                smallAns.add(newString);
            }
        }

        ans=smallAns;
    }

    return ans;
}

public static ArrayList<String> subsequ(String str){
    ArrayList<String> ans=new ArrayList<>();
    ans.add(" ");

    for(int i=0;i<str.length();i++)
    {
        char ch=str.charAt(i);
        int size=ans.size();
        for(int j=0;j<size;j++)
        {
            ans.add(ans.get(j)+ch);
        }
    }

    return ans;
}
    
public static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n % i==0)
            {
                return false;
            }
        }
        
        return true;
    }

public static void solution(ArrayList<Integer> al){
	
	ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : al){
            if(!isPrime(ele)) ans.add(ele);
        }
        
        al.clear();
        for(int ele : ans) al.add(ele);
	}
    
//Leetcode 387
public int unique(String str)
    {
        if(str.length()==1)
        {
            return 0;
        }
        int[] freqArray=new int[26];
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            int code=ch-'a';
            
            freqArray[code]++;
        }
        
        for(int i=0;i<str.length();i++)
        {
            int checkCode=str.charAt(i)-'a';
            
            if(freqArray[checkCode]==1)
            {
                return i;
            }
        }    
        return -1;
    }

    public int firstUniqChar(String s) {
        return unique(s);    
    }

//PrimeFactor Query Problem
public static boolean isPrime(int n)
{
    for(int i=2;i*i<=n ;i++)
    {
        if(n%i==0)
        {
            return false;
        }
    }
    return true;
}

    public static void primeFactors(int num,ArrayList<Integer> list){

        int idx = 0;
        while(num != 1 && idx < list.size()){
            int count = 0;
            while(num % list.get(idx) == 0){
                num /= list.get(idx);
                count++;
            }
            if(count > 0)
               System.out.print(list.get(idx) + "^" + count + " ");
            idx++;
        }
        
        if(num > 1)
            System.out.print(num + "^" + 1);
        
        System.out.println();
    }

    public static void primeFactorsForQuery(int[] query){
        ArrayList<Integer> list = new ArrayList<>();
        primeNumbers(10000,list);

        for(int ele : query){
            primeFactors(ele,list);
        }
    }
    public static void main(String[] args)
    {
        System.out.println(compress2("abxxxxaaaab"));

    }
}