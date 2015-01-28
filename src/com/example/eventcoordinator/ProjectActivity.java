package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ProjectActivity extends Activity{
	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);

		getWindow().setTitle("Project"); //タイトル

		Button b1 = (Button) findViewById(R.id.button1); //アンケート作成
		b1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO 自動生成されたメソッド・スタブ
					Intent intent = new Intent(ProjectActivity.this,Questionnaire_Form.class); //intent…画面遷移
					startActivity(intent);
				}
		});

		Button b3 = (Button) findViewById(R.id.button3); //友人
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(ProjectActivity.this,FriendActivity.class); //intent…画面遷移
				startActivity(intent);

			}
		});

		Button b4 = (Button) findViewById(R.id.button4); //プロジェクト
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(ProjectActivity.this,ProjectActivity.class); //intent…画面遷移
				startActivity(intent);
			}
		});

		Button b5 = (Button) findViewById(R.id.button5); //カレンダーへ
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				//Intent intent = new Intent(ProjectActivity.this,CalendarActivity.class); //intent…画面遷移
				//startActivity(intent);
			}
		});


	}
	public boolean onOptionsItemSelected (MenuItem item){ //アプリケーションアイコンのクリック
		Intent intent = new Intent(ProjectActivity.this,FriendActivity.class); //メニューへ
		startActivity(intent);
		return super.onContextItemSelected(item);
	}
}
