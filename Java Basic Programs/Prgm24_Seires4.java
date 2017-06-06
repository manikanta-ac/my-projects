/*Program to generate the series 
1
1 2
3 5 8
:
:
N rows
*/
package skillAssure.PLT;

import java.util.Scanner;

 public class Prgm24_Seires4 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int n=sc.nextInt();
		int sum=1;
		int temp1=0;
		int temp2=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(sum+",");
				sum=temp1+temp2;
				temp1=temp2;
				temp2=sum;
			}
			System.out.println();
			
		}
		
	}

}
