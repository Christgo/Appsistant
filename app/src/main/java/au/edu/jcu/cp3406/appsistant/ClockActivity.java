package au.edu.jcu.cp3406.appsistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_main);
    }

    public void onTimerButtonClicked(View view) {
        Intent timerIntent = new Intent(this, TimerActivity.class);
        startActivity(timerIntent);
    }

}
