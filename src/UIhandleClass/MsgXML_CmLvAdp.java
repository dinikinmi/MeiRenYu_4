package UIhandleClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meirenyu_4.R;
import com.example.meirenyu_4.UserDetailsAct;


public class MsgXML_CmLvAdp extends BaseAdapter
{Context context;

public class ItemBox
  {public ImageView avatar;
   public TextView posterName;
   public TextView time;
   public TextView cmContent;
   public Button reply_bt;
   public ImageView vedioCover;
   public TextView vedioDiscription;
   }


public MsgXML_CmLvAdp(Context context)
{this.context=context;
}

@Override
public int getCount() {
	
	return 10;
}

@Override
public Object getItem(int arg0) {
	
	return null;
}

@Override
public long getItemId(int arg0) {
	
	return 0;
}

@Override
public View getView(int position, View convertView, ViewGroup arg2)
{ ItemBox itemBox=new ItemBox();
  if(convertView==null)
  {convertView=(View)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.msg_cm_lv_item,null);
   itemBox.avatar=(ImageView)convertView.findViewById(R.id.msgCL_item_avatar_iv);
   itemBox.cmContent=(TextView)convertView.findViewById(R.id.msgCL_item_cmContent_tv);
   itemBox.posterName=(TextView)convertView.findViewById(R.id.msgCL_item_senderName_tv);
   itemBox.reply_bt=(Button)convertView.findViewById(R.id.msgCL_item_reply_bt);
   itemBox.time=(TextView)convertView.findViewById(R.id.msgCL_item_time_tv);
   itemBox.vedioCover=(ImageView)convertView.findViewById(R.id.msgCL_item_vdCover_iv);
   itemBox.vedioDiscription=(TextView)convertView.findViewById(R.id.msgCL_item_vdDiscription_tv);
   convertView.setTag(itemBox);
  }else
  {itemBox=(ItemBox)convertView.getTag();
  }
   itemBox.avatar.setOnClickListener(new OnClickListener()
   {@Override
	   public void onClick(View v)
       {Intent goToDetails=new Intent(context,UserDetailsAct.class);
         context.startActivity(goToDetails);
          
       }
	   
	   
   }
		   )
   ;
	
	return convertView;
}


}
