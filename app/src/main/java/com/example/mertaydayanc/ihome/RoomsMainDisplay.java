package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class RoomsMainDisplay extends AppCompatActivity implements RoomAdapter.ListItemClickListener {

    private RoomAdapter lrAdapter, brAdapter;
    private RecyclerView lr_recycler, br_recyler;
    LinearLayoutManager layoutManager;
    User curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_main_display);//THESE WILL BE OBTAINED FROM SERVER

        if(signup.sizeArr != 0)
            curUser = signup.users[signup.sizeArr -1];

        int bedroomCount = curUser.getBedRoom();
        int livingRoomCount = curUser.getLivingRoom();


        lr_recycler = (RecyclerView) findViewById(R.id.main_recycler_view_lr);
        br_recyler = (RecyclerView) findViewById(R.id.main_recycler_view_br);

        layoutManager = new LinearLayoutManager(this);

        lr_recycler.setLayoutManager(layoutManager);
        lr_recycler.setHasFixedSize(true);
        lrAdapter = new RoomAdapter(livingRoomCount, this);
        lrAdapter.setRoomType("LivingRoom");
        lr_recycler.setAdapter(lrAdapter);

        layoutManager = new LinearLayoutManager(this);
        br_recyler.setLayoutManager(layoutManager);
        br_recyler.setHasFixedSize(true);
        brAdapter = new RoomAdapter(bedroomCount,this);
        brAdapter.setRoomType("BedRoom");
        br_recyler.setAdapter(brAdapter);

        lr_recycler.setNestedScrollingEnabled(false);
        br_recyler.setNestedScrollingEnabled(false);


    }

    @Override
    public void onListItemClick(int clickedItemIndex, boolean roomType) {

        Context context = RoomsMainDisplay.this;
        Class destinationActivity = addGidgetToRoom.class;
        Intent addGdgtRoom = new Intent(context, destinationActivity);
        addGdgtRoom.putExtra("roomType",roomType);
        addGdgtRoom.putExtra("RoomNumber", clickedItemIndex);
        startActivity(addGdgtRoom);
    }
}
