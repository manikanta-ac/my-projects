//Program to find transpose of matrix
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm28_Transpose 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int m=sc.nextInt();
		System.out.println("Enter no.of columns");
		int n=sc.nextInt();
		int arr1[][]=new int[m][n];
		int arr2[][]=new int[n][m];
		System.out.println("Enter the array elements");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print("array[" + i + "]"+"[" + j + "]");
				arr1[i][j] = sc.nextInt();;
			}
		}
		System.out.println();
		// Display the array elements 
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
		//Logic to find transpose
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr2[j][i]=arr1[i][j];
			}
			System.out.println();
		}
		//Display transpose matrix
		// Display the array elements 
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<m;j++)
					{
						System.out.print(arr2[i][j] + " ");
					}
					System.out.println();
				}
	}
}
