package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class gamesDetails extends AppCompatActivity {
    private String gameDetails1="[name]";
    private String gameDetails2="Rating : [rating]\n" + "Price : [price]\n"+"Description : \n[description]";
    private String name,rating,price,description;
    private TextView tvGamesDetails1,tvGamesDetails2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_details);

        name=getIntent().getStringExtra("name");
        rating=getIntent().getStringExtra("rating");
        price=getIntent().getStringExtra("price");
        description=getIntent().getStringExtra("description");

        replaceData();
        tvGamesDetails1=findViewById(R.id.tvGamesDetails1);
        tvGamesDetails2=findViewById(R.id.tvGamesDetails2);
        tvGamesDetails1.setText(gameDetails1);
        tvGamesDetails2.setText(gameDetails2);

    }
    private void replaceData(){
        gameDetails1=gameDetails1.replace("[name]",name);
        gameDetails2=gameDetails2.replace("[rating]",rating);
        gameDetails2=gameDetails2.replace("[price]",price);
    }
}
