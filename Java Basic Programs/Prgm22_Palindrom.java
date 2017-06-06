//Program to check whether the string is palindrom or not
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm22_Palindrom 
{
	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the string");
	String str=sc.next();
	String tempStr="";
	for(int i=str.length()-1;i>=0;i--)
	{
		tempStr+=str.charAt(i);
		
	}
	if(str.equals(tempStr))
	{
		System.out.println("The string is palindrom");
	}
	else
	{
		System.out.println("The string is not a palindrom");
	}
	}

}
