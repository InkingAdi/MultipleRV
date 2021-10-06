package com.devaditya.multiplerv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devaditya.multiplerv.R;
import com.devaditya.multiplerv.model.HorizontalModel;
import com.devaditya.multiplerv.model.VerticalModel;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder> {


    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public VerticalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.items_vertical, parent, false);

        return new VerticalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVViewHolder holder, int position) {
        VerticalModel vm = arrayList.get(position);
        ArrayList<HorizontalModel> singleItems = vm.getArrayList();

        holder.tv.setText(vm.getTitle());

        HorizontalRecyclerViewAdapter adapter = new HorizontalRecyclerViewAdapter(context, singleItems);
        holder.rv.setAdapter(adapter);
        holder.rv.setHasFixedSize(true);

        holder.btn.setOnClickListener(v -> Toast.makeText(context, vm.getTitle().toString(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv;
        TextView tv;
        Button btn;

        public VerticalRVViewHolder(@NonNull View itemView) {
            super(itemView);

            rv = itemView.findViewById(R.id.rv_horiontal_items);
            tv = itemView.findViewById(R.id.textView);
            btn = itemView.findViewById(R.id.button);
        }
    }

}
