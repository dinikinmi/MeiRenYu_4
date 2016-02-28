package com.example.meirenyu_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;



public class PlayVedioAct extends Activity {

	private FrameLayout mFullscreenContainer;
	private FrameLayout mContentView;
	private View mCustomView = null;
	private WebView mWebView;
//	http://v.youku.com/v_show/id_XMTM0NzM4NzYxNg==.html?from=y1.3-idx-uhome-1519-20887.205805-205902.5-1
	
	private String s2222 = "<html><head><meta charset=\"utf-8\" /><title>swf</title></head><body>"
			+ "<embed src=\"http://v.youku.com/v_show/id_XMTM0NzM4NzYxNg==.html?from=y1.3-idx-uhome-1519-20887.205805-205902.5-1"
	
			+ "  width=\"80%\" height=\"80%\" align=\"middle\" allowScriptAccess=\"always\""
			+ " allowFullScreen=\"true\" wmode=\"transparent\" "
			+ "type=\"application/x-shockwave-flash\"> </embed></body></html>";
	
	private String s_3="<html><body>xcxdfdf<embed src=\"http://player.youku.com/player.php/Type/Folder/Fid/26124124/Ob/1/sid/XMTM0NTE3ODgwOA==/v.swf\" quality=\"high\" width=\"480\" height=\"400\" align=\"middle\" allowScriptAccess=\"always\" allowFullScreen=\"true\" mode=\"transparent\" type=\"application/x-shockwave-flash\"></embed><body><html>";
	private String s_4="www.baidu.com";
	
	private String s_2= "<div id=\"youkuplayer\" style=\"width:480px;height:400px\"></div>"+
"<script type=\"text/javascript\" src=\"http:\\player.youku.com/jsapi\">" + "player = new YKU.Player('youkuplayer',{"+
"styleid: '0',client_id: '3e0197e481eae54b',vid: 'XNTM3MzAxMzA4',embsig: 'VERSION_TIMESTAMP_SIGNATURE'"+
"});</script>";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_vedio_webview);

		initViews();
		initWebView();

		if (getPhoneAndroidSDK() >= 14) {// 4.0 需打开硬件加速
			getWindow().setFlags(0x1000000, 0x1000000);
		}

		mWebView.loadData(s_2, "text/html; charset=UTF-8", null);
//		mWebView.loadUrl("file:///android_asset/1234.html");
	}

	private void initViews() {
		mFullscreenContainer = (FrameLayout) findViewById(R.id.fullscreen_custom_content);
		mContentView = (FrameLayout) findViewById(R.id.main_content);
		mWebView = (WebView) findViewById(R.id.webview_player);

	}

	private void initWebView() {
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setPluginState(PluginState.ON);
		// settings.setPluginsEnabled(true);
		settings.setAllowFileAccess(true);
		settings.setLoadWithOverviewMode(true);

		mWebView.setWebChromeClient(new MyWebChromeClient());
		mWebView.setWebViewClient(new MyWebViewClient());
	}

	class MyWebChromeClient extends WebChromeClient {

		private CustomViewCallback mCustomViewCallback;
		private int mOriginalOrientation = 1;

		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			// TODO Auto-generated method stub
			onShowCustomView(view, mOriginalOrientation, callback);
			super.onShowCustomView(view, callback);

		}

		public void onShowCustomView(View view, int requestedOrientation,
				WebChromeClient.CustomViewCallback callback) {
			if (mCustomView != null) {
				callback.onCustomViewHidden();
				return;
			}
			if (getPhoneAndroidSDK() >= 14) {
				mFullscreenContainer.addView(view);
				mCustomView = view;
				mCustomViewCallback = callback;
				mOriginalOrientation = getRequestedOrientation();
				mContentView.setVisibility(View.INVISIBLE);
				mFullscreenContainer.setVisibility(View.VISIBLE);
				mFullscreenContainer.bringToFront();

				setRequestedOrientation(mOriginalOrientation);
			}

		}

		public void onHideCustomView() {
			mContentView.setVisibility(View.VISIBLE);
			if (mCustomView == null) {
				return;
			}
			mCustomView.setVisibility(View.GONE);
			mFullscreenContainer.removeView(mCustomView);
			mCustomView = null;
			mFullscreenContainer.setVisibility(View.GONE);
			try {
				mCustomViewCallback.onCustomViewHidden();
			} catch (Exception e) {
			}
			// Show the content view.

			setRequestedOrientation(mOriginalOrientation);
		}

	}

	class MyWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

	public static int getPhoneAndroidSDK() {
		// TODO Auto-generated method stub
		int version = 0;
		try {
			version = Integer.valueOf(android.os.Build.VERSION.SDK);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return version;

	}

	@Override
	public void onPause() {// 继承自Activity
		super.onPause();
		mWebView.onPause();
	}

	@Override
	public void onResume() {// 继承自Activity
		super.onResume();
		mWebView.onResume();
	}
}