import java.util.Scanner;

public static void printSS(String str,int idx,String ans)
{
    if(idx==str.length())
    {
        System.out.println(ans);
        return;
    }
    printSS(str,idx+1,ans+str.charAt(idx));
    printSS(str,idx+1,ans);
}

public static void printSS_02(String str,int idx,StringBuilder ans) //Using string builder
{
    if(idx==str.length())
    {
        System.out.println(ans);
        return;
    }
    ans.append(str.charAt(idx));//adding character to the string builder

    printSS_02(str,idx+1,ans);

    ans.deleteCharAt(ans.length()-1);// wapis aate time delete the character 
    printSS_02(str,idx+1,ans);
}

public static void subseq()
{
    String str="abc";
    printSS_02(str,0,new StringBuilder());
}

public static ArrayList<String> subseq_03(String str,int idx)
{
    if(idx==str.length())
    {
        ArrayList<String> base=new ArraysList<>();
        return base;
    }
    ArrayList<String> recAns=subseq_03(str,idx+1);// get the recursive answer i.e subsequence for the rest of the string
    ArraysList<String> myAns=new ArraysList<>(recAns);// create your final answer and character nah aane wali choice to add recAns directly to myans
//now add the character to the recAns subsequence 
char ch=str.charAt(idx);
for(String s:recAns)
{
    myAns.add(ch+recAns);// this will give us all the required subsequences agr a aana chahta h
}

return myAns;
}

public static void ASCIIsubseq(String str,int idx,String ans)
{

    if(idx==str.length())
    {
        System.out.println(ans);
        return; 
    }

char ch=str.charAt(idx);
    ASCIIsubseq(str,idx+1,ch+ans);//adding the character to the ans string
    ASCIIsubseq(str,idx+1,(int)ch+ans);//adding the ascii value to the string ans
    ASCIIsubseq(str,idx+1,ans);// not adding the character to ans
}

public static ArraysList<String> ASCIIsubseq_02(String str,int idx)
{
    char ch=str.charAt(idx);
    ArrayList<String> recAns=ASCIIsubseq(str,idx+1);
    ArrayList<String> myAns=new ArrayList<>(recAns);

    for(String s:recAns)
    {
        myAns.add(ch);
        myAns.add((int)ch);
    }

}

public static void getKPC(String str,int idx,String ans)
{
    if(idx==str.length())
    {
        System.out.println(ans);
        return;
    }
    String[] characters=[",;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"];

    char ch=str.charAt(idx);
    String code=characters[ch-'0'];
    for(int i=0;i<code.length();i++)
    {
        char c=code.charAt(i);
        getKPC(str,idx+1,ans+c);
    }
}

public static ArrayList<String> getKPC(String str,int idx)
{
    String[] characters={",;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    char ch=str.charAt(idx);
    String code=characters[ch-'0'];

     ArrayList<String> recAns=getKPC(str,idx+1);
     ArrayList<String> myAns=new ArrayList<>();
    for(int i=0;i<code.length();i++)
    {
        char c=code.charAt(i);
        for(String s:recAns)
        {
            myAns.add(c+s);
        }
    }
}

public static ArrayList<String> getMazePath(int sr,int sc,int dr,int dc)
{
    if(sr==dr && sc==dc)
    {
        ArrayList<String> base=new ArrayList<>();
        base.add("");
        return base;
    }

ArrayList<String> myAns=new ArrayList<>();
    if(sr+1<=dr)
    {
        ArrayList<String> vertical=getMazePath(sr+1,sc,dr,dc);
        for(String s:vertical)
        {
            myAns.add("V"+s);
        }
    }

    if(sc+1<=dc)
    {
        ArrayList<String> horizontal=getMazePath(sr,sc+1,dr,dc);
        for(String s:horizontal)
        {
            myAns.add("H"+s);
        }
    }

    return myAns;
}

 public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr==dr && sc==dc)
	        {
	            System.out.println(psf);
	            return;
	        }
	        
	        
	   if(sc+1<=dc){
	          printMazePaths(sr,sc+1,dr,dc,psf+"h");
	   }
	     
	        
	        if(sr+1<=dr)
	        {
	           printMazePaths(sr+1,sc,dr,dc,psf+"v");
	        }
	   
}

public static ArrayList<String> getMazePathDiagonal(int sr,int sc,int dr,int dc)
{
      if(sr+1<=dr)
    {
        ArrayList<String> vertical=getMazePath(sr+1,sc,dr,dc);
        for(String s:vertical)
        {
            myAns.add("V"+s);
        }
    }

    if(sc+1<=dc)
    {
        ArrayList<String> horizontal=getMazePath(sr,sc+1,dr,dc);
        for(String s:horizontal)
        {
            myAns.add("H"+s);
        }
    }

    if(sc+1<=dc && sr+1<=dr)
    {
        ArrayList<String> diagonal=getMazePath(sr+1,sc+1,dr,dc);
        for(String s:diagonal)
        {
            myAns.add("D"+s);
        }
    }

    return myAns;
}

public static ArrayList<String> getMazePathswithJumps(int sr, int sc, int dr, int dc) {
        
        if(sr==dr && sc==dc)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> myAns=new ArrayList<>();
        
        for(int jump=1;sc+jump<=dc;jump++)
        {
            ArrayList<String>horizontal=getMazePathswithJumps(sr,sc+jump,dr,dc);
            for(String s:horizontal)
            {
                myAns.add("h"+jump+s);
            }
        }
        
        for(int jump=1;sr+jump<=dr;jump++)
        {
            ArrayList<String>vertical=getMazePathswithJumps(sr+jump,sc,dr,dc);
            for(String s:vertical)
            {
                myAns.add("v"+jump+s);
            }
        }
        
        for(int jump=1;sr+jump<=dr && sc+jump<=dc;jump++)
        {
            ArrayList<String>diagonal=getMazePathswithJumps(sr+jump,sc+jump,dr,dc);
            for(String s:diagonal)
            {
                myAns.add("d"+jump+s);
            }
        }
        return myAns;
}

public static getMazePathswithJumps(int sr,int sc,int dr,int dc,String ans)
{
    if(sr==dr && sc==dc)
    {
        System.out.println(ans);
        return;
    }

    for(int jump=1;sc+jump<=dc;jump++)
    {
        getMazePathswithJumps(sr,sc+jump,dr,dc,ans+"h"+jump);
    }

    for(int jump=1;sr+jump<=dr;jump++)
    {
        getMazePathswithJumps(sr+jump,sc,dr,dc,ans+"v"+jump);
    }

    for(int jump=1;sc+jump<=dc && sr+1<=dr;jump++)
    {
        getMazePathswithJumps(sr+jump,sc+jump,dr,dc,ans+"d"+jump);
    }
}

public static void stairPath(int sr,int dr,String ans)
{
    if(sr==dr)
    {
        System.out.println(ans);
        return;
    }

    for(int jump=1;jump<=3 && jump+sr<=dr;jump++)
    {
        stairPath(sr+jump,dr,ans+jump);
    }
}

public static ArrayList<String> stairPath(int sr,int dr)
{
     if(sr==dr)
    {
        ArrayList<String> base=new ArrayList<>();
        base.add("");
        return base;
    }
ArrayList<String> myAns=new ArrayList<>();

    for(int jump=1;jump<=3;jump++)
    {
        ArrayList<String> recAns=stairPath(sr+jump,dr);
        for(String s:recAns)
        {
            myAns.add(jump+recAns);
        }

    }
}

public static void main(String[] args)
{

}