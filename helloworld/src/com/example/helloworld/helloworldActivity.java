package com.example.helloworld;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.*;
import java.util.HashMap;
import java.util.ArrayList;

public class helloworldActivity extends ListActivity
{
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		HashMap<String,String> map1 = new HashMap<String,String>();
		HashMap<String,String> map2 = new HashMap<String,String>();
		HashMap<String,String> map3 = new HashMap<String,String>();

		map1.put("user_name", "Amlogic");
		map1.put("user_ip", "10.10.1.1");

		map2.put("user_name", "Amlogic_BJ");
		map2.put("user_ip", "10.10.1.2");

		map3.put("user_name", "Amlogic_SH");
		map3.put("user_ip", "10.10.1.2");

		list.add(map1);
		list.add(map2);
		list.add(map3);

		SimpleAdapter listAdapter = new SimpleAdapter(this, list, R.layout.list_item, 
																						new String[] {"user_name", "user_ip"},
																						new int[] {R.id.user_name, R.id.user_ip});

		setListAdapter(listAdapter);
    }
}
