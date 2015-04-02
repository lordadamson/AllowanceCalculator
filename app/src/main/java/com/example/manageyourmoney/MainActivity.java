package com.example.manageyourmoney;

import java.util.Calendar;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Calendar Date;
	int year,month,month1,day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText editTotalMoney = (EditText)findViewById(R.id.editText1);
		final EditText StartDate = (EditText)findViewById(R.id.editText2);
		final ImageButton im1=(ImageButton) findViewById(R.id.imageButton1);
		final EditText EndDate = (EditText)findViewById(R.id.editText3);
		final ImageButton im2=(ImageButton) findViewById(R.id.ImageButton01);
		final Button Save = (Button) findViewById(R.id.button1);

		
		
		im1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {

				Date=Calendar.getInstance();
				day = Date.get(Calendar.DAY_OF_MONTH);
				year = Date.get(Calendar.YEAR);
				month = Date.get(Calendar.MONTH);
				
				DatePickerDialog datepicker = new DatePickerDialog(MainActivity.this, new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {

						StartDate.setText(dayOfMonth+"/"+ (monthOfYear+1) +"/"+ year);


						
						
					}
				}, year, month, day);

				datepicker.show();

				
			}
		});
		im2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Date=Calendar.getInstance();
				day = Date.get(Calendar.DAY_OF_MONTH);
				year = Date.get(Calendar.YEAR);
				month1 = Date.get(Calendar.MONTH);

				DatePickerDialog datepicker = new DatePickerDialog(MainActivity.this, new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						EndDate.setText(dayOfMonth+"/"+ (monthOfYear+1) +"/"+ year);
						
					}
				}, year, month1, day);
				datepicker.show();
			}
		});
		 
		
		Save.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				//code database here
				String TotalMoney = editTotalMoney.getText().toString();
				
				String Startdate = StartDate.getText().toString();
				String[] Ssplited = Startdate.split("/");
				String Enddate = EndDate.getText().toString();
				String[] Esplited = Enddate.split("/");
				
				int days = Integer.valueOf(Esplited[0])-Integer.valueOf(Ssplited[0]) ;
				int Month =Integer.valueOf(Esplited[1])-Integer.valueOf(Ssplited[1]) ;
				int Years =Integer.valueOf(Esplited[2])-Integer.valueOf(Ssplited[2]) ;
				String NumberOfDays =String.valueOf( days + 30*Month+ (Years *365));
				
				//Toast.makeText(getApplicationContext(), NumberOfDays +"", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(getApplicationContext(),ManageMyMoney.class);
				intent.putExtra("TotalMoney",TotalMoney);
				intent.putExtra("N",NumberOfDays).toString();
				//intent.putExtra("NumberOfDays", value)
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
