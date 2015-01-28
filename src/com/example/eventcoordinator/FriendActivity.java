package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FriendActivity extends Activity{
	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend);

		getWindow().setTitle("Friend"); //タイトル

		Button b1 = (Button) findViewById(R.id.button1); //友人登録
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(FriendActivity.this,Friend_Form.class); //intent…画面遷移
				startActivity(intent);
			}
		}
	);

		Button b3 = (Button) findViewById(R.id.button3); //友人
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(FriendActivity.this,FriendActivity.class); //intent…画面遷移
				startActivity(intent);

			}
		});

		Button b4 = (Button) findViewById(R.id.button4); //プロジェクト
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(FriendActivity.this,ProjectActivity.class); //intent…画面遷移
				startActivity(intent);
			}
		});

		Button b5 = (Button) findViewById(R.id.button5); //カレンダーへ
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				//Intent intent = new Intent(FriendActivity.this,CalendarActivity.class); //intent…画面遷移
				//startActivity(intent);
			}
		});
}

	public boolean onOptionsItemSelected (MenuItem item){ //アプリケーションアイコンのクリック
		Intent intent = new Intent(FriendActivity.this,FriendActivity.class); //タイトルへ
		startActivity(intent);
		return super.onContextItemSelected(item);
	}



	public boolean onCreateOptionsMenu(Menu menu){

		//getMenuInflater().iinflate(R.metu.main,menu); //メニューーのレイアウトファイルを読み込む

		MenuItem item = menu.add(Menu.NONE,Menu.FIRST,20,"＋");
		MenuItemCompat.setShowAsAction(item,MenuItemCompat.SHOW_AS_ACTION_ALWAYS);


		return true;
	}
}