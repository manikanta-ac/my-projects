//program to find the profit or loss of the vendor
package skillAssure.PLT;

import java.util.Scanner;

public class Prgm8_VendorProftLoss
{
   	public static void main(String[] args) 
   	{	      
			double vendorCost=0.0;
			double projectCost;
			double clientCost=0.0;
            double vLoss;
            double vProfit;
		 	Scanner sc=new Scanner(System.in);
			System.out.println("enter resource hour");
			double rHour=sc.nextDouble();
			System.out.println("enter dollar rate of resource");
			double rdollarRate=sc.nextDouble();
			System.out.println("enter infrastructure cost");
			double infCost=sc.nextDouble();
			System.out.println("enter cost of frequent software");
			double Freq_sLicenseCost=sc.nextDouble();
			System.out.println("enter cost of in-frequent software");
			double InFreq_sLicenseCost=sc.nextDouble();
		    System.out.println("enter external dollar rate");
			double extDollarRate=sc.nextDouble();
			System.out.println("enter external working hours");
			double extHour=sc.nextDouble();
			
			//Calculating cost and tax
			
			projectCost=rHour*rdollarRate;		
			vendorCost=(infCost*0.7)+(extHour*extDollarRate)+(Freq_sLicenseCost*0.5);
			clientCost=projectCost+(infCost*0.3)+(Freq_sLicenseCost*0.5)+InFreq_sLicenseCost;			
			
		if(clientCost>vendorCost)
		{
			vProfit=clientCost-vendorCost;
			System.out.println("profit of vendor is "+vProfit);
		}
		else
		{
			vLoss=vendorCost-clientCost;
			System.out.println("loss of vendor is "+vLoss);
		}
		}
}
