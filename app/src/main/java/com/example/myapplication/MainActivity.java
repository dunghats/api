package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.IMG_Adapter;
import com.example.myapplication.model.IMG;
import com.example.myapplication.model.Information;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<IMG> lst_IMG ;

    private RecyclerView rcvImg;
    private IMG_Adapter img_adapter;

    private TextView tvvvvv;
    private ImageView imgggg;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvImg = (RecyclerView) findViewById(R.id.rcv_img);
        tvvvvv = (TextView) findViewById(R.id.tvvvvv);
        imgggg = (ImageView) findViewById(R.id.imgggg);



        img_adapter = new IMG_Adapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvImg.setLayoutManager(gridLayoutManager);

        lst_IMG = new ArrayList<>();
        getJSON_Array_of_Objects();








    }

    public ArrayList<IMG> getJSON_Array_of_Objects(){

        //b1 Tao request
        RequestQueue queue  = Volley.newRequestQueue(this);
        //b2 url
        String url ="https://api.thecatapi.com/v1/images/search?limit=10&breed_ids=beng&api_key=REPLACE_ME&fbclid=IwAR3jAsocPzCTVhP2_Ml69slZszBjW8rpMTPw0RhgcaMaHw73RGtv1jh5lqE";
        //b3 goi request (goi mang cua doi tuong)
        //JsonArrayRequest (url . thanhcong ,that bai)
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //den day lay duoc mang
                //nhiem vu : chuyen tu mang sang doi tuong
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject person = response.getJSONObject(i);//lay ve tung doi tuong
                        IMG img = new IMG();
                        img.setId(person.getString("id"));
                        img.setUrl(person.getString("url"));
                        img.setWidth(person.getInt("width"));
                        img.setHeight(person.getInt("height"));
                        lst_IMG.add(img);
                    } catch (JSONException e) {
                        tvvvvv.setText(e.getMessage());
                    }
                }
                img_adapter.setDataIMG(lst_IMG);
                rcvImg.setAdapter(img_adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                textView.setText(error.getMessage());
            }
        });

        queue.add(request);
        return lst_IMG;
    }
}