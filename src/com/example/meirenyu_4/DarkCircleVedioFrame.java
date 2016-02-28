package com.example.meirenyu_4;

import UIhandleClass.Turtorial_Lv_Adp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DarkCircleVedioFrame extends Activity
{public Turtorial_Lv_Adp darkCircle_lv_adp;
 public ListView darkCircle_lv;

	
	@Override
	public void onCreate(Bundle b)
    {super.onCreate(b);
    
     setContentView(R.layout.dark_circle);
     darkCircle_lv_adp=new Turtorial_Lv_Adp(this);
     darkCircle_lv=(ListView)findViewById(R.id.dc_lv_lv);
     darkCircle_lv.setAdapter(darkCircle_lv_adp);
     darkCircle_lv_adp.notifyDataSetChanged();
	}

}
