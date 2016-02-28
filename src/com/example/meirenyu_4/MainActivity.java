package com.example.meirenyu_4;

import java.util.ArrayList;
import java.util.List;

import DataContainer.Commence;
import DataContainer.PrivateMessage;
import DataContainer.VedioDetails;
import UIhandleClass.DiscoverXML_Vp_Adp;
import UIhandleClass.FollowLvAdp;
import UIhandleClass.MessageXML_Vp_Adp;
import UIhandleClass.MsgXML_CmLvAdp;
import UIhandleClass.MsgXML_NoticeLvAdp;
import UIhandleClass.PrivateMsgLvAdp;
import UIhandleClass.RecommendLvAdp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//import UIhandleClass.MsgCMLvAdp;

public class MainActivity extends ActionBarActivity {
public ViewPager entranceViewPager;
public ViewPager messageXML_vp;
public ViewPager discoverXML_vp;
public RelativeLayout entranceMeatLayout;

public static List<View> entranceViewList=new ArrayList<View>();
public static List<View> messageVp_List=new ArrayList<View>();
public static List<View> discoverVp_list=new ArrayList<View>();
public static List<View> focusingButton=new ArrayList<View>(); 

public static ArrayList<PrivateMessage> privateMsgList=new ArrayList<PrivateMessage>();
public static ArrayList<Commence> msgXML_cm_list=new ArrayList<Commence>();


public View messageXML;
public View recommendXML;
public View followXML;
public View discoverXML;

public ImageButton index_bt;
public ImageButton message_bt;
public ImageButton discover_bt;
public ImageButton myDetails_bt;


public Button follow_bt;
public Button recommend_bt;


public TextView privateMsg_tv;
public TextView msgCommenceStr_tv;
public TextView notification_tv;


public TextView msgBar_1;
public TextView msgBar_2;
public TextView msgBar_3;

public ListView recommend_Lv;
public ListView follow_Lv;
public ListView privateMsg_Lv;
public ListView msgXML_cm_Lv;
public ListView msgXML_notice_lv;

public RecommendLvAdp recommendLvAdp;
public FollowLvAdp followLvAdp;
public PrivateMsgLvAdp privateMsg_Lv_Adp;
public MsgXML_NoticeLvAdp msgNoticeLv_adp;

public MessageXML_Vp_Adp messageXML_vp_Adp;
public DiscoverXML_Vp_Adp discoverXML_vp_adp;

public static Context generalContext;

public static ArrayList<VedioDetails> recommend_arrayList =new ArrayList<VedioDetails>();
public static ArrayList<VedioDetails> follow_arrayList=new ArrayList<VedioDetails>();
public static ArrayList<TextView> onShowMsgBarList=new ArrayList<TextView>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setOnClick();
		recommendXML.setVisibility(View.VISIBLE);
		createRecommendView();
				
		generalContext=this;
		messageXML_vp_Adp=new MessageXML_Vp_Adp();
		messageXML_vp.setAdapter(messageXML_vp_Adp);
	    }
	
	public void findView()
	{
	recommendXML=(View)findViewById(R.id.entr_recommend_incl);
	followXML=(View)findViewById(R.id.entr_follow_incl);
	messageXML=(View)findViewById(R.id.entr_msg_incl);
	discoverXML=(View)findViewById(R.id.entr_discover_incl);
	
	msgBar_1=(TextView)messageXML.findViewById(R.id.msg_left_line_tv);
	msgBar_2=(TextView)messageXML.findViewById(R.id.msg_middle_line_tv);
	msgBar_3=(TextView)messageXML.findViewById(R.id.msg_right_line_tv);
	
	messageXML_vp=(ViewPager)messageXML.findViewById(R.id.msg_meatVp_vp);
	discoverXML_vp=(ViewPager)discoverXML.findViewById(R.id.disc_out_meatVP_vp);
	
	privateMsg_Lv=(ListView)((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.private_msg,null);
    msgXML_cm_Lv=(ListView)((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.msg_cmlv,null);
    msgXML_notice_lv=(ListView)((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.msg_notification_lv,null);
    
    //privateMsg_Lv=(ListView)privateMsg.findViewById(R.id.prm_msgList_lv);
	privateMsg_tv=(TextView)findViewById(R.id.msg_priMsgStr_tv);
	msgCommenceStr_tv=(TextView)findViewById(R.id.msg_cmStr_tv);
	notification_tv=(TextView)findViewById(R.id.msg_noticeStr_tv);
	
	
	
	follow_bt=(Button)findViewById(R.id.rcm_follow_bt);
	recommend_bt=(Button)findViewById(R.id.follow_recommend_bt);
    message_bt=(ImageButton)findViewById(R.id.entr_msg_ib);
	index_bt=(ImageButton)findViewById(R.id.entr_index_ib);
	discover_bt=(ImageButton)findViewById(R.id.entr_discover_ib);
	myDetails_bt=(ImageButton)findViewById(R.id.entr_mineDetails_ib);
	}
	
	
	public void setOnClick()
	{
	recommend_bt.setOnClickListener(new recommendOnClick() );
	
     follow_bt.setOnClickListener(new followOnClick());
   
     message_bt.setOnClickListener(new messageOnClick());
	
     index_bt.setOnClickListener(new IndexBtOnClick());
	
     privateMsg_tv.setOnClickListener(new PrivateMsgTvOnClick());
      
     msgCommenceStr_tv.setOnClickListener(new msgCommenceStrOnClick());
	
	 notification_tv.setOnClickListener(new notificationStrOnClcik());
	
	 discover_bt.setOnClickListener(new DiscoverOnClick());
	
	 myDetails_bt.setOnClickListener(new OnClickListener()
	 {@Override
		 public void onClick(View v)
	     {Intent intent=new Intent(MainActivity.this,UserDetailsAct.class);
	      startActivity(intent);
		  }
		  
	 }
	  );
	}
	
	private class IndexBtOnClick implements OnClickListener
	{	@Override
		public void onClick(View index_bt) 
	    { setFocusingButton(index_bt);
		  Toast.makeText(MainActivity.this,"recommend Click",Toast.LENGTH_LONG).show();
		  dissmissView(recommendXML);
		  createRecommendView(); 
		}
		
	}
	
	private void createRecommendView()
	{VedioDetails vedioDetails=new VedioDetails();
	 setVedioDetails(vedioDetails);
	 recommend_arrayList.add(vedioDetails);
	 recommend_Lv=(ListView)recommendXML.findViewById(R.id.rcm_recommendLv_lv);
	 recommendLvAdp=new RecommendLvAdp(this);
	 recommend_Lv.setAdapter(recommendLvAdp);
	 recommendLvAdp.notifyDataSetChanged();
	}

	private void setVedioDetails(VedioDetails vedioDetails)
	{//this is test method ,will be deleted or modified in formal version
		vedioDetails.cmNumbers=123;
		vedioDetails.coverPicLocation="@drawable/test";
		vedioDetails.Discription="vedio desicription ";
		vedioDetails.likeTimes=123;
		vedioDetails.location="";
		vedioDetails.playLink="";
		vedioDetails.playTimes=456;
		vedioDetails.posterAvatarLocation="@drawable/ic_launcher";
		vedioDetails.posterId=12345L;
		vedioDetails.posterName="upLoader";
		vedioDetails.postTime="2015-09-25 11:11";
		vedioDetails.Title="vedio Title";
	    vedioDetails.vedioId=222L;
	}

	public class recommendOnClick implements OnClickListener
	{@Override
		public void onClick(View arg0) 
	   {Toast.makeText(MainActivity.this,"recommend Click",Toast.LENGTH_LONG).show();
	    dissmissView(recommendXML);
	    createRecommendView(); 
	   }
	}
	
	public class followOnClick implements OnClickListener
	{@Override
		public void onClick(View arg0)
	   {Toast.makeText(MainActivity.this,"follow Click",Toast.LENGTH_LONG).show();	
	    dissmissView(followXML);  
	    initFollowList();
	   }

	
		
	}
		
	private void initFollowList() 
	{VedioDetails vedioDetails=new VedioDetails();
	 setVedioDetails(vedioDetails);
	 follow_arrayList.add(vedioDetails);
	 follow_Lv=(ListView)followXML.findViewById(R.id.follow_listView_lv);
	 followLvAdp=new FollowLvAdp(this);
	 follow_Lv.setAdapter(recommendLvAdp);
	 followLvAdp.notifyDataSetChanged();	
	}
	
    public class messageOnClick implements OnClickListener
	{	@Override
		public void onClick(View v)
		{ setFocusingButton(v);
		  dissmissView(messageXML);
		}
	}
	
	private void setFocusingButton(View nowPressButton) 
	{
		ImageButton nowFocusing_bt=null;
		
	      if(focusingButton.size()>0)
		 {nowFocusing_bt=(ImageButton)focusingButton.get(0);
		  nowFocusing_bt.setFocusable(false);
	      focusingButton.clear();
	     }
		 //clear the focus from the now focusing button
	      nowPressButton.setFocusable(true);
		  nowPressButton.setFocusableInTouchMode(true);
		  nowPressButton.requestFocus();
		  nowPressButton.requestFocusFromTouch();
		   focusingButton.add(nowPressButton);
		  //make this button on focus and add into focusing button list
	}
	
	public class notificationStrOnClcik implements OnClickListener
	{  @Override
		public void onClick(View v)
	    {  setMsgBarVisible(msgBar_2);
	       loadNoticeXML();
		   initNoticeLv();
		  }

		private void initNoticeLv()
		{
		 msgNoticeLv_adp=new MsgXML_NoticeLvAdp(generalContext);
		 msgXML_notice_lv.setAdapter(msgNoticeLv_adp);
	 	 msgNoticeLv_adp.notifyDataSetChanged();
		 }

		private void loadNoticeXML() 
		{  
		 messageVp_List.clear();
		 messageVp_List.add(msgXML_notice_lv);
		 messageXML_vp_Adp=new MessageXML_Vp_Adp();
		 messageXML_vp.setAdapter(messageXML_vp_Adp);
		 messageXML_vp_Adp.notifyDataSetChanged();
		}
		
		
	}
	
    public class DiscoverOnClick implements OnClickListener
	{	@Override
		public void onClick(View v) 
	    {setFocusingButton(v);
		 dissmissView(discoverXML);
	     discoverXML_vp_adp=new DiscoverXML_Vp_Adp();
	     
		 View meatView=((LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.discover_in_recommend_vd, null);	
//		 View meatView=GenerateView.generateDiscoverRcmView(generalContext);
		 discoverVp_list.clear();
		 discoverVp_list.add(meatView);
		 discoverXML_vp.setAdapter(discoverXML_vp_adp);
		 discoverXML_vp_adp.notifyDataSetChanged();
	    }
	}
	
	public class msgCommenceStrOnClick implements OnClickListener
	{	@Override
		public void onClick(View v) 
	    {setMsgBarVisible(msgBar_1);
		 loadMsgCmLv();
	     initMsgXML_CmLv();
		}

	private void initMsgXML_CmLv()
	{MsgXML_CmLvAdp msgXML_CmLvAdp=new MsgXML_CmLvAdp(generalContext);
	 msgXML_cm_Lv.setAdapter(msgXML_CmLvAdp);
	 msgXML_CmLvAdp.notifyDataSetInvalidated();
	}

	private void loadMsgCmLv() 
	{messageVp_List.clear();
	 messageVp_List.add(msgXML_cm_Lv);
	 messageXML_vp_Adp=new MessageXML_Vp_Adp();
	 messageXML_vp.setAdapter(messageXML_vp_Adp);
	 messageXML_vp_Adp.notifyDataSetChanged();
	}
	}
		
	private class PrivateMsgTvOnClick implements OnClickListener
	{@Override
      public void onClick(View arg0)
	  {setMsgBarVisible(msgBar_3);
	   loadPrivateMessageXML();
	   initPriMsgLv();
	  }

	private void initPriMsgLv()
	{privateMsgList.clear();
	 for(int i=0;i<10;i++)
	 {PrivateMessage priMsg=new PrivateMessage();
      privateMsgList.add(priMsg);
	 }
	 privateMsg_Lv_Adp=new PrivateMsgLvAdp(generalContext);
	 privateMsg_Lv.setAdapter(privateMsg_Lv_Adp);
	 privateMsg_Lv_Adp.notifyDataSetChanged();
	 }

	private void loadPrivateMessageXML() 
	{  
	 messageVp_List.clear();
	 messageVp_List.add(privateMsg_Lv);
	 messageXML_vp_Adp=new MessageXML_Vp_Adp();
	 messageXML_vp.setAdapter(messageXML_vp_Adp);
	 messageXML_vp_Adp.notifyDataSetChanged();
	}
	
	}
	
	
   
	private void dissmissView(View keepXML)
	{if(recommendXML!=keepXML)
	  {recommendXML.setVisibility(View.GONE);
	  }
	 if(followXML!=keepXML)
	  {followXML.setVisibility(View.GONE);
	  }
	 if(messageXML!=keepXML)
	 {messageXML.setVisibility(View.GONE);}
	 keepXML.setVisibility(View.VISIBLE);
	 
	 if(discoverXML!=keepXML)
	 { discoverXML.setVisibility(View.GONE);
	   keepXML.setVisibility(View.VISIBLE); 
	 }
	 
	}
    
	private void setMsgBarVisible(TextView msgBarToShow)
	 {if(onShowMsgBarList.size()>0)
	    {TextView onShowNowTv=onShowMsgBarList.get(0);
	     onShowNowTv.setVisibility(View.INVISIBLE);
	     onShowMsgBarList.clear();
	    }
	 msgBarToShow.setVisibility(View.VISIBLE);
	 onShowMsgBarList.add(msgBarToShow);
		
	 }
	
}

