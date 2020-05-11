package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<Item> arrayList;
    Context context;

    public CustomAdapter(ArrayList<Item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_tienich,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder,final int position) {
        final Item it = arrayList.get(position);
        holder.Gia.setText(String.valueOf("Giá: "+ it.getGia())+"VND");
        holder.Time.setText(String.valueOf( "Time: " +it.getTime())+"min");
        holder.Thongtin.setText( "Thông tin: " +it.getThongtin());
        holder.dathang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(),Main3Activity.class);
                intent.putExtra("", String.valueOf(it));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Gia,Time,Thongtin;
        Button dathang1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Gia = (TextView) itemView.findViewById(R.id.gia1);
            Time = (TextView) itemView.findViewById(R.id.time1);
            Thongtin = (TextView) itemView.findViewById(R.id.tt1);
            dathang1 = (Button) itemView.findViewById(R.id.btndathang1) ;

        }
    }
}
