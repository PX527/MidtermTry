package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    private ListView lv;
    private ArrayList<String> names=new ArrayList<>();//data source
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        lv=findViewById(R.id.lv);

        //Create games object
        Games g1=new Games("Half-Life 2","9.9/10","$20","game 1 des");
        Games g2=new Games("CS:GO","8/10","$15","game2 desc");
        Games g3=new Games("Fallout 76","2/10","$3","game3 desc");

        ArrayList<Games> gamesList=new ArrayList<>();

        gamesList.add(g1);
        gamesList.add(g2);
        gamesList.add(g3);

        gamesListAdapter adapter=new gamesListAdapter(this,R.layout.adapter_view,gamesList,this);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = (Games) parent.getAdapter().getItem(position);

                Intent i = new Intent(Display.this, gamesDetails.class);
                i.putExtra("name", games.getName());
                i.putExtra("rating", games.getRating());
                i.putExtra("price", games.getPrice());
                i.putExtra("description", games.getDescription());
                startActivity(i);
            }
        });

        /*private void setListen(){
            gamesListAdapter.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    String inputUsername=edtUsername.getText().toString();
                    String inputPassword=edtPassword.getText().toString();

                    if(inputUsername.equals(uName) && inputPassword.equals(uPass)){

                        Toast.makeText(MainActivity.this, "Login Sucessfully",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,Display.class);
                        startActivity(i);
                        //finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }*/
    }


}
