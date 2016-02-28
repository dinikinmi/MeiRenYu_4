package UIhandleClass;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.meirenyu_4.MainActivity;



public class MessageXML_Vp_Adp extends PagerAdapter 
{	
	@Override
	public int getCount()
	{   
		return MainActivity.messageVp_List.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) 
	{ 
		return view==obj;
	}
	
	
	@Override
    public Object instantiateItem(View view, int position)                                //ÊµÀý»¯Item
    {  ( (ViewPager)view).addView(MainActivity.messageVp_List.get(position));
         return MainActivity.messageVp_List.get(position);
    }
     

@SuppressWarnings("deprecation")
@Override
public void destroyItem(View container, int position, Object object) {
	
	( (ViewPager)container).removeView((View)object);
	 

}
	

}
