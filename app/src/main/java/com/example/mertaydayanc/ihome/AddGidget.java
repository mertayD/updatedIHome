package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AddGidget extends AppCompatActivity implements homeAdapter.ListItemClickListener  {

    private homeAdapter lrAdapter, brAdapter;
    private RecyclerView lr_recycler, br_recyler;
    LinearLayoutManager layoutManager;
    Button b_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gidget);

        Intent here = getIntent();

        //THESE WILL BE OBTAINED FROM SERVER
        int bedroomCount = 0;
        int livingRoomCount = 0;
        b_done = (Button) findViewById(R.id.b_done);

        if(here.hasExtra("bedroom"))
            bedroomCount = here.getIntExtra("bedroom", 1);
        if(here.hasExtra("livingroom"))
            livingRoomCount = here.getIntExtra("livingroom",1);

        lr_recycler = (RecyclerView) findViewById(R.id.lr_recycler_view);
        br_recyler = (RecyclerView) findViewById(R.id.br_recycler_view);

        layoutManager = new LinearLayoutManager(this);

        lr_recycler.setLayoutManager(layoutManager);
        lr_recycler.setHasFixedSize(true);
        lrAdapter = new homeAdapter(livingRoomCount, this);
        lrAdapter.setRoomType("LivingRoom");
        lr_recycler.setAdapter(lrAdapter);

        layoutManager = new LinearLayoutManager(this);
        br_recyler.setLayoutManager(layoutManager);
        br_recyler.setHasFixedSize(true);
        brAdapter = new homeAdapter(bedroomCount,this);
        brAdapter.setRoomType("BedRoom");
        br_recyler.setAdapter(brAdapter);

        lr_recycler.setNestedScrollingEnabled(false);
        br_recyler.setNestedScrollingEnabled(false);

        b_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = AddGidget.this;
                Class destinationActivity = RoomsMainDisplay.class;
                Intent roomsDisplay = new Intent(context, destinationActivity);
                startActivity(roomsDisplay);
            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex, boolean roomType) {

        Context context = AddGidget.this;
        Class destinationActivity = addGidgetToRoom.class;
        Intent addGdgtRoom = new Intent(context, destinationActivity);
        addGdgtRoom.putExtra("roomType",roomType);
        addGdgtRoom.putExtra("RoomNumber", clickedItemIndex);
        startActivity(addGdgtRoom);
    }

}