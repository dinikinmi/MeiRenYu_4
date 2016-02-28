package UIhandleClass;

import com.example.meirenyu_4.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MsgXML_NoticeLvAdp extends BaseAdapter
{
	public Context context;
	
	
  public class ItemBox
  {ImageView bell_iv;
   TextView time_tv;
   TextView content_tv;	  
  }
	
  public MsgXML_NoticeLvAdp(Context context)
  {this.context=context;  
  }
  
	@Override
	public int getCount()
	{
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
	public View getView(int position, View convertView, ViewGroup arg2) {
		ItemBox itemBox=new ItemBox();
		if(convertView==null)
		{LayoutInflater layoutInfl= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 convertView=(View)layoutInfl.inflate(R.layout.msg_notification_lv_item,null);
		 itemBox.bell_iv=(ImageView)convertView.findViewById(R.id.mnli_bell_iv);
		 itemBox.content_tv=(TextView)convertView.findViewById(R.id.mnli_content_tv);
		 itemBox.time_tv=(TextView)convertView.findViewById(R.id.mnli_time_tv);
		 convertView.setTag(itemBox);
		}else
		{itemBox=(ItemBox)convertView.getTag();}
		
		
		
		return convertView;
	}

}
