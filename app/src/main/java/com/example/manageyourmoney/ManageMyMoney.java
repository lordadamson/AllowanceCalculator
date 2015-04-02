package com.example.manageyourmoney;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ManageMyMoney extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_my_money);
		TextView TYourMoney = (TextView) findViewById(R.id.textView2);
		TextView TLeftDays =(TextView) findViewById(R.id.textView4); 
		Bundle b = getIntent().getExtras();
		String MyMoney= b.getString("TotalMoney");
		String DayLeft =b.getString("N");
		
		TYourMoney.setText(MyMoney);
		TLeftDays.setText(DayLeft);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_my_money, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
