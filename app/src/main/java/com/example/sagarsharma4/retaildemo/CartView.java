package com.example.sagarsharma4.retaildemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ListView;

public class CartView extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView list;

        if(HomePage.cart.size()==0){
            setContentView(R.layout.empty_cart);
        }
        else{
            setContentView(R.layout.activity_cart_view);
            CartAdapter adapter = new CartAdapter(CartView.this, HomePage.cart);

            list = (ListView)findViewById(R.id.cartItem);
            list.setAdapter(adapter);

        }

    }
}
