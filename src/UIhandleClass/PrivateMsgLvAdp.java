package UIhandleClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meirenyu_4.R;
import com.example.meirenyu_4.Talking;
import com.example.meirenyu_4.UserDetailsAct;

public class PrivateMsgLvAdp extends BaseAdapter
{ public Context context;
  public ItemBox itemBox;	

	public PrivateMsgLvAdp(Context context)
	{this.context=context;
	}
	
	public class ItemBox
	{public TextView posterName;
	 public TextView msgContent;
	 public ImageView posterAvatar;
		
	}
	
	@Override
	public int getCount()
   {return 10;
	}

	@Override
	public Object getItem(int arg0)
	{
		
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2)
	{ itemBox=new ItemBox();
		if(convertView==null)
	{convertView=(View)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.prm_msg_lv_item,null);
	 itemBox.msgContent=(TextView)convertView.findViewById(R.id.prmLvItem_msgContent_tv);
	 itemBox.posterAvatar=(ImageView)convertView.findViewById(R.id.prmLvItem_avatar_iv);
	 itemBox.posterName=(TextView)convertView.findViewById(R.id.prmLvItem_posterName_tv);
	 convertView.setTag(itemBox);
	}else
	{itemBox=(ItemBox)convertView.getTag();}
		 itemBox.posterAvatar.setOnClickListener(new OnClickListener()
		  {@Override
			  public void onClick(View v)
		   	  {Intent gotoUserDetails=new Intent(context,UserDetailsAct.class);
			    context.startActivity(gotoUserDetails);
		   	  }
		  });
		 convertView.setOnClickListener(new OnClickListener()
		 {@Override
			 public void onClick(View v)
		     {Intent gotoTalking=new Intent(context,Talking.class);
			  context.startActivity(gotoTalking);
		     }
			 
		 }
		 );
		 
		 
		
		
		
		return convertView;
	}
 
}
