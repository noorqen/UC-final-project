package com.example.fridge;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    List<Products> ProductsList;
    Context context;

    public ItemAdapter(List<Products> productsList, Context context) {
        this.ProductsList = productsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).tv_prodName.setText(ProductsList.get(position).getProdname());
        ((ViewHolder)holder).tv_prodDate.setText(String.valueOf(ProductsList.get(position).getExpirydate()));
        ((ViewHolder)holder).tv_prodMM2.setText(String.valueOf(ProductsList.get(position).getExpiryMM()));
        ((ViewHolder)holder).tv_prodyyyy2.setText(String.valueOf(ProductsList.get(position).getExpiryyyy()));
        Glide.with(context).load(ProductsList.get(position).getImageLink()).into(holder.iv_prodpic);
        ((ViewHolder)holder).tv_prodQuant.setText(String.valueOf(ProductsList.get(position).getQuantityno()));
        ((ViewHolder)holder).parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Buttons.class);
                intent.putExtra("id", ProductsList.get(position).getId());
                context.startActivity(intent);
            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Products removedprod = ProductsList.get(position);
                int x = position;
                AlertDialog.Builder alert = new AlertDialog.Builder(context)
                        .setTitle("Attention!")
                        .setMessage("Are you sure you want to delete this product?")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ProductsList.remove(position);
                                notifyDataSetChanged();
                                Snackbar.make(context, view, "1 product deleted", 3000)
                                        .setAction("undo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                ProductsList.add(position, removedprod);
                                                notifyDataSetChanged();
                                            }
                                        }).show();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alert.show();
            }
        });
        //decrement button
    }

    @Override
    public int getItemCount() {
        return ProductsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_prodpic, delete;
        TextView tv_prodName, tv_prodQuant, tv_prodDate, tv_prodMM2, tv_prodyyyy2;
        ConstraintLayout parentLayout;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v=itemView;
            iv_prodpic = v.findViewById(R.id.iv_prodpic);
            tv_prodName = v.findViewById(R.id.tv_productname);
            tv_prodQuant = v.findViewById(R.id.tv_quantity);
            tv_prodDate = v.findViewById(R.id.tv_expirydate);
            tv_prodMM2 = v.findViewById(R.id.tv_expiryMM2);
            tv_prodyyyy2 = v.findViewById(R.id.tv_expiryyyy2);
            parentLayout = v.findViewById(R.id.oneproductcard);
            delete = v.findViewById(R.id.imagedelete);
        }
    }
}
