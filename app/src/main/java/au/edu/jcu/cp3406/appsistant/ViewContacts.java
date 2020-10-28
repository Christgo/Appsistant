package au.edu.jcu.cp3406.appsistant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewContacts extends AppCompatActivity {
    Button contact1;
    Button contact2;
    Button contact3;
    Button contact4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontacts);

        contact1 = (Button)findViewById(R.id.contact1);
        contact2 = (Button)findViewById(R.id.contact2);
        contact3 = (Button)findViewById(R.id.contact3);
        contact4 = (Button)findViewById(R.id.contact4);
        }

        public void showContactsDetail(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Bob");
            builder.setMessage("Contact number: 04 123456");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        public void showContactsDetail1(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Brandom");
            builder.setMessage("Contact number: 04 159753");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        public void showContactsDetail2(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ellison");
            builder.setMessage("Contact number: 04 147896");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        public void showContactsDetail3(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("James");
            builder.setMessage("Contact number: 04 256349");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
}
