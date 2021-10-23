#include<iostream>
using namespace std;

void print()
{
    cout<<"Hello World"<<endl;
    cout<<"This is Simran";
}

void printZ()
{
    cout<<"*****"<<endl;
    cout<<"   *"<<endl;
    cout<<"  *"<<endl;
    cout<<" *"<<endl;
    cout<<"*****"<<endl;
}

void gradingSystem(int n)
{
    if(n>90)
        {
            cout<<"excellent"<<endl;
        }
        else if(n>80 && n<=90)
        {
            cout<<"good"<<endl;

        }
        else if(n>70 && n<=80)
        {
            cout<<"fair"<<endl;
        }
        else if(n>60 && n<=70)
        {
            cout<<"meet expectations"<<endl;
        }
        else{
            cout<<"below par"<<endl;
        }
}

void oddEven(int n)
    {
        if(n%2==0)
        {
            cout<<"Even";
        }
        else
        {
            cout<<"Odd";
        }
    }

bool isPrime_(int n)
{
    bool prime=true;
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
    int n;
    cin>>n;
    bool ans=isPrime_(n);
        if(ans==false)
        {
            cout<<"non prime"<<endl;
        }
        

void printAllPrimes(int a,int b)
{
    for(int i=a;i<=b;i++)
    {
        bool ans=isPrime_(i);
        if(ans){
            cout<<i<<endl;
        }
    }
}

/*void printFibonaaci()
{
    int first=0;
    int second=1;
    int sum=0;
    for(int i=1;i<=)
} */

int countDigits(int n)
{
    int count=0;
    while(n!=0)
    {
        n=n/10;
        count=count+1;
    }
    return count;
}


int rotateDigits()
{
    int len=countDigits();
    r=r%len;
    if(r<0)
    {
        r=(-r%len+len)%len;    
    }
    
    int div=1,mul=1;
    for(int i=1;i<=len;i++)
    {
        if(i<=r)
        {
            div=div*10;
        }
        else
        {
            mul=mul*10;
        }
    }
    int a=n%div;
    int b=n/div;

    int result=a*mul+b;
    return result;
}

int printReverse(int n)
{
    for(int i=1;i<=len;i++)
    {
        n=n%10;
        n=n/10;
    }
return n;
}
)
)
int main()
{
    /*print();
    int t;
    cin>>t;
    while(t-->0)
    {
        isPrime(); 
    }
    return 0;
}*/
int n;
cin>>n;
countDigits(n);
return 0;
}
