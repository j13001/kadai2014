package com.example.eventcoordinator;

import org.apache.http.auth.AuthSchemeRegistry;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;



public class MyAsyncHttpClient extends AsyncHttpClient{ //サーバ接続のクラス sheet用（アンケート）
		final String MY_URL = "http://c09006.sangi01.net/post.php";
		//final String MY_URL = "http://c09006.sangi01.net/MyAdmin.php";
		//URL

		RequestParams params;      //送信パラメータ
		MyAsyncHttpResponseHandler myAsyncHttpResponseHandler = new MyAsyncHttpResponseHandler();

		public MyAsyncHttpClient(Context context) {
			myAsyncHttpResponseHandler.setContext(context);
		}

		@Override
		public RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
			//Ajaxによるアクセスかどうかといった判定処理
			return super.post(url, params, responseHandler);
		}

		public void setParams(String id,String str) {
			// WEB側と合わせる post.phpの置く場所
			params.put(id, str); //追加

		}
		public void newRequestParams() {  //パラメータの初期化
			params = new RequestParams();
		}
		public RequestHandle access() {
			return post(MY_URL, params, myAsyncHttpResponseHandler);
		}

		protected AuthSchemeRegistry createAuthSchemeRegistry() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
}

//判定トースト
	class MyAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
		Context context;
		public void setContext(Context context) {
			this.context = context;
		}

		@Override
		public void onFinish() {
			Toast.makeText(context, "Finish", Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onStart() {
		}
		@Override
		public void onFailure(int arg0, org.apache.http.Header[] arg1, byte[] arg2,
			Throwable arg3) {
		// TODO 自動生成されたメソッド・スタブ
		Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();

	}
	@Override
	public void onSuccess(int arg0, org.apache.http.Header[] arg1, byte[] arg2) {
		// TODO 自動生成されたメソッド・スタブ
		Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
	}
}
