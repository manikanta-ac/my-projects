//program to find simple intrest
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm1_SimpleIntrest 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter principle amount");
		double principle=sc.nextDouble();
		System.out.println("Enter time period");
		double timeTaken=sc.nextDouble();
		System.out.println("Enter rate of intrest");
		double rateOfIntrest=sc.nextDouble();
		double simpleIntrest;
		
		//Logic for finding simple intrest

		simpleIntrest=(principle*timeTaken*rateOfIntrest)/100;

		//Display result

		System.out.println("Simple intrest is "+simpleIntrest);

		
	}

}
