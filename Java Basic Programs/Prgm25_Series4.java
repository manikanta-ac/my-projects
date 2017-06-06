/*Program to print 
    *
  * * *
 * * * * *
* * * * * * *
:
N rows 
 */
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm25_Series4 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		//logic for Pyramid 
		for(int i=1;i<=n*2;i+=2)
		{
			for(int j=n*2-i;j>0;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
