package com.example.manageyourmoney;




import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Splash extends Activity {

	private Runnable runnable;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		
		 runnable=new Runnable() {  
             
	            @Override  
	            public void run() 
	            {  
	                try  
	                {  
	                	Thread.sleep(2000);
	                    Intent _intent=new Intent(Splash.this,First.class);    
	                    startActivity(_intent);    
	                }  
	                catch(Exception e)  
	                {  
	                    e.printStackTrace();  
	                }  
	            } 
	        };  
	        try  
	        {  
	            Thread t=new Thread(null,runnable);  
	            t.start(); 

	        }  
	        catch(Exception e)  
	        {  
	        	e.printStackTrace(); 
	        }  
	         
	    }  
}
