package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        Games g1=new Games("Half-Life 2","9.9/10","$20");
        Games g2=new Games("CS:GO","8/10","$15");
        Games g3=new Games("Fallout 76","2/10","$3");

        ArrayList<Games> gamesList=new ArrayList<>();

        gamesList.add(g1);
        gamesList.add(g2);
        gamesList.add(g3);

        gamesListAdapter adapter=new gamesListAdapter(this,R.layout.adapter_view,gamesList,this);
        lv.setAdapter(adapter);

        /*gamesListAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = (Games) parent.getAdapter().getItem(position);

                Intent i = new Intent(Display.this, gamesDetails.class);
                i.putExtra("name", getName());
                i.putExtra("id", student.getStudId());
                i.putExtra("course", student.getStudCourse());
                startActivity(i);
            }
        });  */
    }


}
