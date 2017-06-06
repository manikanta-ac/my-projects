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

	private String array[]=new String[20];
	private static int count=0;
	Double result=null;
	boolean resFlag=false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button but1=(Button)findViewById(R.id.button1);
		but1.setOnClickListener(this);

		Button but2=(Button)findViewById(R.id.button2);
		but2.setOnClickListener(this);

		Button but3=(Button)findViewById(R.id.button3);
		but3.setOnClickListener(this);

		Button but4=(Button)findViewById(R.id.button4);
		but4.setOnClickListener(this);

		Button but5=(Button)findViewById(R.id.button5);
		but5.setOnClickListener(this);

		Button but6=(Button)findViewById(R.id.button6);
		but6.setOnClickListener(this);

		Button but7=(Button)findViewById(R.id.button7);
		but7.setOnClickListener(this);

		Button but8=(Button)findViewById(R.id.button8);
		but8.setOnClickListener(this);

		Button but9=(Button)findViewById(R.id.button9);
		but9.setOnClickListener(this);

		Button but10=(Button)findViewById(R.id.button10);
		but10.setOnClickListener(this);

		Button but11=(Button)findViewById(R.id.button11);
		but11.setOnClickListener(this);

		Button but12=(Button)findViewById(R.id.button12);
		but12.setOnClickListener(this);

		Button but13=(Button)findViewById(R.id.button13);
		but13.setOnClickListener(this);

		Button but14=(Button)findViewById(R.id.button14);
		but14.setOnClickListener(this);

		Button but15=(Button)findViewById(R.id.button15);
		but15.setOnClickListener(this);

		Button but16=(Button)findViewById(R.id.button16);
		but16.setOnClickListener(this);

		Button but17=(Button)findViewById(R.id.button17);
		but17.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub


		if(v.getId()==R.id.button1)
		{
			Button but=(Button)findViewById(R.id.button1);
			display(but);
		}

		if(v.getId()==R.id.button2)
		{
			Button but=(Button)findViewById(R.id.button2);
			display(but);


		}

		if(v.getId()==R.id.button3)
		{
			Button but=(Button)findViewById(R.id.button3);
			display(but);


		}

		if(v.getId()==R.id.button4)
		{
			Button but=(Button)findViewById(R.id.button4);
			display(but);


		}

		if(v.getId()==R.id.button5)
		{
			Button but=(Button)findViewById(R.id.button5);
			display(but);


		}

		if(v.getId()==R.id.button6)
		{
			Button but=(Button)findViewById(R.id.button6);
			display(but);


		}

		if(v.getId()==R.id.button7)
		{
			Button but=(Button)findViewById(R.id.button7);
			display(but);


		}

		if(v.getId()==R.id.button8)
		{
			Button but=(Button)findViewById(R.id.button8);
			display(but);


		}

		if(v.getId()==R.id.button9)
		{
			Button but=(Button)findViewById(R.id.button9);
			display(but);


		}

		if(v.getId()==R.id.button10)
		{
			Button but=(Button)findViewById(R.id.button10);
			display(but);


		}

		if(v.getId()==R.id.button11)
		{
			Button but=(Button)findViewById(R.id.button11);
			display(but);


		}

		if(v.getId()==R.id.button12)
		{
			Button but=(Button)findViewById(R.id.button12);
			display(but);

		}

		if(v.getId()==R.id.button13)
		{
			Button but=(Button)findViewById(R.id.button13);
			display(but);

		}

		if(v.getId()==R.id.button14)
		{
			Button but=(Button)findViewById(R.id.button14);
			display(but);
		}


		if(v.getId()==R.id.button15)
		{
			Button but=(Button)findViewById(R.id.button15);
			display(but);

		}

		if(v.getId()==R.id.button16)
		{

			evaluate();

		}

		if(v.getId()==R.id.button17)
		{
			TextView tv=(TextView)findViewById(R.id.textView1);
			tv.setText("");
			count=0;
		}

	}

	private void evaluate() {
		// TODO Auto-generated method stub

		int len=count;
		TextView tv=(TextView)findViewById(R.id.textView1);

		Double var1=0.0;
		String str1="";
		Double var[]=new Double[2];
		int j=0;
		int count1=0;
		boolean flag=false;
		
		if(resFlag==true)
		{
			var[j++]=result;
		}
		for(int i=0;i<len;i++)
		{

			String str=array[i];


			if(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") || str.equals("6") || str.equals("7") || str.equals("8") ||str.equals("9")  || str.equals("0") || str.equals("."))
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
				var1=var1*10+(Integer.parseInt(str));
			}

			else if(str.equals("+") || str.equals("*") || str.equals("/") || str.equals("-"))
			{
				str1=str;
				// j=j++;
				if(resFlag==false)
				{
					if(count1!=0)
						var1=var1/(count1*10);
					var[j++]=var1;
					var1=0.0;
					flag=false;
					count1=0;
				}

			}


		}

		if(count1!=0)
			var1=var1/(count1*10);
		var[j]=var1;


		Toast tst=Toast.makeText(MainActivity.this, "var1 is:"+var[0].toString(),Toast.LENGTH_LONG);
		tst.show();

		tst=Toast.makeText(MainActivity.this, "var2 is:"+var[1].toString(),Toast.LENGTH_LONG);
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
		resFlag=true;j=0;

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
		Toast tst=Toast.makeText(MainActivity.this, i, Toast.LENGTH_LONG);
		tst.show();
		//int i=Integer.parseInt((String)but.getText());
		tv.setText(str+i);


	}

}


