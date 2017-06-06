package com.pratian.android.training.calculatordemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements OnClickListener {

	private String array[]=new String[20];	//to store values of clicked buttons
	private static int count=0;				//index of  array(above)
	Double result=null;						//to perform operations on previous results
	boolean resFlag=false;					//test conditions to perform operations on previous values
	Button buttons[];						//to store button id's
	Double d;								//to store value in memory
	Double var[]=new Double[]{0.0,0.0};
	int j=0;
	boolean isExist1=false;
	boolean isExist2=false;
	private boolean isMemory;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttons=new Button[]
				{
				(Button)findViewById(R.id.button1),
				(Button)findViewById(R.id.button2),
				(Button)findViewById(R.id.button3),
				(Button)findViewById(R.id.button4),
				(Button)findViewById(R.id.button5),
				(Button)findViewById(R.id.button6),
				(Button)findViewById(R.id.button7),
				(Button)findViewById(R.id.button8),
				(Button)findViewById(R.id.button9),
				(Button)findViewById(R.id.button10),
				(Button)findViewById(R.id.button11),
				(Button)findViewById(R.id.button12),
				(Button)findViewById(R.id.button13),
				(Button)findViewById(R.id.button14),
				(Button)findViewById(R.id.button15),
				(Button)findViewById(R.id.button16),
				(Button)findViewById(R.id.button17),
				(Button)findViewById(R.id.button18),
				(Button)findViewById(R.id.button19),
				(Button)findViewById(R.id.button20),
				(Button)findViewById(R.id.button21)

				};

		for(int k=0;k<21;k++)
		{
			buttons[k].setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		for(int k=0;k<15;k++)
		{
			if(v.getId()==buttons[k].getId())
			{
				display(buttons[k]);
			}
		}
		if(v.getId()==R.id.button16)
		{

			evaluate();

		}

		else if(v.getId()==R.id.button17)							//clear 
		{
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText("");
			count=0;
			resFlag=false;
			d=0.0;
			isMemory=false;
		}
		else if(v.getId()==R.id.button18)							//memory store
		{
			TextView tv=(TextView)findViewById(R.id.textView1);
			String str=(String)tv.getText();
			d=Double.parseDouble(str);
			tv.setText("");
			count=0;
		}
		else if(v.getId()==R.id.button19)							//return value in memory
		{
			TextView tv=(TextView)findViewById(R.id.textView1);
			if(count==0)
			{
				//var[j++]=d;
				tv.setText(d.toString());
			}
			else
			{

				String str=(String)tv.getText();


				//var[j]=d;
				tv.setText(str+d.toString());
			}
			isMemory=true;

		}
		else if(v.getId()==R.id.button20)							//M+ operation
		{
			if(isExist1==false)
			{
				TextView tv=(TextView)findViewById(R.id.textView1);
				String str=(String)tv.getText();
				d=Double.parseDouble(str);
				isExist1=true;
				tv.setText("");
				count=0;
			}
			else
			{
				TextView tv=(TextView)findViewById(R.id.textView1);
				String str=(String)tv.getText();
				Double temp=Double.parseDouble(str);
				d=d+temp;
				tv.setText("");

			}



		}
		else if(v.getId()==R.id.button21)								//M- operation
		{
			if(isExist2==false)
			{
				TextView tv=(TextView)findViewById(R.id.textView1);
				String str=(String)tv.getText();
				d=Double.parseDouble(str);
				isExist2=true;
				tv.setText("");
				count=0;
			}
			else
			{
				TextView tv=(TextView)findViewById(R.id.textView1);
				String str=(String)tv.getText();
				Double temp=Double.parseDouble(str);
				d=d-temp;
				tv.setText("");
			}
		}

	}

	private void evaluate() {
		// TODO Auto-generated method stub
		//int index=0;
		TextView tv=(TextView)findViewById(R.id.textView1);
		int len=count;

		Double var1=0.0;
		String str1="";
		int temp=0;

		int count1=0;
		boolean flag=false;	//to access float values
		
		if(resFlag==false && ((count==2 && isMemory==false) || (count==1 && isMemory==true)))
			resFlag=true;

		if((resFlag==true) || (resFlag==true && count==1 && isMemory==true))
		{
			var[j++]=result;
			temp++;
		}
		if((isMemory==true && count==2) || (resFlag==true && count==1 && isMemory==true))
		{
			if(j==0)
			 var[j++]=d;
			else
				var[j]=d;
			temp++;
		}
		for(int i=0;i<len;i++)
		{

			String str=array[i];


			if(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") || str.equals("6") || str.equals("7") || str.equals("8") || str.equals("9")  || str.equals("0") || str.equals("."))
			{
				if(str.equals("."))
				{
					flag=true;
					continue;
				}
				if(flag==true)
				{
					count1++;
				}
				var1=var1*10+(Double.parseDouble(str));
			}

			else if(str.equals("+") || str.equals("*") || str.equals("/") || str.equals("-"))
			{
				str1=str;
				// j=j++;
				if(resFlag==false && isMemory==false)
				{
					if(count1!=0)
						var1=var1/(Math.pow(10, count1));
					var[j++]=var1;
					var1=0.0;
					flag=false;
					count1=0;
				}

			}


		}

		if(temp!=2)
		{
			if(count1!=0)
				var1=var1/(Math.pow(10, count1));
			var[j]=var1;
		}


		Toast tst=Toast.makeText(MainActivity.this, "var1 is:"+var[0].toString(),Toast.LENGTH_SHORT);
		tst.show();

		tst=Toast.makeText(MainActivity.this, "var2 is:"+var[1].toString(),Toast.LENGTH_SHORT);
		tst.show();
		/*int var1=Integer.parseInt(array[0]);
		String str1=array[1];
		int var2=Integer.parseInt(array[2]);*/


		if(str1.equals("+"))
		{
			result=var[0]+var[1];
		}
		else if(str1.equals("-"))
		{
			result=var[0]-var[1];
		}
		else if(str1.equals("*"))
		{
			result=var[0]*var[1];
		}
		else if(str1.equals("/"))
		{
			result=var[0]/var[1];
		}
		String str=result.toString();
		resFlag=false;j=0;
		isMemory=false;
		array=new String[20];
		count=0;
		tv.setText(str);
	}

	private void display(Button but) {
		// TODO Auto-generated method stub
		TextView tv=(TextView)findViewById(R.id.textView1);
		String str=(String)tv.getText();
		String i=(String)but.getText();
		//count=count++;
		array[count++]=i;
		Toast tst=Toast.makeText(MainActivity.this, i, Toast.LENGTH_SHORT);
		tst.show();
		//int i=Integer.parseInt((String)but.getText());
		tv.setText(str+i);


	}

}


