package UIhandleClass;

import java.util.ArrayList;

import com.example.meirenyu_4.R;

import DataContainer.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TalkingLv_Adp extends BaseAdapter
{
  public Context context;
  public ArrayList<Dialog> dialogList;
  
  public class ItemBox
   {public TextView content_tv;
    public ImageView leftAvatar_iv;
    public ImageView rightAvatar_iv;
    }
  
  public TalkingLv_Adp(Context context,ArrayList<Dialog> dialogList)
  {this.context=context;
   this.dialogList=dialogList;
   
  }
  
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dialogList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) 
	{ItemBox itemBox=new ItemBox();
	 
		if(convertView==null)
	    {convertView=(View)((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.talking_lv_item, null);
 	    itemBox.content_tv=(TextView)convertView.findViewById(R.id.tkLv_item_content_tv);
	    itemBox.rightAvatar_iv=(ImageView)convertView.findViewById(R.id.tkLv_item_rightAvatar_iv);
		itemBox.leftAvatar_iv=(ImageView)convertView.findViewById(R.id.tkLv_item_leftAvatar_iv);
		convertView.setTag(itemBox);
	    }else
		{itemBox=(ItemBox)convertView.getTag();}
		
//		itemBox.content_tv.setText(dialogList.get(position).content);
		if(position==0)
		{itemBox.leftAvatar_iv.setVisibility(View.INVISIBLE);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
        lp.gravity=Gravity.RIGHT;
        itemBox.content_tv.setLayoutParams(lp);
        //itemBox.content_tv.setBackgroundColor(Color.YELLOW); 
		itemBox.content_tv.setBackgroundResource(R.drawable.aio_user_bg_nor_11);
		}
		
		if(position==1)
			{itemBox.rightAvatar_iv.setVisibility(View.INVISIBLE);
//             itemBox.content_tv.setBackgroundColor(Color.GREEN);                                        
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
	        lp.gravity=Gravity.LEFT;
	        itemBox.content_tv.setLayoutParams(lp);
	        itemBox.content_tv.setText("111111111111111111111111111111111111111111111112222222222222222");
	        itemBox.content_tv.setBackgroundResource(R.drawable.aio_friend_bg_nor_11);
			
			}
		return convertView;
	}

}
