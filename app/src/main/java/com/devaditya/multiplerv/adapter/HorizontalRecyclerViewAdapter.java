package com.devaditya.multiplerv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devaditya.multiplerv.R;
import com.devaditya.multiplerv.model.HorizontalModel;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVViewHolder> {

    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_horizontal,parent,false);
        return new HorizontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder holder, int position) {
        HorizontalModel horizontalModel = arrayList.get(position);
        holder.tv.setText(horizontalModel.getName());
        holder.iv.setImageResource(R.drawable.ic_launcher_background);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getName()+"  ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class HorizontalRVViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;

        public HorizontalRVViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.txtDescription);
            iv = itemView.findViewById(R.id.img_photos);

        }
    }

}
