package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_SignUp  extends Activity{
	Toast toast;


	public void onCreate (Bundle savedInstanceState){//ユーザ登録
		super. onCreate(savedInstanceState);
		setContentView(R.layout.user_singup);
		toast=Toast.makeText(this, "パスワードが違います", Toast.LENGTH_LONG );


		Button b1 = (Button) findViewById(R.id.button1); //ユーザー登録確認へ
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				EditText ed2 = (EditText) findViewById(R.id.editText2); //pass
				EditText ed3 = (EditText) findViewById(R.id.editText3); //pass
				EditText ed4 = (EditText) findViewById(R.id.editText4); //名前
				EditText ed5 = (EditText) findViewById(R.id.editText5); //アドレス

				//if(ed2.getText().toString() == ed3.getText().toString()){

					Intent intent = new Intent(User_SignUp.this,UserSignUp_Confirmation.class); //intent…画面遷移

					intent.putExtra("pass",ed2.getText().toString());
					intent.putExtra("name",ed4.getText().toString());
					intent.putExtra("address",ed5.getText().toString());

					startActivity(intent);
				//}else{

					//toast.show();

				//}

			}
		});

	}


}
