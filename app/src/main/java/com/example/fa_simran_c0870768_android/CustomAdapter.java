package com.example.fa_simran_c0870768_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList product_id, product_name, product_desc, product_price, product_location;

    CustomAdapter(Activity activity, Context context, ArrayList product_id, ArrayList product_name, ArrayList product_desc,
                  ArrayList product_price ,ArrayList product_location ){
        this.activity = activity;
        this.context = context;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_price = product_price;
        this.product_location = product_location;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.book_id_txt.setText(String.valueOf(product_id.get(position)));
        holder.Name_txt.setText(String.valueOf(product_name.get(position)));
        holder.Desc_txt.setText(String.valueOf(product_desc.get(position)));
        holder.Price_txt.setText(String.valueOf(product_price.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(product_id.get(position)));
                intent.putExtra("name", String.valueOf(product_name.get(position)));
                intent.putExtra("desc", String.valueOf(product_desc.get(position)));
                intent.putExtra("price", String.valueOf(product_price.get(position)));
                intent.putExtra("location", String.valueOf(product_location.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return product_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_txt, Name_txt, Desc_txt, Price_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            Name_txt = itemView.findViewById(R.id.Name_txt);
            Desc_txt = itemView.findViewById(R.id.Desc_txt);
            Price_txt = itemView.findViewById(R.id.Price_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
