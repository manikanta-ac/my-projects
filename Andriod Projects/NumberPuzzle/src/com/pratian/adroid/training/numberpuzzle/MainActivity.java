package com.pratian.adroid.training.numberpuzzle;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements OnClickListener
{
	Button buttons[][]=new Button[5][5];
	int arr[];
	int emptyButtonId;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttons[0][0]=(Button)findViewById(R.id.button1);
		buttons[0][1]=(Button)findViewById(R.id.button2);
		buttons[0][2]=(Button)findViewById(R.id.button3);
		buttons[0][3]=(Button)findViewById(R.id.button4);
		buttons[0][4]=(Button)findViewById(R.id.button5);
		buttons[1][0]=(Button)findViewById(R.id.button6);
		buttons[1][1]=(Button)findViewById(R.id.button7);
		buttons[1][2]=(Button)findViewById(R.id.button8);
		buttons[1][3]=(Button)findViewById(R.id.button9);
		buttons[1][4]=(Button)findViewById(R.id.button10);
		buttons[2][0]=(Button)findViewById(R.id.button11);
		buttons[2][1]=(Button)findViewById(R.id.button12);
		buttons[2][2]=(Button)findViewById(R.id.button13);
		buttons[2][3]=(Button)findViewById(R.id.button14);
		buttons[2][4]=(Button)findViewById(R.id.button15);
		buttons[3][0]=(Button)findViewById(R.id.button16);
		buttons[3][1]=(Button)findViewById(R.id.button17);
		buttons[3][2]=(Button)findViewById(R.id.button18);
		buttons[3][3]=(Button)findViewById(R.id.button19);
		buttons[3][4]=(Button)findViewById(R.id.button20);
		buttons[4][0]=(Button)findViewById(R.id.button21);
		buttons[4][1]=(Button)findViewById(R.id.button22);
		buttons[4][2]=(Button)findViewById(R.id.button23);
		buttons[4][3]=(Button)findViewById(R.id.button24);
		buttons[4][4]=(Button)findViewById(R.id.button25);

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				buttons[i][j].setOnClickListener(this);
			}
		}
		Button btn=(Button)findViewById(R.id.button26);
		btn.setOnClickListener(this);
		Button btn1=(Button)findViewById(R.id.button27);
		btn1.setOnClickListener(this);
		shuffle();
		emptyButtonId=R.id.button25;
	}

	public void shuffle()
	{
		//Logic to generate random numbers		
		arr=new int[24];
		emptyButtonId=R.id.button25;
		buttons[4][4].setText("");
		L1: for(int i=0;i<arr.length;)
		{
			Random r=new Random();
			int value=r.nextInt(25);
			for(int k=0;k<arr.length;k++)
			{
				if(value==arr[k])
				{
					continue L1;
				}
			}
			arr[i]=value;
			i++;

		}
		
	int count=0;
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			if(!(i==4&&j==4))
			{
				buttons[i][j].setText(((Integer)arr[count++]).toString());
			}
		}
	}	
	}

	@Override
	public void onClick(View v) 
	{
		int x=0,y=0;
		int p=0,q=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(emptyButtonId==buttons[i][j].getId())
				{
					p=i;
					q=j;
				}
			}
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(v.getId()==buttons[i][j].getId())
				{
					x=i;
					y=j;
				}
			}
		}

		if((x==p-1 && y==q)||(x==p+1 && y==q)||(x==p && y==q-1)||(x==p && y==q+1))
		{
			buttons[p][q].setText(buttons[x][y].getText());
			buttons[x][y].setText("");
			emptyButtonId=buttons[x][y].getId();
		}

		if(v.getId()==R.id.button26)
		{
			Toast tst;
			if(p==4&&q==4)
			{
				if(winning())
				{
					tst=Toast.makeText(MainActivity.this , "You Won The Game", Toast.LENGTH_SHORT);
					tst.show();
				}
				else
				{
					tst=Toast.makeText(MainActivity.this , "You Lost The Game\n        Try Again", Toast.LENGTH_SHORT);
					tst.show();
				}
			}
			else
			{
				tst=Toast.makeText(MainActivity.this , "You Lost The Game\n        Try Again", Toast.LENGTH_SHORT);
				tst.show();
			}
		}
		if(v.getId()==R.id.button27)
		{
			shuffle();
		}
	}

	public boolean winning()
	{
		int test[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		int count=0;
		boolean flag=false;
		L1:for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(!(i==4&&j==4))
				{
					int btnText=Integer.parseInt((String)buttons[i][j].getText());
					if(btnText!=test[count++])
					{
						flag=true;
						break L1;
					}
				}
			}
		}
		if(!flag)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
