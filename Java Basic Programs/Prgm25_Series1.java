/*Program to generate the series
1
-4 9
-16 25 -36
:
:
N rows
*/
package skillAssure.PLT;

import java.util.Scanner;

 public class Prgm25_Series1 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		int sum=0;
		int sign=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				sum++;
				System.out.print(sum*sum*sign+" ");
				sign*=-1;
			}
			System.out.println();
			
		}
		
	}

}
