//Program to search element using BINARY SEARCH
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm27_BinarySearch 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements in list:");
		int size=sc.nextInt();
		int list[] = new int[size];
		
		//Reading list elements
		System.out.println("Enter the list elements");
		for(int i=0;i<size;i++)
		{
				System.out.print("list[" + i + "]");
				list[i] = sc.nextInt();
			
		}
		
		// Display the list elements 
		System.out.print("The elements in array are:");
		for(int i=0;i<size;i++)
		{
				System.out.print(list[i] + ",");
		}
		System.out.println();
		//Selection sort to sort the list
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(list[i]>list[j])
				{
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
				
		}
		// Display the sorted list elements 
				System.out.print("The elements in sorted array are:");
				for(int i=0;i<size;i++)
				{
						System.out.print(list[i] + ",");
				}
				System.out.println();
		//reading element to search
		System.out.println("Enter element to be search:");
		int key=sc.nextInt();
		int lower=0;
		int upper=list.length-1;
		int mid;
		boolean flag=false;
		while(lower<=upper)
		{
			mid=(lower+upper)/2;
			if(list[mid]==key)
			{
				System.out.println("The element is found at "+mid);
				flag=true;
				break;	
			}
			else if(list[mid]>key)
			{
				upper=mid-1;
			}
			else
			{
				lower=mid+1;
			}
		}
		if(!flag)
		{
			System.out.println("Element not found");
		}
		
	}

}
