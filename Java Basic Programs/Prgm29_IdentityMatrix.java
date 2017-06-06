//Program to check whether matrix is an identity matrix or not.
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm29_IdentityMatrix 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n = sc.nextInt();
				
		int array[][] = new int[n][n];
		
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.println("array[" + i + "]"+"[" + j + "]");
				array[i][j] = sc.nextInt();
			}
		}
		
		// Display the array elements 
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		if(isIdentity(array))
		{
			System.out.println("Identity Matrix");
		}
		else
		{
			System.out.println("Not an Identity Matrix");
		}		
	}
	static boolean isIdentity(int[][] array)
	{
		boolean identity = true;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(i==j)
				{
					if(array[i][j] != 1)
					{
						identity = false;
						return identity;
					}
				}
				else
				{
					if(array[i][j] != 0)
					{
						identity = false;
						return identity;
					}
				}
			}
		}
		return identity;
	}

}
