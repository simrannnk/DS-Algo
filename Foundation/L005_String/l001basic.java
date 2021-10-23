public class l001basic{

    public static String compress(String str)
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

    
    public static void main(String[] args)
    {
        System.out.println(compress(""));

    }
}