//program to find billing information of customer

package skillAssure.PLT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prgm18_BillingInfo 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		double grandtotal=0;
		String choice;
		int i=0;
		String str1[]=new String[50];
		int code[]=new int[50];;
		int qty[]=new int[50];
		double price[]=new double[50];
		double total[]=new double[50];
		String card;
		do
		{
			
			System.out.println("Enter item code");
			code[i]=Integer.parseInt(br.readLine());
			System.out.println("Enter item name");
			str1[i]=br.readLine();
			System.out.println("Enter quantity");
			qty[i]=Integer.parseInt(br.readLine());
			System.out.println("Enter the price for the item is");
			price[i]=Double.parseDouble(br.readLine());
			total[i]=qty[i]*price[i];
			grandtotal+=total[i];
			System.out.println("would you want to continue");
			 choice=br.readLine();
			 i=i+1;
		}while(choice.equals("y")||choice.equals("Y"));
		
		System.out.println("Enter y/Y to pay by card:");
		card=br.readLine();

		System.out.println("The total items you purchased:");
		System.out.println("**********************************************************");
		System.out.println("ITEMCODE     NAME     QUANTITY        PRICE           TOTAL");
		System.out.println("**********************************************************");
		for(int j=0;j<i;j++) 
		{
			System.out.println(code[j]+"           "+str1[j]+"           "+qty[j]+"           "+price[j]+"          "+total[j]);
		}
		System.out.println("**********************************************************");
		System.out.println("The GrandTotal is  "+grandtotal);
		if(grandtotal>10000)
		{
			System.out.println("**********************************************************");
			System.out.println("After discount the grandtotal is");
			grandtotal-=grandtotal*(0.1);
			System.out.print(grandtotal);
		}
		if((grandtotal<1000)&&(card.equals("y")||(card.equals("Y"))))
		{
			System.out.println("**********************************************************");
			System.out.println("After surcharge the grand total is ");
			grandtotal+=grandtotal*(2.5/100);
			System.out.print(grandtotal);
			
		}
	}
}
		
	