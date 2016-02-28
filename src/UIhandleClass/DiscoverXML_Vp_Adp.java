package UIhandleClass;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.meirenyu_4.DarkCircleVedioFrame;
import com.example.meirenyu_4.MainActivity;
import com.example.meirenyu_4.R;
import com.example.meirenyu_4.SkinCareVedioFrame;
import com.example.meirenyu_4.TurtorialVedioFrame;



public class DiscoverXML_Vp_Adp extends PagerAdapter 
{	
	ImageButton rightArrow_1;
	ImageButton rightArrow_2;
	ImageButton rightArrow_3;
	
	View convertView;
	@Override
	public int getCount()
	{ 
 	return MainActivity.discoverVp_list.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) 
	{ 
		return view==obj;
	}
	
	
	@Override
    public Object instantiateItem(View view, int position)                                //ÊµÀý»¯Item
    {     convertView=MainActivity.discoverVp_list.get(position);
          rightArrow_1=(ImageButton)convertView.findViewById(R.id.disc_in_rightArrow_ib);
          rightArrow_2=(ImageButton)convertView.findViewById(R.id.disc_in_rightArrow2_ib);
          rightArrow_3=(ImageButton)convertView.findViewById(R.id.disc_in_rightArrow3_ib);
          
          rightArrow_3.setOnClickListener(new OnClickListener()
          { @Override
			public void onClick(View arg0)
			{  Intent intent=new Intent(MainActivity.generalContext,DarkCircleVedioFrame.class);
			   MainActivity.generalContext.startActivity(intent);
			}
          });
          
          rightArrow_2.setOnClickListener(new OnClickListener()
          { @Override
			public void onClick(View arg0)
			{  Intent intent=new Intent(MainActivity.generalContext,SkinCareVedioFrame.class);
			   MainActivity.generalContext.startActivity(intent);
			}
          });
          
          
          rightArrow_1.setOnClickListener(new OnClickListener()
		{
		@Override
		  public void onClick(View v)
		  {Intent intent=new Intent(MainActivity.generalContext,TurtorialVedioFrame.class);
		   MainActivity.generalContext.startActivity(intent);
		  }
		}); 
          
          
        
		( (ViewPager)view).addView(convertView);
          return convertView;
    }
     

@SuppressWarnings("deprecation")
@Override
public void destroyItem(View container, int position, Object object) 
{
	( (ViewPager)container).removeView((View)object);
}
}
