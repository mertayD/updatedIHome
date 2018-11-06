package com.example.mertaydayanc.ihome;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private static final String TAG = homeAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;

    private static int roomCount;

    private int mNumberItems;

    private String roomType;

    boolean type;


    /**
     * The interface that receives onClick messages.
     * roomType False means LR
     * true means BR
     */
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex, boolean roomType);
    }

    public RoomAdapter(int numberOfItems, ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        roomCount = 0;
    }

    public void updateData(int numberOfItems)
    {
        mNumberItems = numberOfItems;
        notifyDataSetChanged();
    }

    public void incrementNumber()
    {
        int numb = mNumberItems + 1;
        updateData(numb);
    }

    public void clreaCount()
    {
        roomCount = 0;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;

        if(roomType.equals("BedRoom"))
            type = true;
        else
        {
            type = false;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.my_recycler_tv;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        RoomViewHolder viewHolder = new RoomViewHolder(view);

        viewHolder.tv_roomNumber.setText("Room Number: " + roomCount);

        viewHolder.itemView.setBackgroundColor(Color.parseColor("#003366"));

        roomCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class RoomViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        TextView tv_roomType;
        TextView tv_roomNumber;

        public RoomViewHolder(View itemView) {
            super(itemView);

            tv_roomType = (TextView) itemView.findViewById(R.id.tv_room);
            tv_roomNumber = (TextView) itemView.findViewById(R.id.tv_room_number);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            tv_roomType.setText(String.valueOf(roomType) + "->");
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition, type);
        }
    }
}
