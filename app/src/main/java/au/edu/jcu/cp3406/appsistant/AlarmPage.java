package au.edu.jcu.cp3406.appsistant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmPage extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mediaPlayer = mediaPlayer.create(this,R.raw.ringtone);
        mediaPlayer.start();

        new AlertDialog.Builder(AlarmPage.this).setTitle("Alarm Clock").setMessage("Wake up").setPositiveButton("Close the alarm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mediaPlayer.stop();
                AlarmPage.this.finish();
            }
        }).show();
    }
}
