package com.example.snatcherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SnatchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snatch);
		Intent intent = getIntent();
		String message = intent.getStringExtra("com.example.myfirstapp.MESSAGE");
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText("Snatched! : "+message);
		
		setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.snatch, menu);
		return true;
	}

}
