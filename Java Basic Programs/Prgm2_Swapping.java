package skillAssure.PLT;

import java.util.Scanner;

public class Prgm2_Swapping 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number");
		int num1=sc.nextInt();
		System.out.println("Enter any number");
		int num2=sc.nextInt();
		int temp;

		//Logic-1 to swap using another variable

		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		System.out.println("**********");
		temp=num1;
		num1=num2;
		num2=temp;
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);

		//Logic-2 using +/- operators

		System.out.println("**********");
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		
		
	}

}
