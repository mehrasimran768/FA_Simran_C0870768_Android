package com.example.fa_simran_c0870768_android;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.TasksViewHolder>{
    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_view, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Product t = productList.get(position);
        holder.textViewId.setText(t.getPID());
        holder.textViewName.setText(t.getName());
//        holder.textViewLocation.setText((int) t.getLongitude());
//        holder.textViewLocation.setText((int) t.getLatitude());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewId, textViewName, textViewLocation;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Product product = productList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateProductActivity.class);


            mCtx.startActivity(intent);
        }



    }
}
