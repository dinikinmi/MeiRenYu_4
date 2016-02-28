package com.example.meirenyu_4;

import UIhandleClass.Turtorial_Lv_Adp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TurtorialVedioFrame extends Activity
{public Turtorial_Lv_Adp turial_lv_adp;
 public ListView turtorial_lv;

	
	@Override
	public void onCreate(Bundle b)
    {super.onCreate(b);
    
    setContentView(R.layout.tutorial);
     turial_lv_adp=new Turtorial_Lv_Adp(this);
     turtorial_lv=(ListView)findViewById(R.id.tur_lv_lv);
     turtorial_lv.setAdapter(turial_lv_adp);
     turial_lv_adp.notifyDataSetChanged();
	}

	
	
}
