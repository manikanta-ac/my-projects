//Program to print the series 1, 5, 8, 14, 27, 49, … N
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm19_Series4 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N as no.of terms in series");
		int n=sc.nextInt();
	int i=1;
	int sum=1;
	int temp1=1;
	int temp2=5;
	int temp3=8;

	if(i<n)
	{
		System.out.print(temp1+" ");
		i++;
	}

	if(i<n)
	{
		System.out.print(temp2+" ");
		i++;
	}

	if(i<n)
	{
		System.out.print(temp3+" ");
		i++;
	}

	while(i<=n)
	{
		i++;
		sum=temp1+temp2+temp3;
		System.out.print(sum+" ");
		temp1=temp2;
		temp2=temp3;
		temp3=sum;
	}
  }
}
