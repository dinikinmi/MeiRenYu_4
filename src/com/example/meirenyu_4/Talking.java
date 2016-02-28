package com.example.meirenyu_4;

import java.util.ArrayList;

import DataContainer.Dialog;
import UIhandleClass.TalkingLv_Adp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Talking extends Activity
{public ArrayList<Dialog> dialogList;
 public ListView talk_lv;
 public TalkingLv_Adp talkAdp;
	@Override
	public void onCreate(Bundle b)
    {super.onCreate(b);
     setContentView(R.layout.talking_out);
     dialogList=new ArrayList<Dialog>();
     talk_lv=(ListView)findViewById(R.id.tko_dialog_lv);
     talkAdp=new TalkingLv_Adp(this,dialogList);
     talk_lv.setAdapter(talkAdp);
     //fill the talkList
     
     Dialog dialog=new Dialog();
     dialog.content="123";
     dialog.senderId=123;
     dialog.senderName="userName123";
     dialogList.add(dialog);
    
     dialog=new Dialog();
     dialog.content="234";
     dialog.senderId=234;
     dialog.senderName="userName234";
     dialogList.add(dialog);
     talkAdp.notifyDataSetChanged();
     
    }
}