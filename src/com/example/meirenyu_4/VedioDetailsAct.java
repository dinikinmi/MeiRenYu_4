package com.example.meirenyu_4;

import java.util.ArrayList;

import DataContainer.Commence;
import DataContainer.PrivateMessage;
import LittleTool.t;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class VedioDetailsAct extends Activity
{  public ViewPager vdDetailsPager;
   public ViewPager hrRcmListVp;
   public ArrayList<View> vdViewList;
   public ArrayList<View> rcmVdViewList;
   public View vdDetailsView;
   public ImageView trianglePic;
   public ListView cmListView;
   public ArrayList<Commence> commenceList;
   public ArrayList<PrivateMessage> messageList;
   public CmListViewAdp cmListViewAdp;

   
   
   
  
   
	@Override
	public void onCreate(Bundle b)
	{setContentView(R.layout.vediodetails_out);
	 super.onCreate(b);
	 findViewById();
	 initvdViewPager();
	 initRcmVdVp();
	 initCmListView();
	 setOnClick();
	}
	
	   public void findViewById()
     {vdDetailsPager=(ViewPager)findViewById(R.id.vdo_meatVp_vp);
      vdDetailsView=(View)((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.vediodetails_in,null);
      hrRcmListVp=(ViewPager)vdDetailsView.findViewById(R.id.vdi_recommendVp_vp);
	  cmListView=(ListView)vdDetailsView.findViewById(R.id.vdi_commenceLv_lv);
      
     }
   
   @SuppressWarnings("deprecation")
public void initvdViewPager()
     { 
       trianglePic=(ImageView)vdDetailsView.findViewById(R.id.vdi_trianglePic_iv);
 	   trianglePic.setAlpha(30);
       vdViewList=new ArrayList<View>();
  	   vdViewList.add(vdDetailsView);
  	   VdViewPagerAdp vdViewPagerAdp=new VdViewPagerAdp();
  	   vdDetailsPager.setAdapter(vdViewPagerAdp);
  	   vdViewPagerAdp.notifyDataSetChanged();
	   }
   
   
  
   public void initCmListView()
   {cmListViewAdp=new CmListViewAdp();
	 cmListView.setAdapter(cmListViewAdp);
	 cmListViewAdp.notifyDataSetChanged();
     setListViewHeightBasedOnChildren(cmListView,11);
   }
   
   public void initRcmVdVp()
   {rcmVdViewList=new ArrayList<View>();
   HrRcmVdListAdp hrRcmVdListAdp=new HrRcmVdListAdp();
   	for(int i=0;i<10;i++)
	 {View rcmVdViewListItem=(View)((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.recommend_horizontallist_item,null);		
	  rcmVdViewList.add(rcmVdViewListItem);
	 }
	 hrRcmListVp.setPageMargin(10);
   	 hrRcmListVp.setAdapter(hrRcmVdListAdp);
	 hrRcmVdListAdp.notifyDataSetChanged();
	 final LinearLayout rcmVdVpLayout=(LinearLayout)vdDetailsView.findViewById(R.id.vdi_recommendVdVpContainer_ll);
//	 rcmVdVpLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,120));
	 hrRcmListVp.setOffscreenPageLimit(3);
	 rcmVdVpLayout.setOnTouchListener(new View.OnTouchListener()
	 {  @Override
		public boolean onTouch(View v, MotionEvent event)
	    {return hrRcmListVp.dispatchTouchEvent(event);
		}  
		}
	 );    
   
     hrRcmListVp.setOnPageChangeListener(new OnPageChangeListener()
     {	@Override
		public void onPageScrollStateChanged(int arg0) 
       {}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) 
		{if(rcmVdVpLayout!=null)
		 {rcmVdVpLayout.invalidate();
			}
		}

		@Override
		public void onPageSelected(int arg0)
		{}
    	
     }
     );
   
   }
      
   public class VdViewPagerAdp extends PagerAdapter
	{  	@Override
		public int getCount() {
		  int count= vdViewList.size();
			return count;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) 
		{ return view==obj;}
	
		
		@Override
		public Object instantiateItem(ViewGroup vg,int position)
		{ vg.addView(vdViewList.get(position));
			return vdViewList.get(position);
		}
		
		
	}
      
   public class HrRcmVdListAdp extends PagerAdapter
   {
   	@Override
   	public int getCount() {
   		int count=rcmVdViewList.size();
   		return count;
   	}

   	@Override
   	public boolean isViewFromObject(View view, Object obj) 
   	{  return view==obj;
   	}
   	
   	@Override
   	public Object instantiateItem(ViewGroup vg,int position)
   	{   vg.addView(rcmVdViewList.get(position));
   		return rcmVdViewList.get(position);
   	}
   	@Override
   	public void destroyItem(ViewGroup container, int position, Object object)
   	{  container.removeView((View)object);
   	} 
   	}	
   
   public class CmListViewAdp extends BaseAdapter
   {   public ItemBox cmItemBox;
	  
       public class ItemBox
	   {public ImageButton cmAvatar;
	    public TextView cmPosterName;
	    public TextView cmPostTime;
	    public TextView cmContent;
		 }

	@Override
	public int getCount() {
//		int count=commenceList.size();
		return 10;//just for test
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
	{   cmItemBox=new ItemBox();
		if(convertView==null)
		{convertView=(View)(((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.vd_details_cmlv_item,null));
		 cmItemBox.cmAvatar=(ImageButton)convertView.findViewById(R.id.cmlvItem_avatar_ib);
		 cmItemBox.cmContent=(TextView)convertView.findViewById(R.id.cmlvItem_cmContent_tv);
		 cmItemBox.cmPosterName=(TextView)convertView.findViewById(R.id.cmlvItem_posterName_tv);
		 cmItemBox.cmPostTime=(TextView)convertView.findViewById(R.id.cmlvItem_time_tv);
	     convertView.setTag(cmItemBox);
	    }else
	    {cmItemBox=(ItemBox)convertView.getTag();}
		 return convertView;
	}
	   
   }
   
   public void setOnClick()
   {trianglePic.setOnClickListener(new OnClickListener()
      {	@Override
		public void onClick(View arg0)
        {t.say("jump to vedio play web view");
    	 Intent intent=new Intent(VedioDetailsAct.this,PlayVedioAct.class);
         startActivity(intent);
			
		}
	   
	   
      }
		   );
	   
	   
   }
   
   public static void setListViewHeightBasedOnChildren(ListView listView, int attHeight) {  
    
	   ListAdapter listAdapter = listView.getAdapter();   
       
       if (listAdapter == null) {  
           // pre-condition  
           return;  
       }  
       int totalHeight = 0;  
         int count=listAdapter.getCount();
         t.say(""+count);
        for (int i = 0; i < listAdapter.getCount(); i++) 
        {  View listItem = listAdapter.getView(i, null, listView);  
            listItem.measure(0,0);
           totalHeight += listItem.getMeasuredHeight();  
       }  
 
       ViewGroup.LayoutParams params = listView.getLayoutParams();  
       params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + attHeight;  
       listView.setLayoutParams(params);  
   }  
   
   
   
}
   
   
   
   

	

  


		
		
	   
	   
   
	






	
