package com.example.meirenyu_4;

import android.app.Activity;
import android.content.Context;

import com.youku.player.YoukuPlayerConfiguration;

public class MyApplication extends YoukuPlayerConfiguration 
{

	public MyApplication(Context applicationContext) {
		super(applicationContext);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String configDownloadPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Activity> getCachedActivityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Activity> getCachingActivityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotifyLayoutId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
