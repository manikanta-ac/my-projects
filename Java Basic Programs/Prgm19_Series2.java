//program to print the series 1, 1, 2, 3, 5, 8, 13, … N
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm19_Series2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N as no.of terms in series");
		int n=sc.nextInt();
		int sum=1;
		int temp1=0;
		int temp2=1;
		for(int i=0;i<n;i++)
		{
			System.out.print(sum+",");
			sum=temp1+temp2;
			temp1=temp2;
			temp2=sum;
		}
		
	}

}
