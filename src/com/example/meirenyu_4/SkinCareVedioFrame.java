package com.example.meirenyu_4;

import UIhandleClass.SkinCareVedio_Lv_Adp;
import UIhandleClass.Turtorial_Lv_Adp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SkinCareVedioFrame extends Activity
{public SkinCareVedio_Lv_Adp skinCare_lv_adp;
 public ListView skinCare_lv;
	
	@Override
	public void onCreate(Bundle b)
    {super.onCreate(b);
     setContentView(R.layout.skin_care_vedio_lv);
     skinCare_lv_adp=new SkinCareVedio_Lv_Adp(this);
     skinCare_lv=(ListView)findViewById(R.id.skinCare_lv_lv);
     skinCare_lv.setAdapter(skinCare_lv_adp);
     skinCare_lv_adp.notifyDataSetChanged();
	}

	
	
}