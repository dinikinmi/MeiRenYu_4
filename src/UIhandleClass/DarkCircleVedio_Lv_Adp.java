package UIhandleClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meirenyu_4.R;
import com.example.meirenyu_4.UserDetailsAct;

public class DarkCircleVedio_Lv_Adp extends BaseAdapter
{
	Context contextFromCallingActivity;
	
	
	public class ItemBox
	{ImageView vedioCover_left;
	 TextView vedioTitle_left;
	 TextView tvDiscription_left;
	 ImageButton playButton_left;
	 TextView playTimes_left;
	 ImageButton likeButton_left;
	 TextView likeTimes_left;
	 ImageButton avatar_left;
	 TextView uploadName_left;
	 
	 ImageView vedioCover_right;
	 TextView vedioTitle_right;
	 TextView tvDiscription_right;
	 ImageButton playButton_right;
	 TextView playTimes_right;
	 ImageButton likeButton_right;
	 TextView likeTimes_right;
	 ImageButton avatar_right;
	 TextView uploadName_right;
	 
	}
	
	
	public DarkCircleVedio_Lv_Adp(Context context)
	{this.contextFromCallingActivity=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
	 if( convertView==null)
	   {LayoutInflater layoutInf=(LayoutInflater)contextFromCallingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView=(View)layoutInf.inflate(R.layout.dark_circle_lv_item, null);
		itemBox.avatar_left=(ImageButton)convertView.findViewById(R.id.dcLvItem_avatar_left_ib);
//		itemBox.avatar_right=(ImageButton)convertView.findViewById(R.id.dcLvItem_avatar_right_ib);
		itemBox.likeButton_left=(ImageButton)convertView.findViewById(R.id.dcLvItem_likeBt_left_tv);
		itemBox.likeTimes_left=(TextView)convertView.findViewById(R.id.dcLvItem_likeTimes_left_tv);
		itemBox.playButton_left=(ImageButton)convertView.findViewById(R.id.dcLvItem_playBt_left_ib);
		itemBox.playTimes_left=(TextView)convertView.findViewById(R.id.dcLvItem_playTimes_left_tv);
		itemBox.tvDiscription_left=(TextView)convertView.findViewById(R.id.dcLvItem_vdDiscription_left_tv);
		itemBox.uploadName_left=(TextView)convertView.findViewById(R.id.dcLvItem_uploaderName_left_tv);
		itemBox.vedioCover_left=(ImageView)convertView.findViewById(R.id.dcLvItem_vdCover_left_iv);
		itemBox.vedioTitle_left=(TextView)convertView.findViewById(R.id.dcLvItem_vdTitle_left_tv);
		
		
		itemBox.avatar_right=(ImageButton)convertView.findViewById(R.id.dcLvItem_avatar_right_ib);
//		itemBox.avatar_right=(ImageButton)convertView.findViewById(R.id.dcLvItem_avatar_right_ib);
		itemBox.likeButton_right=(ImageButton)convertView.findViewById(R.id.dcLvItem_likeBt_right_ib);
		itemBox.likeTimes_right=(TextView)convertView.findViewById(R.id.dcLvItem_likeTimes_right_tv);
		itemBox.playButton_right=(ImageButton)convertView.findViewById(R.id.dcLvItem_playBt_right_ib);
		itemBox.playTimes_right=(TextView)convertView.findViewById(R.id.dcLvItem_playTimes_right_tv);
		itemBox.tvDiscription_right=(TextView)convertView.findViewById(R.id.dcLvItem_vdDiscription_right_tv);
		itemBox.uploadName_right=(TextView)convertView.findViewById(R.id.dcLvItem_uploaderName_right_tv);
		itemBox.vedioCover_right=(ImageView)convertView.findViewById(R.id.dcLvItem_vdCover_right_iv);
		itemBox.vedioTitle_right=(TextView)convertView.findViewById(R.id.dcLvItem_vdTitle_right_tv);
		
		convertView.setTag(itemBox);
	   }else
	   {itemBox=(ItemBox)convertView.getTag();}
	 itemBox.avatar_right.setOnClickListener(new OnClickListener()
	  {@Override
		  public void onClick(View v)
	   	  {Intent gotoUserDetails=new Intent(contextFromCallingActivity,UserDetailsAct.class);
		    contextFromCallingActivity.startActivity(gotoUserDetails);
	   	  }
	  });
		
	 itemBox.avatar_left.setOnClickListener(new OnClickListener()
	  {@Override
		  public void onClick(View v)
	   	  {Intent gotoUserDetails=new Intent(contextFromCallingActivity,UserDetailsAct.class);
		    contextFromCallingActivity.startActivity(gotoUserDetails);
	   	  }
	  });
		
		return convertView;
	}
	

}
