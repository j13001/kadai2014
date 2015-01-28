package com.example.eventcoordinator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity{
	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		//setContentView(R.layout.);

		getWindow().setTitle("Menu"); //タイトル

		Button b1 = (Button) findViewById(R.id.button1); //友人
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(MenuActivity.this,FriendActivity.class); //intent…画面遷移
				startActivity(intent);

			}
		});

		Button b2 = (Button) findViewById(R.id.button2); //プロジェクト
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(MenuActivity.this,ProjectActivity.class); //intent…画面遷移
				startActivity(intent);
			}
		});

		Button b3 = (Button) findViewById(R.id.button3); //カレンダーへ
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				//Intent intent = new Intent(MenuActivity.this,FriendActivity.class); //intent…画面遷移
				//startActivity(intent);
			}
		});

		ActionBar actionBar = getActionBar();  //アクションバー
		actionBar.show();
		actionBar.setDisplayHomeAsUpEnabled(true); //前画面に戻るアイコン
		actionBar.setHomeButtonEnabled(true);  //アプリケーションアイコンのクリック

	}

	public boolean onOptionsItemSelected (MenuItem item){ //アプリケーションアイコンのクリック
		Intent intent = new Intent(MenuActivity.this,MenuActivity.class); //メニューへ
		startActivity(intent);
		return super.onContextItemSelected(item);
	}

	public boolean onCreateOptionsMenu(Menu menu){

		//getMenuInflater().iinflate(R.metu.main,menu); //メニューーのレイアウトファイルを読み込む

		MenuItem item = menu.add(Menu.NONE,Menu.FIRST,20,"ヘルプ");
		MenuItemCompat.setShowAsAction(item,MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
}
