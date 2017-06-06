//Program to display the reverse of a string.
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm21_ReverseOfString 
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
	System.out.println("The reversed string is "+tempStr);
	}

}
