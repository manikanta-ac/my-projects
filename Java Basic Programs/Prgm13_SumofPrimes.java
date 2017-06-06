//Program to find sum of prime numbers from n to m
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm13_SumofPrimes {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n value");
		int n=sc.nextInt();//lower limit
		System.out.println("Enter m value");
		int m=sc.nextInt();//upper limit
		boolean flag;
		int sum=0;
		int i=n,j;
		if(i==1)
		{
			i++;
		}
		for(;i<=m;i++)
		{
			j=2;
			flag=true;
			for(;j<(i/2);j++)
			{
				if(i%j==0)
				{
					flag=false;
					break;
				}
			}
			if(flag==true)
			{
				sum+=i;
				System.out.println(i+",");
			}
		}
		System.out.println("Sum of Primes is "+sum);
	}

}
