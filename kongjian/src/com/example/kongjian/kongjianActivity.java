package com.example.kongjian;

import android.app.Activity;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import java.lang.Runnable;

public class kongjianActivity extends Activity
{
	//声明四个控件的变量
	private EditText FactorOne;
	private TextView symbol;
	private EditText FactorTwo;
	private Button   calculate;


	private Button start=null;
	private Button stop=null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	//通过控件ID获取控件
	FactorOne = (EditText) findViewById(R.id.first);
	FactorTwo = (EditText) findViewById(R.id.second);
	calculate = (Button) findViewById(R.id.calculate);
	symbol = (TextView) findViewById(R.id.symbol);
	//为symbol和calculate设置显示的值
	calculate.setText(R.string.calculate);
	symbol.setText(R.string.symbol);

	//将calculateListener绑定到calculate按键上,使用setOnClickListener方法
	calculate.setOnClickListener(new calculateListener());

	//
	start = (Button ) findViewById(R.id.start);
	stop = (Button ) findViewById(R.id.end);
	start.setOnClickListener(new startOnClickListener());
	stop.setOnClickListener(new stopOnClickListener());
    }
	class calculateListener implements OnClickListener{
		@Override
		public void onClick(View v)
		{
			//取得两个EditText控件的值,使用EditText类的getText方法
			String string_factorOne = FactorOne.getText().toString();
			String string_factorTwo = FactorTwo.getText().toString();

			//将两个值存放的intent对象中
			Intent intent = new Intent();
			intent.putExtra("one",string_factorOne );
			intent.putExtra("two",string_factorTwo);
			//设置intent要启动那个activity，使用setClass方法
			intent.setClass(kongjianActivity.this, resultActivity.class);
			startActivity(intent);
		}
	}

	/*
	用来响应Menu按键
	点击menu按键时就会回调到onCreateOptionsMenu方法
	因此，activity要响应menu按键就要重写这个回调函数；
	*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, 1, 1, "Exit");
		menu.add(0, 2, 2, "About");
		return super.onCreateOptionsMenu(menu);
		
	}

	/*
	要响应menu菜单中的按键，就要重写onOptionsItemSelected这个回调函数
	*/

	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == 1)
			finish();
		return super.onOptionsItemSelected(item);
	}


	class startOnClickListener implements OnClickListener{
		@Override
		public void onClick(View v)
		{
			myhandler.post(progressUpdate);
		}
	}

	class stopOnClickListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			myhandler.removeCallbacks(progressUpdate); 
		}
	}

	private Handler myhandler=new Handler();

	Runnable progressUpdate = new Runnable()
	{
		
		public void run()
		{
			myhandler.postDelayed(progressUpdate, 200);
		}
	};
	
}
