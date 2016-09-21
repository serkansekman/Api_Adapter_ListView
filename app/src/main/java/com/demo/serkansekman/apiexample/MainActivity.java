package com.demo.serkansekman.apiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {




    ListView lvNav;
    List<PopularPersonItem> listNavItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNav = (ListView) findViewById(R.id.popularperson_list);


       // popular = new ArrayList<PopularPerson>();
       // adapter = new ArrayAdapter<PopularPerson>(this,R.layout.single_list_person,R.id.picperson,popular);
       //lvPerson= (ListView) findViewById(R.id.lvPerson);
       // lvPerson.setAdapter(adapter);

        MovieApi.getPopularPerson(null,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response ) {

                try {

                    JSONArray arr = response.getJSONArray("results");

                    listNavItems = new ArrayList<PopularPersonItem>();

                    for(int p=0;p<arr.length();p++){

                            JSONObject obj2 = arr.getJSONObject(p);
                            listNavItems.add(new PopularPersonItem(obj2.getString("name"), obj2.getString("profile_path")));


                          /* JSONArray arr2 = obj2.optJSONArray("known_for");
                               for (int i =0;i<arr2.length();i++){

                                        JSONObject obj = arr2.getJSONObject(i);

                                   listNavItems.add(new PopularPersonItem(obj2.getString("name"), obj.getString("poster_path")));

                                }*/

                        PopularPersonListAdapter navListAdapter = new PopularPersonListAdapter(getApplicationContext(), R.layout.item_nav_list, listNavItems);
                        lvNav.setAdapter(navListAdapter);

                                                   }




                    //  adapter.notifyDataSetChanged();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
}
