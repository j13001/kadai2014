package com.example.eventcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questionnaire_Confirmation  extends Activity {

	String evname,evcontent,dpd1,dpd2,dpd3,location,stime;

	public void onCreate(Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.questionnaire_confirmation);

		Bundle extras = getIntent().getExtras();//違うclassから変数を引き出す
		evname = extras.getString("evname");
		evcontent = extras.getString("evcontent");
		dpd1 = extras.getString("datePickerDialog1");
		dpd2 = extras.getString("datePickerDialog2");
		dpd3 = extras.getString("datePickerDialog3");
		location = extras.getString("location");
		stime = extras.getString("time");


		Button b = (Button) findViewById(R.id.button1); //確定
		b.setOnClickListener(new View.OnClickListener() {
			@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ

			MyAsyncHttpClient myAsyncHttpClient;
			myAsyncHttpClient = new MyAsyncHttpClient(getApplicationContext());
			myAsyncHttpClient.newRequestParams();

			//aa��bb��web���ƍ��킹��
			myAsyncHttpClient.setParams("evname_id",evname);	//飛ばす場所,飛ばす値
			myAsyncHttpClient.setParams("evcontent_id",evcontent);
			myAsyncHttpClient.setParams("day1_id",dpd1);
			myAsyncHttpClient.setParams("day2_id",dpd2);
			myAsyncHttpClient.setParams("day3_id",dpd3);
			myAsyncHttpClient.setParams("location_id",location);
			myAsyncHttpClient.setParams("stime_id",stime);
			myAsyncHttpClient.access();




			Intent intent = new Intent(Questionnaire_Confirmation.this,FriendActivity.class); //intent…画面遷移
			startActivity(intent);
			}
		});

		TextView tv3 = (TextView) findViewById(R.id.textView3); //イベント名
		tv3.setText(evname);

		TextView tv5 = (TextView) findViewById(R.id.textView5); //イベント内容
		tv5.setText(evcontent );

		TextView tv8 = (TextView) findViewById(R.id.textView8); //希望日1
		tv8.setText(dpd1);

		TextView tv10 = (TextView) findViewById(R.id.textView10); //希望日2
		tv10.setText(dpd2);

		TextView tv12 = (TextView) findViewById(R.id.textView12); //希望日3
		tv12.setText(dpd3);

		TextView tv14 = (TextView) findViewById(R.id.textView14); //場所
		tv14.setText(location);

		TextView tv16 = (TextView) findViewById(R.id.textView16); //時間
		tv16.setText(stime);


	}
}

