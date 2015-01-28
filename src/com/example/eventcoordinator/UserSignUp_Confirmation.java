package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserSignUp_Confirmation extends Activity{ //ユーザー登録確認

	String upass,uname,uaddress;

	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.usersignup_confirmation);

		Bundle extras = getIntent().getExtras();//違うclassから変数を引き出す

		upass = extras.getString("pass");
		uname = extras.getString("name");
		uaddress = extras.getString("address");

		TextView tv5 = (TextView) findViewById(R.id.textView5); //pass
		tv5.setText(extras.getString("pass") );

		TextView tv12 = (TextView) findViewById(R.id.textView12); //name
		tv12.setText(extras.getString("name") );

		TextView tv14 = (TextView) findViewById(R.id.textView14); //address
		tv14.setText(extras.getString("address") );



		Button b1 = (Button) findViewById(R.id.button1); //ユーザー登録確認へ
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(UserSignUp_Confirmation.this,FriendActivity.class); //intent…画面遷移

				MyAsyncHttpClientUser myAsyncHttpClientuser;
				myAsyncHttpClientuser = new MyAsyncHttpClientUser(getApplicationContext());
				myAsyncHttpClientuser.newRequestParams();

				myAsyncHttpClientuser.setParams("uname_id",uname);
				myAsyncHttpClientuser.setParams("uaddress_id",uaddress);
				myAsyncHttpClientuser.setParams("password_id",upass);
				myAsyncHttpClientuser.access();

				startActivity(intent);

			}
		});
	}

}
