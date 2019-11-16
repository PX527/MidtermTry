package com.example.midterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.midterm.Games;
import com.example.midterm.JsonParser;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Display extends AppCompatActivity {

    private ListView listViewGame;
    private ArrayList<Games> arrayListGame = new ArrayList<>();
    private gamesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_display);

        listViewGame = findViewById(R.id.lv);
        new GetDataTask().execute();

        adapter = new gamesListAdapter(this,R.layout.adapter_view,arrayListGame);
        listViewGame.setAdapter(adapter);
        listViewGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = (Games) parent.getAdapter().getItem(position);

                Intent i = new Intent(Display.this, gamesDetails.class);
                i.putExtra("name", games.getName());
                i.putExtra("rating", games.getRating());
                i.putExtra("price", games.getPrice());
                i.putExtra("des",games.getDescription());

                startActivity(i);
            }
        });

    }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

//        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */
//            dialog = new ProgressDialog(GamesActivity.this);
//            dialog.setTitle("Hey Wait Please...");
//            dialog.setMessage("I am getting your JSON");
//            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JsonParser.getDataFromWeb();

            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */
                        JSONArray array = jsonObject.getJSONArray("data");

                        /**
                         * Check Length of Array...
                         */
                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for(int jIndex = 0; jIndex < lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                Games games = new Games();

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                JSONObject game = array.getJSONObject(jIndex);
                                String name = game.getString("name");
                                String rate = game.getString("rating");
                                String price = game.getString("price");
                                String DES = game.getString("description");

                                games.setName(name);
                                games.setRating(rate);
                                games.setPrice(price);
                                games.setDescription(DES);

                                /**
                                 * Adding name and phone concatenation in List...
                                 */
                                arrayListGame.add(games);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JsonParser.TAG, "" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */
            if(arrayListGame.size() > 0) {
                adapter.notifyDataSetChanged();
            }
        }
    }

}
