package com.example.eventcoordinator;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Questionnaire_Form extends Activity{ //アンケート作成フォーム

	//フィールド
	MyAsyncHttpClient myAsyncHttpClient;
	Date day ,day1 ,day2,day3;
	DatePickerDialog  datePickerDialog1 , datePickerDialog2 , datePickerDialog3;
	Toast toast;
	EditText edit1,edit2,edit3;
	TimePickerDialog timepickerdialog;

	public void onCreate (Bundle savedInstanceState){
		super. onCreate(savedInstanceState);
		setContentView(R.layout.questionnaireform); //xml指定

		getWindow().setTitle("QuestionnnaireForm"); //タイトル

		//myAsyncHttpClient = new MyAsyncHttpClient(getApplicationContext()); //php

		EditText ed1 = (EditText) findViewById(R.id.editText1); //イベント名
		ed1.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) { //キーボードを隠す
				if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
					onEnter1();
					return true;
				}
				return false;
			}
		});

		EditText ed2 = (EditText) findViewById(R.id.editText2); //内容
		ed2.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) { //キーボードを隠す
				if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
					onEnter1();
					return true;
				}
				return false;
			}
		});

		EditText ed3 = (EditText) findViewById(R.id.editText3); //場所
		ed3.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) { //キーボードを隠す
				if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
					onEnter1();
					return true;
				}
				return false;
			}
		});


	 // 日付情報の初期設定
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR); // 年
		int month = calendar.get(Calendar.MONTH); // 月 １月が０，１２月が１１
		int day = calendar.get(Calendar.DAY_OF_MONTH); // 日
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute    = calendar.get(Calendar.MINUTE);


	// 日付設定ダイアログの作成・リスナの登録
		datePickerDialog1 = new DatePickerDialog(this, DateSetListener1, year, month, day);
		datePickerDialog2 = new DatePickerDialog(this, DateSetListener2, year, month, day);
		datePickerDialog3 = new DatePickerDialog(this, DateSetListener3, year, month, day);



		//時刻設定ダイアログの作成
		timepickerdialog = new TimePickerDialog(this, onTimeSetListener, hourOfDay, minute, true);


		Button b1 = (Button) findViewById(R.id.button1); //希望日1
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				 // 日付設定ダイアログの表示
			    datePickerDialog1.show();
			}
		}
	);

	Button b2 = (Button) findViewById(R.id.button2); //希望日2
		b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				datePickerDialog2.show();

			}
		}
	);

	Button b3 = (Button) findViewById(R.id.button3); //希望日3
		b3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				datePickerDialog3.show();

			}
	});

	Button b4 = (Button) findViewById(R.id.button4); //時間取得
		b4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				//時刻設定ダイアログの表示
			    timepickerdialog.show();


			}
	});

	Button b5 = (Button) findViewById(R.id.button5); //確認へ
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(Questionnaire_Form.this,Questionnaire_Confirmation.class); //intent…画面遷移

				//画面の違うclassに変数を送る

				EditText ed1 = (EditText) findViewById(R.id.editText1); //イベント名
				intent.putExtra("evname", ed1.getText().toString());

				EditText ed2 = (EditText) findViewById(R.id.editText2); //内容
				intent.putExtra("evcontent", ed2.getText().toString());

				EditText ed3 = (EditText) findViewById(R.id.editText3); //場所
				intent.putExtra("location", ed3.getText().toString());

				TextView tv8 = (TextView) findViewById(R.id.textView8); //希望日1
				intent.putExtra("datePickerDialog1",tv8.getText() );

				TextView tv9 = (TextView) findViewById(R.id.textView9); //希望日2
				intent.putExtra("datePickerDialog2",tv9.getText());

				TextView tv10 = (TextView) findViewById(R.id.textView10); //希望日3
				intent.putExtra("datePickerDialog3",tv10.getText());

				TextView tv11 = (TextView) findViewById(R.id.textView11); //集合時間
				intent.putExtra("time",tv11.getText());




				startActivity(intent);

			}
		});
	}

	public boolean onOptionsItemSelected (MenuItem item){ //アプリケーションアイコンのクリック
		Intent intent = new Intent(Questionnaire_Form.this,MenuActivity.class); //メニューへ
		startActivity(intent);
		return super.onContextItemSelected(item);
	}
	// 日付設定時のリスナ作成
	DatePickerDialog.OnDateSetListener DateSetListener1 = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(android.widget.DatePicker datePicker, int year,
			int monthOfYear, int dayOfMonth) {
			monthOfYear = monthOfYear + 1;

			  TextView tv8 = (TextView) findViewById(R.id.textView8); //希望日1
			tv8.setText(  year +"年" +monthOfYear  + " 月" +  dayOfMonth + " 日" );

	    }
	};
	DatePickerDialog.OnDateSetListener DateSetListener2 = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(android.widget.DatePicker datePicker, int year,
				int monthOfYear, int dayOfMonth) {
			monthOfYear = monthOfYear + 1;
			TextView tv9 = (TextView) findViewById(R.id.textView9); //希望日1
			tv9.setText(  year +"年" +monthOfYear + " 月" +  dayOfMonth + " 日" );
	    }
	};
	DatePickerDialog.OnDateSetListener DateSetListener3 = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(android.widget.DatePicker datePicker, int year,
				int monthOfYear, int dayOfMonth) {
			monthOfYear = monthOfYear + 1;
			TextView tv10 = (TextView) findViewById(R.id.textView10); //希望日1
			tv10.setText(  year +"年" +monthOfYear + " 月" +  dayOfMonth + " 日" );
	    }
	};

	TimePickerDialog dialog;
	TimePickerDialog.OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
	        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	        	TextView tv11 = (TextView) findViewById(R.id.textView11); //時間取得
				tv11.setText(hourOfDay + "時"+ minute + "分");
	        }
	 };



	public void onEnter1(){ //enterを押されたらキーボードを隠す
	      EditText editText1=(EditText)findViewById(R.id.editText1);
	      //システムサービス取得
	      InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	      //hideSoftInputFromWindowキーボードを隠す
	      imm.hideSoftInputFromWindow (editText1.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
}
