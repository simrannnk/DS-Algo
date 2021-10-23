import java.util.Scanner;
public class L002_pattern 
{
    public static Scanner scn=new Scanner(System.in);

public static void pattern1(int rows)
{
    int nst=1;
    for(int r=1;r<=rows;r++)
    {
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }
      nst++;
    System.out.println();
    }
}

public static void pattern2(int rows)
    {
        int nst=rows;
        for(int r=1;r<=rows;r++)
        {
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
        nst--;
         System.out.println();
        }
    }

public static void pattern3(int rows)
{
    int nst=1,nsp=rows-1;
    for(int r=1;r<=rows;r++)
    {
         for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }

        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }

      nst++;
      nsp--;
      System.out.println();
    }
}

public static void pattern4(int rows)
{
    int nst=rows,nsp=0;
    for(int r=1;r<=rows;r++)
    {
         for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }

        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }    
      nst--;
      nsp++;
      System.out.println();
    }
}

public static void pattern5(int rows)
{
    int nst=1;
    int nsp=2;
    for(int r=1;r<=rows;r++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }    

        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }

        if(r<=rows/2)
        {
            nst+=2;
            nsp--;
        }

        else
        {
            nst-=2;
            nsp++;
        }
        System.out.println();
}
}

public static void pattern6(int rows)
{
    int nst=(rows+1)/2;
    int nsp=1;
    for(int r=1;r<=rows;r++)
    {
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }

        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }

         for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*\t");
        }

        if(r<=rows/2)
        {
            nst--;
            nsp+=2;
        }

        else
        {
            nst++;
            nsp-=2;
        }
        System.out.println();
        
    }
}

public static void pattern7(int rows)
{
    int nst=1;
    int nsp=0;
    for(int r=1;r<=rows;r++)
    {
    
        for(int csp=1;csp<=nsp;csp++)
        {
             System.out.print("\t");
        }

        System.out.print("*\t");
        nsp++;
        System.out.println();
        
    }
}

public static void pattern8(int rows)
{
    int nsp=rows-1;
    for(int r=1;r<=rows;r++)
    {
    
        for(int csp=1;csp<=nsp;csp++)
        {
             System.out.print("\t");
        }

        System.out.print("*\t");
        nsp--;
        System.out.println();
        
    }
}

 public static void pattern9(int rows)
    {
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=rows;j++)
            {
                if(i==j || i+j==rows+1)
                {
                    System.out.print("*\t");
                }
                
                else
                {
                    System.out.print("\t");
                }
            }
            
            System.out.println();
        }
    }

     public static void pattern10(int rows)
 {
     int nsp1=rows/2;
     int nsp2=-1;
     for(int r=1;r<=rows;r++)
     {
         for(int csp1=1;csp1<=nsp1;csp1++)
         {
            System.out.print("\t");
         }
         
         System.out.print("*\t");
         
         for(int csp2=1;csp2<=nsp2;csp2++)
         {
             System.out.print("\t");
         }
         
          if(nsp2 != -1) 
                System.out.print("*\t");
         
         if(r<=rows/2)
         {
             nsp1--;
             nsp2+=2;
         }
         
         else
         {
             nsp1++;
             nsp2-=2;
         }
         System.out.println();
             
     }
 }
  public static void pattern10(int rows)
 {
     int nsp1=rows/2;
     int nsp2=-1;
     for(int r=1;r<=rows;r++)
     {
         for(int csp1=1;csp1<=nsp1;csp1++)
         {
            System.out.print("\t");
         }
         
         System.out.print("*\t");
         
         for(int csp2=1;csp2<=nsp2;csp2++)
         {
             System.out.print("\t");
         }
         
          if(nsp2 != -1) 
                System.out.print("*\t");
         
         if(r<=rows/2)
         {
             nsp1--;
             nsp2+=2;
         }
         
         else
         {
             nsp1++;
             nsp2-=2;
         }
         System.out.println();
             
     }
 }

 public static void pattern11(int rows)
    {
        int nst=1;
        int count=1;
        for(int r=1;r<=rows;r++)
        {
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print(count+"\t");
                count++;
            }
            
            nst++;
            System.out.println();
        }
    }

public static void pattern12(int rows)
    {
        int nst=1;
        int a=0;
        int b=1;
        for(int r=1;r<=rows;r++)
        {
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print(a+"\t");
                int sum=a+b;
                a=b;
                b=sum;
            }
            
            nst++;
            System.out.println();
        }
    }

    public static void main(String[] Args)
    {
        int n=scn.nextInt();
        pattern8(n);
        
    }


}