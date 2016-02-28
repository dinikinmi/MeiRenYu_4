package UIhandleClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meirenyu_4.R;
import com.example.meirenyu_4.UserDetailsAct;
import com.example.meirenyu_4.VedioDetailsAct;

public class RecommendLvAdp extends BaseAdapter
{   Context context;
    LayoutInflater inflater;
    public ItemBox itemBox;
    
    public class ItemBox
    {public ImageView posterAvatar;
     public TextView posterName;
     public TextView postTime;
     public ImageButton moreButton;
     public ImageView coverPic;
     public ImageView triangleShapePic;
     public TextView title;
     public TextView discription;
     public TextView likeTimes;
     public TextView playTimes;
     public TextView cmTimes;
    
     }
	
    public RecommendLvAdp(Context context)
    {this.context=context;   
     inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
	
	@Override
	public int getCount() {
		return 10;
//		return MainActivity.recommend_arrayList.size();
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
		if(convertView==null)
		{   itemBox=new ItemBox();
			convertView=(View)inflater.inflate(R.layout.recommend_lv_item_2,null);
		    itemBox.posterAvatar=(ImageView)convertView.findViewById(R.id.rcmLvItem2_posterAvatar_iv);
		    itemBox.cmTimes=(TextView)convertView.findViewById(R.id.rcmLvItem2_cmTimes_tv);
		    itemBox.coverPic=(ImageView)convertView.findViewById(R.id.rcmLvItem2_coverPic_iv);
		    itemBox.discription=(TextView)convertView.findViewById(R.id.rcmLvItem2_discription_tv);
		    itemBox.likeTimes=(TextView)convertView.findViewById(R.id.rcmLvItem2_likeTimes_tv);
		    itemBox.moreButton=(ImageButton)convertView.findViewById(R.id.rcmLvItem2_moreButton_ib);
		    itemBox.triangleShapePic=(ImageView)convertView.findViewById(R.id.rcmLvItem2_triangleShape_iv);
		    
		     convertView.setTag(itemBox);  
		}else{itemBox=(ItemBox)convertView.getTag();}
	     
		  itemBox.triangleShapePic.getBackground().setAlpha(70);
		  itemBox.triangleShapePic.setOnClickListener(new OnClickListener()
		  {	@Override
			public void onClick(View arg0)
		    {Intent intent=new Intent(context,VedioDetailsAct.class);
		     context.startActivity(intent);
			
			}
			  }
			 );
		  itemBox.posterAvatar.setOnClickListener(new OnClickListener()
		  {@Override
			  public void onClick(View v)
		   	  {Intent gotoUserDetails=new Intent(context,UserDetailsAct.class);
			    context.startActivity(gotoUserDetails);
		   	  }
		  });
		  
		return convertView;
	}
	
public class convertViewOnClick
    {
	}
	
}
