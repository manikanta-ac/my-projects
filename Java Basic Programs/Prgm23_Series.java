/*Program to generate the series
 * ***********
 * ***********
 * ***********
 * ***********
 *    .
 *    .
 *    .
 *  N-rows
 */
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm23_Series 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}
		
	}

}
