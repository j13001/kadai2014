package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Friend_Confirmation extends Activity{

	public void onCreate (Bundle savedInstanceState){//ユーザ登録
		super. onCreate(savedInstanceState);
		setContentView(R.layout.friend_confirmation);

		Button b1 = (Button) findViewById(R.id.button1); //ユーザー登録確認へ
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(Friend_Confirmation.this,FriendActivity.class); //intent…画面遷移
				startActivity(intent);

			}
		});

		TextView tv1 = (TextView) findViewById(R.id.textView1); //ID
		Bundle extras = getIntent().getExtras();//違うclassから変数を引き出す
		tv1.setText(extras.getString("ID") );

		TextView tv2 = (TextView) findViewById(R.id.textView2); //pass
		tv2.setText(extras.getString("name") );

		TextView tv3 = (TextView) findViewById(R.id.textView3); //name
		tv3.setText(extras.getString("address") );

		TextView tv4 = (TextView) findViewById(R.id.textView4); //address
		tv4.setText(extras.getString("tell") );

		TextView tv5 = (TextView) findViewById(R.id.textView5); //address
		tv5.setText(extras.getString("relationship") );

	}


}
