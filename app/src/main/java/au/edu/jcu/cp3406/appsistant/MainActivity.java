package au.edu.jcu.cp3406.appsistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMain(View view) {
        Intent intent;
        switch (view.getId()) { //Cases will be filled as activities are created
            case R.id.calendar_button:
                break;
            case R.id.camera_button:
                break;
            case R.id.clock_button:
                intent = new Intent(this, ClockActivity.class);
                startActivity(intent);
                break;
            case R.id.contacts_button:
                intent = new Intent(this, ViewContacts.class);
                startActivity(intent);
                break;
            case R.id.email_button:
                break;
            case R.id.gallery_button:
                break;
            case R.id.messages_button:
                break;
        }
    }
}