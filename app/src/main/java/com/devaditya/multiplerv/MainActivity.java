package com.devaditya.multiplerv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.devaditya.multiplerv.adapter.VerticalRecyclerViewAdapter;
import com.devaditya.multiplerv.model.HorizontalModel;
import com.devaditya.multiplerv.model.VerticalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_vertical;
    final ArrayList<VerticalModel> arrayList = new ArrayList<>();
    VerticalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_vertical = findViewById(R.id.vertical_rv);

        adapter = new VerticalRecyclerViewAdapter(this, arrayList);

        rv_vertical.setAdapter(adapter);

        setData();

    }

    public void setData() {

        for (int i = 0; i < 5; i++) {

            VerticalModel ver_model = new VerticalModel();

            ArrayList<HorizontalModel> hor_array_list = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                HorizontalModel hor_model = new HorizontalModel();
                hor_model.setDescription("Description: " + j);
                hor_model.setName("Name: " + j);

                hor_array_list.add(hor_model);
            }
            ver_model.setArrayList(hor_array_list);
            ver_model.setTitle("Title: " + i);

            arrayList.add(ver_model);

        }
        adapter.notifyDataSetChanged();
    }
}