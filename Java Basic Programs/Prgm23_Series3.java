/*Program to generate the series
 * 12345
 * 12345
 * 12345
 * 12345
 *    .
 *    .
 *    .
 *  N-rows
 */
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm23_Series3 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(j);
			}
			System.out.println();
			
		}
		
	}

}
