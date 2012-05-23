package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import com.example.helloworld.*;

public class childActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child);
	TextView tView = (TextView) findViewById(R.id.childTextViewId);
	tView.setText(R.string.author);
    }
}

