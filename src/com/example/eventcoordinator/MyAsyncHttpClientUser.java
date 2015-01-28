package com.example.eventcoordinator;

import org.apache.http.auth.AuthSchemeRegistry;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

public class MyAsyncHttpClientUser 	extends AsyncHttpClient{ //サーバ接続のクラス user
	 String MY_URL = "http://c09006.sangi01.net/userpost.php";
	//URL

	RequestParams params;      //送信パラメータ
	MyAsyncHttpResponseHandler myAsyncHttpResponseHandler = new MyAsyncHttpResponseHandler();

	public  MyAsyncHttpClientUser (Context context) {
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

