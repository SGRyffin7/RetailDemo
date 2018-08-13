package com.example.sagarsharma4.retaildemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends ArrayAdapter<Data>{

    private final Activity context;
    private final List<Data> d;

CartAdapter(CartView context, List<com.example.sagarsharma4.retaildemo.Data> d){
    super(context, R.layout.cart_cell_design, d);
    this.context = context;
    this.d = d;
}


    public View getView(final int position, View view, ViewGroup parent){

        Data pos = d.get(position);

        LayoutInflater inflator = context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.cart_cell_design, null, true);

        TextView cartItemName = (TextView) rowView.findViewById(R.id.cartItemName);
        TextView cartItemPrice = (TextView) rowView.findViewById(R.id.cartItemPrice);
        TextView cartItemDesc = (TextView) rowView.findViewById(R.id.cartItemDesc);
        ImageView cartItemImage = (ImageView) rowView.findViewById(R.id.cartItemImage);

        cartItemName.setText(pos.name);
        cartItemPrice.setText(pos.price);
        cartItemDesc.setText(pos.descp);
        cartItemImage.setImageResource(pos.imageID);

        Button itemDelBtn = (Button) rowView.findViewById(R.id.cartItemDelete);
        itemDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePage.cart.remove(position);
                notifyDataSetChanged();
            }
        });

        return rowView;



    }
}
