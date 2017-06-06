/*Program to generate the series

 * 1
 * 23
 * 456
 * 78910
 *  .
 *  .
 *  .
 * N-rows
 */
package skillAssure.PLT;

import java.util.Scanner;

 public class Prgm24_series3 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		int sum=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(sum);
				sum++;
			}
			System.out.println();
			
		}
		
	}

}
