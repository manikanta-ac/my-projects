/*Program to generate the series

 * 1
 * 22
 * 333
 * 4444
 *  .
 *  .
 *  .
 * N-rows
 */
package skillAssure.PLT;

import java.util.Scanner;

 public class Prgm24_Series2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
			
		}
		
	}

}
