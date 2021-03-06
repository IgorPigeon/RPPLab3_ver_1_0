package com.example.Lab3_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List itemIDs;
    private List itemDates;
    private List itemLast;
    private List itemNames;
    private List itemFath;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textID;
        public TextView textDate;
        public TextView textLast;
        public TextView textName;
        public TextView textFath;

        public MyViewHolder(View v){
            super(v);
            textID = v.findViewById(R.id.textID);
            textLast = v.findViewById(R.id.textLast);
            textName = v.findViewById(R.id.textName);
            textFath = v.findViewById(R.id.textFath);
            textDate = v.findViewById(R.id.textDate);
        }
    }

    public MyAdapter(List IDs,  List LastNames, List Names,List FathNames, List Dates){
        itemIDs = IDs;
        itemLast = LastNames;
        itemNames = Names;
        itemFath = FathNames;
        itemDates = Dates;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = (View) LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textID.setText(""+(long)itemIDs.get(position));
        holder.textDate.setText((String)itemDates.get(position));
        holder.textLast.setText((String)itemLast.get(position));
        holder.textName.setText((String)itemNames.get(position));
        holder.textFath.setText((String)itemFath.get(position));
    }

    @Override
    public int getItemCount() {
        return itemIDs.size();
    }
}
