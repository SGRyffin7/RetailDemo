package com.example.sagarsharma4.retaildemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Context context;
    List<Data> list= Collections.emptyList();
    public HomeAdapter(Context context, List<Data> items){
        this.context = context;
        this.list = items;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.cell_design, parent, false);
        ViewHolder item=new ViewHolder(row);
        return item;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View parentView;
        public ImageView imageView;
        public TextView nameView;
        public TextView priceView;
        public TextView descpView;

        public ViewHolder(View v) {
            super(v);
            parentView = v.findViewById(R.id.itemCell);
            imageView = (ImageView) v.findViewById(R.id.itemImageView);
            nameView = (TextView) v.findViewById(R.id.itemNameView);
            priceView = (TextView) v.findViewById(R.id.itemPriceView);
            descpView = (TextView) v.findViewById(R.id.itemDescView);
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {

        final Data getData = list.get(position);
        holder.parentView.setTag(getData.name);

        holder.imageView.setImageResource(getData.imageID);
        holder.nameView.setText(getData.name);
        holder.priceView.setText(getData.price);
        holder.descpView.setText(getData.descp);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView nameRef;
                String tag = (String)view.getTag();

                Intent intent = new Intent(context, DescriptionPage.class);
                intent.putExtra("name", getData.name);
                intent.putExtra("price", getData.price);
                intent.putExtra("image", getData.imageID);

                context.startActivity(intent);

            }
        });
    }
}