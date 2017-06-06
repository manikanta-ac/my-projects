/*Program to generate the series
 * 111111
 * 222222
 * 333333
 * 444444
 *    .
 *    .
 *    .
 *  N-rows
 */
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm23_Series2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(i);
			}
			System.out.println();
			
		}
		
	}

}
