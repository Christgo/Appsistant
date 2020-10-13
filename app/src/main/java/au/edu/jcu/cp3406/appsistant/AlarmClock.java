package au.edu.jcu.cp3406.appsistant;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmClock extends AppCompatActivity{
    Button timeSelectionButton;
    int hour;
    int minute;
    AlarmManager alarmManager;




    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        timeSelectionButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                //get current system time
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        //choose a time
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar1.set(Calendar.MINUTE,minute);

                        //perform the alarm clock
                        Intent intent = new Intent();
                        intent.setAction("com.example.g150825_android28.RING");
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmClock.this,0x101,intent,0);

                        //setting the alarm clock
                        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar1.getTimeInMillis(),pendingIntent);
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });




        //choose the previous time

    }
}
