//program to display the 1st , 2nd , and 4th multiple of 7 which gives the
//remainder 1 when divided by 2,3,4,5 and 6
package skillAssure.PLT;

public class Prgm17_MultiplesOf7 
{
	public static void main(String[] args) 
	{
		int multiple=7;
		for(int count=1;count<=4;multiple+=7)
		{
			if(multiple%60==1) //here 60 is LCM of 2,3,4,5 & 6
			{
				if(count!=3)
				{
				System.out.println(multiple+",");
				}
				count++;
			}
		}
		
	}

}
