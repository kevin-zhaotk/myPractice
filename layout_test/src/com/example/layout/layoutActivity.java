package com.example.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class layoutActivity extends Activity
{
	private RadioGroup rdBtnGrp=null;
	private RadioButton rdBtnFm=null;
	private RadioButton rdBtnM=null;

	private CheckBox chkBox1 = null;
	private CheckBox chkBox2 = null;
	private CheckBox chkBox3 = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		rdBtnGrp = (RadioGroup) findViewById(R.id.radiogrp_sex);
		rdBtnFm = (RadioButton) findViewById(R.id.radioBtn_female);
		rdBtnM = (RadioButton) findViewById(R.id.radioBtn_male);

		/*check box*/
		chkBox1 = (CheckBox) findViewById(R.id.chkBox_love1);
		chkBox2 = (CheckBox) findViewById(R.id.chkBox_love2);
		chkBox3 = (CheckBox) findViewById(R.id.chkBox_love3);
		
		rdBtnGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				if(checkedId == rdBtnFm.getId() )
					Toast.makeText(layoutActivity.this, "female", Toast.LENGTH_SHORT ).show();
				if(checkedId == rdBtnM.getId() )
					Toast.makeText(layoutActivity.this, "male", Toast.LENGTH_SHORT ).show();
			}
		});

		chkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if(isChecked)
					Toast.makeText(layoutActivity.this, "sing checked", Toast.LENGTH_SHORT ).show();
				else
					Toast.makeText(layoutActivity.this, "sing no checked", Toast.LENGTH_SHORT ).show();
			}
		});

		chkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if(isChecked)
					Toast.makeText(layoutActivity.this, "dunce checked", Toast.LENGTH_SHORT ).show();
				else
					Toast.makeText(layoutActivity.this, "dunce no checked", Toast.LENGTH_SHORT ).show();
			}
		});
		chkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if(isChecked)
					Toast.makeText(layoutActivity.this, "ball checked", Toast.LENGTH_SHORT ).show();
				else
					Toast.makeText(layoutActivity.this, "ball no checked", Toast.LENGTH_SHORT ).show();
			}
		});
    }
}
