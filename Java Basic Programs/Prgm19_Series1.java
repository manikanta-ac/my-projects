//program to print the series 1,-2,6,-15,31,-56,...........N
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm19_Series1
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N as no.of terms in series");
		int n=sc.nextInt();
		int sum=1;
		int sign=1;
		for(int i=0;i<=n;i++)
		{
			sum+=i*i;
			System.out.print(sum*sign+",");
			sign*=-1;
		}
		
	}

}
