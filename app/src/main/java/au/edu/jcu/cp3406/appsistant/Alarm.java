package au.edu.jcu.cp3406.appsistant;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Alarm extends AppCompatActivity implements View.OnClickListener {
    Button addAlarmButton;
    Button cancelButton;
    ListView alarmList;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmclocklayout);

//        alarmList = (ListView)findViewById(R.id.alarmList);
        bindViews();

    }

    public void bindViews(){
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        addAlarmButton = (Button)findViewById(R.id.addAlarmButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);

        Intent intent = new Intent(Alarm.this, AlarmPage.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        pendingIntent = PendingIntent.getActivity(Alarm.this,0,intent, 0);

        addAlarmButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.addAlarmButton:
                Calendar currenTime = Calendar.getInstance();
                new TimePickerDialog(Alarm.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    //setting a time for alarm
                        Calendar currenTime = Calendar.getInstance();
                        currenTime.setTimeInMillis(System.currentTimeMillis());
                     //setting Calendar object
                        currenTime.set(Calendar.HOUR,hourOfDay);
                        currenTime.set(Calendar.MINUTE,minute);
                        //start Activity
                        alarmManager.set(AlarmManager.RTC_WAKEUP,currenTime.getTimeInMillis(),pendingIntent);
                        Log.e("Here", currenTime.getTimeInMillis()+"");
                        //prompt users alarm setting complete
                        Toast.makeText(Alarm.this,"The Alarm is Set!" + currenTime.getTimeInMillis(),
                                Toast.LENGTH_SHORT).show();
                    }
                },currenTime.get(Calendar.HOUR_OF_DAY),currenTime.get(Calendar.MINUTE),false).show();
                cancelButton.setVisibility(View.VISIBLE);
                break;
            case R.id.cancelButton:
                alarmManager.cancel(pendingIntent);
                cancelButton.setVisibility(View.GONE);
                Toast.makeText(Alarm.this, "Alarm has been canceled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
