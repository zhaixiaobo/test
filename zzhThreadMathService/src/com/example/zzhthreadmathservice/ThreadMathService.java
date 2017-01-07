package com.example.zzhthreadmathservice;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class ThreadMathService extends Service{
	
private static final double ThreadMathService = 0;
	//	private final IBinder mBinder = new LocalBinder();
	private Thread workThread;
//
//	public class LocalBinder extends Binder{
//		ThreadMathService getService() {
//			return ThreadMathService.this;
//	    }
//	}
	
	@Override
	public IBinder onBind(Intent intent) {
		 Toast.makeText(this, "±¾µØ°ó¶¨£ºMathService", 
	     		  Toast.LENGTH_SHORT).show();
		workThread=new Thread(null,mConnection,"WorkThread");
		return null;
	}
	
	public void onCreat(){
		
	}	

	public void onSrart(Intent intent,int startId){
		super.onStart(intent,startId);
		Toast.makeText(this,"(2)onStart()",Toast.LENGTH_SHORT).show();
		long a=Math.round(Math.random()*100);
		long b=Math.round(Math.random()*100);
		
	}
	

	public static long Add(long a, long b){
		return a+b;
	}
	
	
//  private ServiceConnection mConnection = new ServiceConnection() {
//	
//	@Override
//	public void onServiceConnected(ComponentName name, IBinder service) {
//		mathService = ((ThreadMathService.LocalBinder)service).getService();
//	}
//	
//	@Override
//	public void onServiceDisconnected(ComponentName name) {
//		mathService = null;	
//	}
//};

	
  private Runnable mConnection=new Runnable() {
	
	@Override
	public void run() {
		
	}

	
  };
	
	
}
