//program to print the series 1, -2, 4, -6, 7,-10, 10,-14… N
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm19_Series3
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N as no.of terms in series");
		int n=sc.nextInt();
		int seq1=1;
		int seq2=-2;
		for(int i=1;i<=n;i++)
		{
			if(i%2==1)
			{
				System.out.print(seq1+",");
				seq1+=3;
			}
			else
			{
				System.out.print(seq2+",");
				seq2-=4;
			}
		}
		
	}

}
