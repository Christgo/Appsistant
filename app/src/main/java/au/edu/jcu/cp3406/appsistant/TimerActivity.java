package au.edu.jcu.cp3406.appsistant;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    private int seconds = 0;

    private boolean isRunning;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    public void onStartButtonClicked(View view) {
        isRunning = true;
    }

    public void onStopButtonClicked(View view) {
        isRunning = false;
    }

    public void onResetButtonClicked() {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView stopwatch = (TextView)findViewById(R.id.stopwatch);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d : %02d : %02d", hours, minutes, secs);

                stopwatch.setText(time);

                if (isRunning) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}
