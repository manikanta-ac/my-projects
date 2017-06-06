/*Program to print 
      *
    * *
  * * *
* * * *
:
N rows
*/
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm25_Series3
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		//logic for  traingle 
		for(int i=0;i<n;i++)
		{
			for(int j=n-i;j>0;j--)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
