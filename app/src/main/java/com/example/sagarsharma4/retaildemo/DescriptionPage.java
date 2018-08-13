package com.example.sagarsharma4.retaildemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DescriptionPage extends Activity {
    HashMap<String, String> map = new HashMap<String, String>() {{
        put("Phone 1", "hgfxfggjffg");
        put("Phone 2", "hgfxfggjffg");
        put("Phone 3", "hgfxfggjffg");
        put("Phone 4", "hgfxfggjffg");
        put("Phone 5", "hgfxfggjffg");
        put("Phone 6", "hgfxfggjffg");
        put("Phone 7", "hgfxfggjffg");
        put("Phone 8", "hgfxfggjffg");
        put("Phone 9", "hgfxfggjffg");
        put("Phone 10", "hgfxfggjffg");
        put("Phone 11", "hgfxfggjffg");
        put("Phone 12", "hgfxfggjffg");
        put("Phone 13", "hgfxfggjffg");
        put("Phone 14", "hgfxfggjffg");
        put("Phone 15", "hgfxfggjffg");
        put("Phone 16", "hgfxfggjffg");
        put("Phone 17", "hgfxfggjffg");
        put("Phone 18", "hgfxfggjffg");
        put("Phone 19", "hgfxfggjffg");
        put("Phone 20", "hgfxfggjffg");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button buyBtnId;
        Button cartBtn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        final String rName = intent.getStringExtra("name");
        final String rPrice = intent.getStringExtra("price");
        final int rImg = intent.getIntExtra("image", 0);

        ((TextView) findViewById(R.id.itemName)).setText(rName);
        ((TextView) findViewById(R.id.itemDescription)).setText(map.get(rName));
        ((TextView) findViewById(R.id.itemPrice)).setText(rPrice);
        ((ImageView) findViewById(R.id.itemImage)).setImageResource(rImg);

        buyBtnId = (Button) findViewById(R.id.buyNow);
        cartBtn = (Button) findViewById(R.id.cartBtnDesc);

        buyBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data d = new Data(rImg, rName, rPrice, "bought");
                HomePage.cart.add(d);
            }
        });


        cartBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(DescriptionPage.this, CartView.class);
                startActivity(intent);
            }
        });

    }
}



