package com.example.healthapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SetMedicineTimingsActivity extends AppCompatActivity {

    TimePicker timePicker1, timePicker2;
    Button buttonSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_medicine_timings);

        timePicker1 = findViewById(R.id.timePicker1);
        timePicker2 = findViewById(R.id.timePicker2);
        buttonSet = findViewById(R.id.buttonSet);

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMedicineTimings(timePicker1.getCurrentHour(), timePicker1.getCurrentMinute(), "Morning");
                setMedicineTimings(timePicker2.getCurrentHour(), timePicker2.getCurrentMinute(), "Night");

                Toast.makeText(SetMedicineTimingsActivity.this, "Medicine timings set!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setMedicineTimings(int hour, int minute, String label) {
        // Create a PendingIntent for the AlarmManager
        Intent intent = new Intent(this, alaramserviece.class);
        intent.putExtra("label", label);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Set the alarm to trigger at the specified time
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // Schedule the alarm with the AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }}


