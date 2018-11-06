package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class addGidgetToRoom extends AppCompatActivity implements homeAdapter.ListItemClickListener {

    private homeAdapter g1Adapter, g2Adapter;
    private RecyclerView g1_recycler, g2_recycler;
    LinearLayoutManager layoutManager;
    int gidget1Count;
    int gidget2Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gidget_to_room);

        Intent here = getIntent();

        //This will be obtained from the room class member data
        gidget1Count = 0;
        gidget2Count = 0;
        boolean type;

        if (here.hasExtra("roomType")) {
            type = here.getBooleanExtra("roomType", false);
        }

        g1_recycler = (RecyclerView) findViewById(R.id.lr_recycler_view);
        g2_recycler = (RecyclerView) findViewById(R.id.br_recycler_view);

        layoutManager = new LinearLayoutManager(this);

        g1_recycler.setLayoutManager(layoutManager);
        g1_recycler.setHasFixedSize(true);
        g1Adapter = new homeAdapter(gidget1Count, this);
        g1Adapter.setRoomType("Gidget1");
        g1_recycler.setAdapter(g1Adapter);

        layoutManager = new LinearLayoutManager(this);
        g2_recycler.setLayoutManager(layoutManager);
        g2_recycler.setHasFixedSize(true);
        g2Adapter = new homeAdapter(gidget2Count, this);
        g2Adapter.setRoomType("Gidget2");
        g2_recycler.setAdapter(g2Adapter);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_gidget_to_room, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.add_gidget_1) {
            g1Adapter.incrementNumber();
        }

        else if(itemThatWasClickedId == R.id.add_gidget_2)
        {
            g2Adapter.incrementNumber();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex, boolean roomType) {


    }
}