//Program to search element using LINEAR SEARCH
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm26_LinearSearch 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements in list:");
		int size=sc.nextInt();
		int list[] = new int[size];
		boolean flag=false;
		
		//Reading list elements
		System.out.println("Enter the list elements");
		for(int i=0;i<size;i++)
		{
				System.out.print("list[" + i + "]");
				list[i] = sc.nextInt();
			
		}
		
		// Display the list elements 
		for(int i=0;i<size;i++)
		{
				System.out.print(list[i] + ",");
		}
		System.out.println();
		//reading element to search
		System.out.println("Enter element to be search:");
		int key=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			if(list[i]==key)
			{
				System.out.println("The element is found at "+i);
				flag=true;
				break;	
			}
		}
		if(!flag)
		{
			System.out.println("Element not found");
		}
		
	}

}
