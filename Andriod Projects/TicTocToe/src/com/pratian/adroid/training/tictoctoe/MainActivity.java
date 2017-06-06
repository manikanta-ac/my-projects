package com.pratian.adroid.training.tictoctoe;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	ImageButton buttons[];
	String user="user1";
	int test[]=new int[9];
	int counter=1;
	boolean check[]=new boolean[9];
	boolean win;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tictac);
		buttons=new ImageButton[]
				{
				(ImageButton)findViewById(R.id.imageButton1),
				(ImageButton)findViewById(R.id.imageButton2),
				(ImageButton)findViewById(R.id.imageButton3),
				(ImageButton)findViewById(R.id.imageButton4),
				(ImageButton)findViewById(R.id.imageButton5),
				(ImageButton)findViewById(R.id.imageButton6),
				(ImageButton)findViewById(R.id.imageButton7),
				(ImageButton)findViewById(R.id.imageButton8),
				(ImageButton)findViewById(R.id.imageButton9)
				};

		for(int i=0;i<9;i++)
		{		
			buttons[i].setOnClickListener(this);
		}
		
		Button btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);

	}	
	@Override
	public void onClick(View v) 
	{
		if(!win)
		{
			if(user.equals("user1"))
			{
				for(int k=0;k<9;k++)
				{
					if(v.getId()==buttons[k].getId())
					{
						if(!check[k])
						{
							Toast tst=Toast.makeText(MainActivity.this , "Now USER-2 turn", Toast.LENGTH_SHORT);
							buttons[k].setImageResource(R.drawable.into);
							test[k]=1;
							counter++;
							user="user2";
							check[k]=true;
							tst.show();
							break;
						}
					}
				}
			}

			else 
			{
				for(int k=0;k<9;k++)
				{
					if(v.getId()==buttons[k].getId())
					{
						if(!(check[k]))
						{
							Toast tst=Toast.makeText(MainActivity.this , "Now USER-1 Turn", Toast.LENGTH_SHORT);
							buttons[k].setImageResource(R.drawable.cir);
							test[k]=2;
							counter++;
							user="user1";
							check[k]=true;
							tst.show();
							break;
						}
					}
				}
			}
			String str=winning();
			if(str!=null)
			{
				Toast tst=Toast.makeText(MainActivity.this , str, Toast.LENGTH_LONG);
				tst.show();
				win=true;
				tst=Toast.makeText(MainActivity.this , "To play again click STRAT GAME", Toast.LENGTH_LONG);
				tst.show();
			}
		}
		
		if(v.getId()==R.id.button1)
		{
			user="user1";
			test=new int[9];
			counter=1;
			win=false;
			check=new boolean[9];
			for(int k=0;k<9;k++)
			{
				buttons[k].setImageResource(R.drawable.blank);
			}
		}
	}

	public String winning()
	{
		int testing[][]=new int[3][3];
		boolean flag=true;
		//Testing rows
		for(int i=0,j=0;i<3;i++,j+=3)
		{
			if(test[j]==1)
			{
				testing[i][0]=test[j];
				if(testing[i][0]==test[j+1])
				{
					if(testing[i][0]==test[j+2])
					{
						flag=false;
						return "USER-1 Wins the Game";
					}
				}
			}
			else if(test[j]==2)
			{
				testing[i][0]=test[j];
				if(testing[i][0]==test[j+1])
				{
					if(testing[i][0]==test[j+2])
					{
						flag=false;
						return "USER-2 Wins the Game";
					}
				}	
			}
		}

		//Testing Columns

		for(int i=0,j=0;i<3;i++,j++)
		{
			if(test[j]==1)
			{
				testing[0][i]=test[j];
				if(testing[0][i]==test[j+3])
				{
					if(testing[0][i]==test[j+6])
					{
						flag=false;
						return "USER-1 Wins the Game";
					}
				}
			}
			else if(test[j]==2)
			{
				testing[0][i]=test[j];
				if(testing[0][i]==test[j+3])
				{
					if(testing[0][i]==test[j+6])
					{
						flag=false;
						return "USER-2 Wins the Game";
					}
				}
			}
		}


		//Testing daignols
		//Diagol-1
		if(test[0]==1)
		{
			testing[0][0]=test[0];
			if(testing[0][0]==test[4])
			{
				if(testing[0][0]==test[8])
				{
					flag=false;
					return "USER-1 Wins the Game";
				}
			}
		}
		else if(test[0]==2)
		{
			testing[0][0]=test[0];
			if(testing[0][0]==test[4])
			{
				if(testing[0][0]==test[8])
				{
					flag=false;
					return "USER-2 Wins the Game";
				}
			}
		}

		//Diagol-2
		if(test[2]==1)
		{
			testing[0][2]=test[2];
			if(testing[0][2]==test[4])
			{
				if(testing[0][2]==test[6])
				{
					flag=false;
					return "USER-1 Wins the Game";
				}
			}
		}
		else if(test[2]==2)
		{
			testing[0][2]=test[2];
			if(testing[0][2]==test[4])
			{
				if(testing[0][2]==test[6])
				{
					flag=false;
					return "USER-2 Wins the Game";
				}
			}
		}
		if(flag&&counter>=9)
		{
			return "Tie Match";
		}
		else
		{
			return null;
		}

	}
}
