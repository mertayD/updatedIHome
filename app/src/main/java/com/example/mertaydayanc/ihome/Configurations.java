package com.example.mertaydayanc.ihome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mertaydayanc.ihome.signup.sizeArr;

public class Configurations extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    Spinner s_livingRoom;
    Spinner s_bedRoom;
    Toast toast;
    Button next;
    User curUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        name = (EditText) findViewById(R.id.userNameConfig);
        s_livingRoom = (Spinner) findViewById(R.id.spinnerLR);
        s_bedRoom = (Spinner) findViewById(R.id.spinnerBR);
        next = (Button) findViewById(R.id.nextConfig);
        curUser = signup.users[signup.sizeArr - 1];
        name.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapterLR = ArrayAdapter.createFromResource(this,
                R.array.roomNumbersLR, android.R.layout.simple_spinner_item);
        adapterLR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_livingRoom.setAdapter(adapterLR);

        s_livingRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String message =  parent.getItemAtPosition(pos).toString();
                int room = Integer.parseInt(message);
                curUser.setLivingRoom(room);
                if(toast != null)
                {
                    toast.cancel();
                }
                toast.makeText(Configurations.this, "You have " + curUser.getLivingRoom() + "Living Rooms",Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        ArrayAdapter<CharSequence> adapterBR = ArrayAdapter.createFromResource(this,
                R.array.roomNumbersBR, android.R.layout.simple_spinner_item);
        adapterBR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_bedRoom.setAdapter(adapterBR);

        s_bedRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String message =  parent.getItemAtPosition(pos).toString();
                int room = Integer.parseInt(message);
                curUser.setBedRoom(room);
                if(toast != null)
                {
                    toast.cancel();
                }
                toast.makeText(Configurations.this, "You have " + curUser.getBedRoom() + "Bed Rooms",Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nameStr = name.getText().toString();

                if(!(nameStr.equals("") || nameStr.equals("UserName")))
                {
                    curUser.setName(nameStr);
                    Context context = Configurations.this;
                    Class destinationActivity = AddGidget.class;
                    Intent addGidget = new Intent(context, destinationActivity);
                    addGidget.putExtra("bedroom", curUser.getBedRoom());
                    addGidget.putExtra("livingroom", curUser.getLivingRoom());
                    startActivity(addGidget);
                }
                else
                {
                    if(toast != null)
                    {
                        toast.cancel();
                    }
                    String message = "Please Fill UserName";
                    toast.makeText(Configurations.this,message,Toast.LENGTH_LONG).show();
                }
            }
        });
        
    }
    public void onClick(View v) {
        String defaultStr = "UserName";
        if(defaultStr.equals(name.getText().toString()))
        {
            name.getText().clear();
        }
    }
}
