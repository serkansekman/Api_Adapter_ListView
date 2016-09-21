package com.demo.serkansekman.apiexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by serkan.sekman on 9/13/2016.
 */
public class PopularPersonListAdapter extends ArrayAdapter<PopularPersonItem> {

    Context context;
    int resLayout;
    List<PopularPersonItem> listNavItems;

    public PopularPersonListAdapter(Context context, int resLayout, List<PopularPersonItem> listNavItems) {
        super(context, resLayout, listNavItems);

        this.context=context;
        this.resLayout = resLayout;
        this.listNavItems=listNavItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context,resLayout,null);

        TextView name= (TextView) v.findViewById(R.id.name);
        ImageView profile_path= (ImageView) v.findViewById(R.id.profile_path);
        //ImageView poster_path= (ImageView) v.findViewById(R.id.poster_path);

        PopularPersonItem navItem= listNavItems.get(position);

        name.setText(navItem.getName());


       // profile_path.setText(navItem.getProfile_path());
       // poster_path.setImageResource(navItem.getPoster_path());

        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+ navItem.getProfile_path())
                .resize(100, 120)
                .centerCrop()
                .into(profile_path);


        return v;
    }
}
