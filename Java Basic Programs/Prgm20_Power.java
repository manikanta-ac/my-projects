//to find Xn (x to the power of n). Accept X and n
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm20_Power
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter X value");
		int x=sc.nextInt(); //x is the base 
		System.out.println("Enter N value");
		int n=sc.nextInt(); //n is power 
		int temp=1;
		for(int i=0;i<n;i++)
		{
			temp*=x;
		}
		System.out.println("The value n to base of x is "+temp);
	}

}
