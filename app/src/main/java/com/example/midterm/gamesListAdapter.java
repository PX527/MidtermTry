package com.example.midterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class gamesListAdapter extends ArrayAdapter<Games> {
    private static final String TAG="gamesListAdapter";
    private Context mContext;
    int mResource;

    public gamesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Games> objects, Context mContext) {
        super(context, resource, objects);
        this.mContext = mContext;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name=getItem(position).getName();
        String rating=getItem(position).getRating();
        String price=getItem(position).getPrice();

        Games games=new Games(name,rating,price);

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvRating=convertView.findViewById(R.id.tvRate);
        TextView tvPrice=convertView.findViewById(R.id.tvPrice);

        tvName.setText(name);
        tvRating.setText(rating);
        tvPrice.setText(price);

        return convertView;
    }
}
