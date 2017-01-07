package com.example.zzhthreadmathservice;

import com.example.zzhthreadmathservice.ThreadMathService;
import com.example.zzhthreadmathservice.ThreadMathActivity;
import com.example.zzhthreadmathservice.R;
import com.example.zzhthreadmathservice.ThreadMathActivity;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ThreadMathActivity extends Activity {


	private static Handler handler=new Handler();
	private static final Runnable RefreshLable = null;
	private ThreadMathService mathService;
	TextView labelView;
	ServiceConnection mConnection;
	private static double mathDouble;
	
	
	protected static void UpdateGUI(double refreshDouble) {
		// TODO Auto-generated method stub
		
	    setMathDouble(refreshDouble);	  
		handler.post(RefreshLable);		
		
	}
	
	 
	  //onCreate()
    @Override     
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        labelView = (TextView)findViewById(R.id.label);
        Button bindButton = (Button)findViewById(R.id.bind);
        Button unbindButton = (Button)findViewById(R.id.unbind);
        Button computButton = (Button)findViewById(R.id.compute);
        final Intent serviceIntent=new Intent(this,ThreadMathService.class);
        
        bindButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				startService(serviceIntent);
				
			}
        });
        
        unbindButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				stopService(serviceIntent);
			}

        });
        
        computButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
					if (mathService == null){
						labelView.setText("Î´°ó¶¨·þÎñ");
						return;
					}
					long a = Math.round(Math.random()*100);
					long b = Math.round(Math.random()*100);
					long result =  mathService.Add(a, b);
					String msg = String.valueOf(a)+" + "+String.valueOf(b)+
									" = "+String.valueOf(result);
					labelView.setText(msg);
			} 	
        });
  
    }

	/**
	 * @return the mathDouble
	 */
	public static double getMathDouble() {
		return mathDouble;
	}

	/**
	 * @param mathDouble the mathDouble to set
	 */
	public static void setMathDouble(double mathDouble) {
		ThreadMathActivity.mathDouble = mathDouble;
	}


}
