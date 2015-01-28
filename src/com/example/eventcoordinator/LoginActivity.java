package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity  extends Activity{
	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);


		Button b1 = (Button) findViewById(R.id.button1); //friendActivityへ
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(LoginActivity.this,FriendActivity.class); //intent…画面遷移
				startActivity(intent);

			}
		});
		Button b2 = (Button) findViewById(R.id.button2); //usersignypへ
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(LoginActivity.this,User_SignUp.class); //intent…画面遷移
				startActivity(intent);

			}
		});


		getWindow().setTitle("Login"); //タイトル

	}


}
