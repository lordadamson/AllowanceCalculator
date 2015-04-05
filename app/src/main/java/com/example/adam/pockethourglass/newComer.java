package com.example.adam.pockethourglass;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class newComer extends ActionBarActivity {

    Calendar Date;
    int year, month, month1, day;
    String numberOfDays, totalMoney, endDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comer);
        final EditText editTotalMoney = (EditText) findViewById(R.id.editText1);
        final TextView EndDate = (TextView) findViewById(R.id.numberOfDaysView);
        final Button im2 = (Button) findViewById(R.id.toDateButton);
        final Button Save = (Button) findViewById(R.id.button1);

        totalMoney = editTotalMoney.getText().toString();

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Date = Calendar.getInstance();
                day = Date.get(Calendar.DAY_OF_MONTH);
                year = Date.get(Calendar.YEAR);
                month = Date.get(Calendar.MONTH);

                //TODO: disable selection of days before today.
                DatePickerDialog datepicker = new DatePickerDialog(newComer.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        endDateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        numberOfDays = numberOfDays(endDateString);
                        if (Integer.parseInt(numberOfDays) == 1)
                            EndDate.setText("يوم واحد");
                        else if (Integer.parseInt(numberOfDays) == 2)
                            EndDate.setText("يومين");
                        else if (Integer.parseInt(numberOfDays) >= 3 && Integer.parseInt(numberOfDays) <= 10)
                            EndDate.setText(numberOfDays + " أيام");
                        else if (Integer.parseInt(numberOfDays) >= 10)
                            EndDate.setText(numberOfDays + " يوم");
                    }
                }, year, month, day);
                datepicker.show();
            }
        });


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code database here

                //Toast.makeText(getApplicationContext(), NumberOfDays +"", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("TotalMoney", totalMoney);
                intent.putExtra("N", numberOfDays).toString();
                //intent.putExtra("NumberOfDays", value)
                startActivity(intent);

            }
        });
    }

    private String numberOfDays(String endDateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        String[] Ssplited = currentDateandTime.split("/");
        String[] Esplited = endDateString.split("/");

        int days = Integer.valueOf(Esplited[0]) - Integer.valueOf(Ssplited[0]);
        int Month = Integer.valueOf(Esplited[1]) - Integer.valueOf(Ssplited[1]);
        int Years = Integer.valueOf(Esplited[2]) - Integer.valueOf(Ssplited[2]);
        String numberOfDays = String.valueOf(days + 30 * Month + (Years * 365));
        return numberOfDays;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
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
