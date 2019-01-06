package com.vinvin.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DrunkTesting extends AppCompatActivity {
    Button but;
    TextView txt;
    String drunkTest = "Are you drunk";
    int count;
    int chance = 3-count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drunk_testing);
        but = (Button) findViewById(R.id.button1);
        but.setOnClickListener(new OnClickListener() {

                                   @Override
                                   public void onClick(View arg0) {
                                       // TODO Auto-generated method stub

                                       AlertDialog.Builder ab = new AlertDialog.Builder(DrunkTesting.this);
                                       ab.setTitle("Enter the sentence " + "'"+drunkTest+"'");

                                       final EditText et = new EditText(DrunkTesting.this);

                                       ab.setView(et);

                                       ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                           @Override
                                           public void onClick(DialogInterface arg0, int arg1) {
                                               // TODO Auto-generated method stub
                                               String check = et.getText().toString();

                                               if (check.contentEquals(drunkTest) && (count < 3 || count >= 0)) {
                                                   Toast.makeText(DrunkTesting.this, "good Job", Toast.LENGTH_SHORT).show();
                                                   Intent proceed = new Intent(DrunkTesting.this, SetTimer.class);
                                                   startActivity(proceed);
                                               }
                                           }
                                       });

                                       ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                                           @Override
                                           public void onClick(DialogInterface arg0, int arg1) {
                                               // TODO Auto-generated method stub
                                               Toast.makeText(DrunkTesting.this,"Please follow instruction",Toast.LENGTH_SHORT).show();
                                           }
                                       });
                                       AlertDialog a = ab.create();
                                       a.show();
                                   }

                               }
        );
    }
}