/*Program to generate the series
1
1 2
6 24 120
:
:
N rows
*/
package skillAssure.PLT;

import java.util.Scanner;

 public class Prgm25_Series2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		int fact=1;
		int k=1;
		if(n==0)
		{
			System.out.print(1);
		}
		for(int i=0;i<n;i++)
		{
			
			for(int j=i;j>=0;j--)
			{
				System.out.print(fact+" ");
				fact*=k;
				k++;
			}
				
			System.out.println();
			
		}
		
	}

}
