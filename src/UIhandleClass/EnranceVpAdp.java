package UIhandleClass;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.meirenyu_4.MainActivity;

public class EnranceVpAdp extends PagerAdapter{

	@Override
	public int getCount() {
	 return MainActivity.entranceViewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return false;
	}

	@Override
    public Object instantiateItem(View view, int position)                                //ÊµÀý»¯Item
    {  ((ViewPager) view).addView(MainActivity.entranceViewList.get(position), 0);
        return MainActivity.entranceViewList.get(position);
    }
    
	
}
