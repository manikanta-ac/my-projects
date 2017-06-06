//Program to find number is even or odd
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm3_EvenOrOdd 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number");
		int num=sc.nextInt();
		//Logic to find even or odd

		if(num==0)
		{
			System.out.println("0 is neither even nor odd");
		}
		else if(num%2==0)
		{
			System.out.println(num+" is an even number");
		}
		else
		{
			System.out.println(num+" is an odd number");
		}
		
	}

}
