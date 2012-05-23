package com.example.kongjian;

import android.app.Activity;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;

public class resultActivity extends Activity
{
	private TextView rsltView;
	private Button backBtn;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

	//get the text view
	rsltView = (TextView) findViewById(R.id.result);

	//get intent 
	Intent intent = getIntent();
	String firstStr=intent.getStringExtra("one");
	String secStr = intent.getStringExtra("two");

	//get the integer value from String by Integer`s static method parseInt()
	int firstInt = Integer.parseInt(firstStr);
	int secInt = Integer.parseInt(secStr);

	//¼ÆËã³Ë»ý
	int result = firstInt * secInt;

	rsltView.setText(result+"");

	backBtn = (Button) findViewById(R.id.resultButton);
	backBtn.setText(R.string.backButton);
	backBtn.setOnClickListener(new resultListener());
    }

	class resultListener implements OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			finish();
		}
	}
}
