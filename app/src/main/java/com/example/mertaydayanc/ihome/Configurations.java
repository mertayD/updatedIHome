package com.example.mertaydayanc.ihome;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mertaydayanc.ihome.signup.sizeArr;

public class Configurations extends AppCompatActivity {

    EditText name;
    Spinner s_livingRoom;
    Spinner s_bedRoom;
    User curUser;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        name = (EditText) findViewById(R.id.userNameConfig);
        s_livingRoom = (Spinner) findViewById(R.id.spinnerLR);
        s_bedRoom = (Spinner) findViewById(R.id.spinnerBR);
        curUser = signup.users[sizeArr];


        ArrayAdapter<CharSequence> adapterLR = ArrayAdapter.createFromResource(this,
                R.array.roomNumbers, android.R.layout.simple_spinner_item);
        adapterLR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_livingRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String message =  parent.getItemAtPosition(pos).toString();
                int room = Integer.parseInt(message);
                signup.users[signup.sizeArr - 1].setLivingRoom(room);
                toast.makeText(Configurations.this, "You have " + room + "Living Rooms",Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        ArrayAdapter<CharSequence> adapterBR = ArrayAdapter.createFromResource(this,
                R.array.roomNumbers, android.R.layout.simple_spinner_item);
        adapterBR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_bedRoom.setAdapter(adapterBR);

        s_bedRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String message =  parent.getItemAtPosition(pos).toString();
                int room = Integer.parseInt(message);

                signup.users[signup.sizeArr - 1].setBedRoom(room);
                toast.makeText(Configurations.this, "You have " + room + "Bed Rooms",Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        
    }
}
