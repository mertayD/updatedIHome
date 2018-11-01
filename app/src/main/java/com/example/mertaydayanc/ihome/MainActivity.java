package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button signUp;
    Button login;
    CheckBox rememberMe;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (Button) findViewById(R.id.b_signUp);
        login = (Button) findViewById(R.id.b_submit);
        rememberMe = (CheckBox) findViewById(R.id.cB_rememberMe);
        email = (EditText) findViewById(R.id.eT_email);
        password = (EditText) findViewById(R.id.eT_password);

        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class destinationActivity = signup.class;
                Intent startSelectChallengeActivity = new Intent(context, destinationActivity);
                startActivity(startSelectChallengeActivity);
            }
        });
    }
}
