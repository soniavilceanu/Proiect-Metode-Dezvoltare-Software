package com.example.albunsifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class BugReportingActivity extends AppCompatActivity {

    private RadioButton RadioAutentificare;
    private RadioButton RadioBaza;
    private RadioButton RadioHarta;
    private EditText TextIntrebareRadio;
    private Button Trimite;
    private Button Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_reporting);
        setTitle("Bug Reporting");

        RadioAutentificare=findViewById(R.id.RadioAutentificare);
        RadioBaza=findViewById(R.id.RadiotBaza);
        RadioHarta=findViewById(R.id.RadioHarta);
        Trimite=findViewById(R.id.Trimite);
        Back=findViewById(R.id.Back);
        TextIntrebareRadio=findViewById(R.id.Problema);


        Trimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text_raport = TextIntrebareRadio.getText().toString();

                HashMap<String, Object> map = new HashMap<>();

                String Harta="Harta";
                String Autentificare="Autentificare";
                String Baza="Baza";

                if (RadioAutentificare.isChecked()){

                    map.put(Autentificare,text_raport);

                    FirebaseDatabase.getInstance().getReference().child("Buguri").push().updateChildren(map);

                    Toast.makeText(BugReportingActivity.this,"Multumim pentru feedback!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BugReportingActivity.this,MainActivity.class));
                }

                if (RadioBaza.isChecked()){

                    map.put(Baza,text_raport);

                    FirebaseDatabase.getInstance().getReference().child("Buguri").push().updateChildren(map);

                    Toast.makeText(BugReportingActivity.this,"Multumim pentru feedback!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BugReportingActivity.this,MainActivity.class));

                }

                if (RadioHarta.isChecked()){

                    map.put(Harta,text_raport);

                    FirebaseDatabase.getInstance().getReference().child("Buguri").push().updateChildren(map);

                    Toast.makeText(BugReportingActivity.this,"Multumim pentru feedback!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BugReportingActivity.this,MainActivity.class));

                }

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BugReportingActivity.this,MainActivity.class));
                finish();
            }
        });

    }

}
