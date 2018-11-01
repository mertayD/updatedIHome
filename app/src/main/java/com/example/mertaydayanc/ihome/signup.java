package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    public static User[] users = new User[10];
    public static int sizeArr = 0;
    Button next;
    EditText userEmail;
    EditText password;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        next = (Button) findViewById(R.id.b_next);
        userEmail = (EditText) findViewById(R.id.eT_userEmail);
        password = (EditText) findViewById(R.id.eT_password1);

        userEmail.setText("");
        password.setText("");

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = userEmail.getText().toString();
                String passwordStr = password.getText().toString();

                if(!email.equals( "") && !passwordStr.equals("")) {
                    users[sizeArr] = new User(email, passwordStr);
                    Context context = signup.this;
                    Class destinationActivity = Configurations.class;
                    Intent configurations = new Intent(context, destinationActivity);
                    configurations.putExtra("User", sizeArr );
                    sizeArr++;
                    startActivity(configurations);
                }

                else
                {
                    String message = "Something is Wrong with your INPUT!";
                    toast.makeText(signup.this,message,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
