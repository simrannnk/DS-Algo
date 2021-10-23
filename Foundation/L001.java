import java.util.Scanner;
public class L001{
    public static Scanner scn=new Scanner(System.in);

    public static void printHello()
    {
        System.out.println("Hello World");
        System.out.println("This is Simran");
    }

    public static void printZ()
    {
            System.out.println("*****");
            System.out.println("   *");
            System.out.println("  *");
            System.out.println(" *");
            System.out.println("*****");       
    }

    public static void gradingSystem(int n)
    {
        if(n>90)
        {
            System.out.println("excellent");
        }
        else if(n>80)
        {
            System.out.println("good");

        }
        else if(n>70)
        {
            System.out.println("fair");
        }
        else if(n>60)
        {
            System.out.println("meet expectations");
        }
        else{
            System.out.println("below par");
        }
    }

    public static void oddEven(int n)
    {
        if(n%2==0)
        {
            System.out.println("Even");
        }
        else
        {
            System.out.println("Odd");
        }
    }

    boolean isPrime_(int n)
{
    boolean prime=true;
    for(int i=2;i*i<=n;i++)
    {
        if(n%i==0)
        {
            prime=false;
            break;
        }
    }
    return prime;
}
void isPrime()
{
    int n=scn.nextInt();
    boolean ans=isPrime_(n);
        if(ans)
        {
            System.out.println("prime");
        }
        else{
            System.out.println("not prime");
        }
}
    void printAllPrimes(int a,int b)
{
    for(i=a;i<=b;i++)
    {
        boolean ans=isPrime_(i);
        if(ans){
            System.out.println(i);
        }
    }
}

public static int printInverse()
{
    int rem,res=0;
    while(n>0)
    {
        digit=n%10;
        n=n/10;
        res=res+Math.pow(10,digit-1)
    }
    return res;
}
public static int pythagorean(int a,int b,int c)
{
    if((a*a==b*b+c*c)!!(b*b==c*c+a*a)!!(c*c==a*a+b*b))
    {
        return true
    }
}

    public static int fibonaaci(int n)
    {
        int a=0;
        int b=1;
        int sum=0;
        for(i=1;i<=n;i++)
        {
            a=b;
            b=sum;
            sum=a+b;
            System.out.prinltn(a);

        }
    }

public static int GCD(int a,int b)
{
    int divisor=a;
    int dividend=b;
    while(dividend%divisor!=0)
    {
        int rem=dividend%divisor;
        dividend=divisor;
        rem=divisor;
    }
return rem;
}

public static int LCM(int a,int b,int gcd)
{
    int lcm=(a/gcd)*b;
    return lcm;
}
   

    public static void main(String[] args)
    {
        //printHello();
        //printZ();
        //gradingSystem();
        int n=scn.nextInt();
        oddEven(n);
    }
}