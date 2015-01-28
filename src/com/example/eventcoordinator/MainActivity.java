package com.example.eventcoordinator;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	WallpaperManager mWallpaperManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mWallpaperManager = WallpaperManager.getInstance(this);

		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view){
				Intent intent1 = new Intent(MainActivity.this,LoginActivity.class); //intent…画面遷移
				startActivity(intent1);
			}
	});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onClickEvent(View v){
		try{
			mWallpaperManager.setResource(R.drawable.ic_launcher);
		}
		catch(IOException e){
				e.printStackTrace();
		}
	}
}
