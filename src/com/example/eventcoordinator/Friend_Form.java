package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Friend_Form  extends Activity{

	public void onCreate (Bundle savedInstanceState){//ユーザ登録
		super. onCreate(savedInstanceState);
		setContentView(R.layout.friend_form);

		Button b1 = (Button) findViewById(R.id.button1); //ユーザー登録確認へ
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(Friend_Form.this,Friend_Confirmation.class); //intent…画面遷移

				EditText ed1 = (EditText) findViewById(R.id.editText1); //ID
				intent.putExtra("ID",ed1.getText().toString());

				EditText ed2 = (EditText) findViewById(R.id.editText2); //名前
				intent.putExtra("name",ed2.getText().toString());

			
				startActivity(intent);

			}

		});}


		public boolean onOptionsItemSelected (MenuItem item){ //アプリケーションアイコンのクリック
			Intent intent = new Intent(Friend_Form.this,FriendActivity.class); //メニューへ
		startActivity(intent);
		return super.onContextItemSelected(item);
	}
}
