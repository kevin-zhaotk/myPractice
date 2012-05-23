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
	//�����ĸ��ؼ��ı���
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
	//ͨ���ؼ�ID��ȡ�ؼ�
	FactorOne = (EditText) findViewById(R.id.first);
	FactorTwo = (EditText) findViewById(R.id.second);
	calculate = (Button) findViewById(R.id.calculate);
	symbol = (TextView) findViewById(R.id.symbol);
	//Ϊsymbol��calculate������ʾ��ֵ
	calculate.setText(R.string.calculate);
	symbol.setText(R.string.symbol);

	//��calculateListener�󶨵�calculate������,ʹ��setOnClickListener����
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
			//ȡ������EditText�ؼ���ֵ,ʹ��EditText���getText����
			String string_factorOne = FactorOne.getText().toString();
			String string_factorTwo = FactorTwo.getText().toString();

			//������ֵ��ŵ�intent������
			Intent intent = new Intent();
			intent.putExtra("one",string_factorOne );
			intent.putExtra("two",string_factorTwo);
			//����intentҪ�����Ǹ�activity��ʹ��setClass����
			intent.setClass(kongjianActivity.this, resultActivity.class);
			startActivity(intent);
		}
	}

	/*
	������ӦMenu����
	���menu����ʱ�ͻ�ص���onCreateOptionsMenu����
	��ˣ�activityҪ��Ӧmenu������Ҫ��д����ص�������
	*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, 1, 1, "Exit");
		menu.add(0, 2, 2, "About");
		return super.onCreateOptionsMenu(menu);
		
	}

	/*
	Ҫ��Ӧmenu�˵��еİ�������Ҫ��дonOptionsItemSelected����ص�����
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
