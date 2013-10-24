package com.example.testapplication;

import java.net.URI;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendMessage(View view)
    {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    
    	intent.putExtra(EXTRA_MESSAGE, message); //EXTRA_MESSAGE is the tag we need to filter on to intercept!
    	startActivity(intent);
    }
    public void sendMessageIPC(View view)
    {
    	
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	Intent intent = new Intent();
    	intent.setAction("SPECIAL");
    	Uri payload = Uri.parse("text://lol");
    	intent.setData(payload);
    	
    	intent.putExtra(EXTRA_MESSAGE, message); //EXTRA_MESSAGE is the tag we need to filter on to intercept!
    
    	PackageManager packageManager = getPackageManager();
    	
    	List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
    	boolean isIntentSafe = activities.size() > 0;
    	if (isIntentSafe)
    	{
    	startActivity(intent);
    	}
    	
    	else
    	{
    		Intent intent2 = new Intent(this, DisplayMessageActivity.class);    
        	intent2.putExtra(EXTRA_MESSAGE, "FAILED TO BROADCAST"); //EXTRA_MESSAGE is the tag we need to filter on to intercept!
        	startActivity(intent2);
    	}
    	
    }
    
   }
    
    

