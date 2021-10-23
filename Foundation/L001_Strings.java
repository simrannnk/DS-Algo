public static void main()
{
    String str=nextLine();
    hello(str);

}

public static String hello(String str)
{
    for(int i=0;i<=str.length();i++)
    {
        if(str.charAt(0)=="x")
        {
            String str1=str.setcharAt[0," "];
            return str1;
        }

        else if(str.charAt(1)=="x")
        {
         str1=str.setcharAt[1," "];
            return str1;   
        }

        else if(str.charAt(0)=="x" && str.charAt(1)=="x")
        {
            str1=str.setcharAt[0," "];
         str1=str.setcharAt[1," "];  
         return str1; 
        }

        else
        {
            return str;

        }
    }
}