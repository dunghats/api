package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.Infor_Adapter;
import com.example.myapplication.model.IMG;
import com.example.myapplication.model.Information;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityInformation extends AppCompatActivity {
    private RecyclerView rcvInfor;
    private TextView tvActivityInformation;
    private Infor_Adapter infor_adapter;
    static String key_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        tvActivityInformation = (TextView) findViewById(R.id.tv_activityInformation);

        rcvInfor = (RecyclerView) findViewById(R.id.rcv_infor);
        infor_adapter = new Infor_Adapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        rcvInfor.setLayoutManager(gridLayoutManager);

        key_id = getIntent().getStringExtra("key_id");

        getJSON_Array_of_Objects();
    }
    public void getJSON_Array_of_Objects(){

        ArrayList<Information> lst_INF = new ArrayList<>();
        //b1 Tao request
        RequestQueue queue  = Volley.newRequestQueue(this);
        //b2 url
        String url ="https://api.thecatapi.com/v1/images/8pCFG7gCV?fbclid=IwAR0o_R4lpvI1AYDWru7ggjudxdNhGpr-_EicoWtQcJ9nRlg_dZaeslvxNvM";
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
                        Information information = new Information();

                        information.setId(person.getString("id"));
                        information.setUrl(person.getString("url"));
                        information.setWidth(person.getInt("width"));
                        information.setHeight(person.getInt("height"));
                        JSONObject breeds = person.getJSONObject("breeds");
                        JSONObject weight =breeds.getJSONObject("weight");
                        information.setWeight_imperial(weight.getString("imperial"));
                        information.setGetWeight_metric(weight.getString("metric"));
                        information.setBreeds_id(breeds.getString("id"));
                        information.setBreeds_name(breeds.getString("name"));
                        information.setCfa_url(breeds.getString("cfa_url"));
                        information.setVetstreet_url(breeds.getString("vetstreet_url"));
                        information.setVcahospitals_url(breeds.getString("vcahospitals_url"));
                        information.setTemperament(breeds.getString("temperament"));
                        information.setOrigin(breeds.getString("origin"));
                        information.setCountry_code(breeds.getString("country_code"));
                        information.setCountry_codes(breeds.getString("country_codes"));
                        information.setDescription(breeds.getString("description"));
                        information.setLife_span(breeds.getString("life_span"));
                        information.setIndoor(breeds.getInt("indoor"));
                        information.setLap(breeds.getInt("lap"));
                        information.setAdaptability(breeds.getInt("adaptability"));
                        information.setAffection_level(breeds.getInt("affection_level"));
                        information.setChild_friendly(breeds.getInt("child_friendly"));
                        information.setCat_friendly(breeds.getInt("cat_friendly"));
                        information.setDog_friendly(breeds.getInt("dog_friendly"));
                        information.setEnergy_level(breeds.getInt("energy_level"));
                        information.setGrooming(breeds.getInt("grooming"));
                        information.setHealth_issues(breeds.getInt("health_issues"));
                        information.setIntelligence(breeds.getInt("intelligence"));
                        information.setShedding_level(breeds.getInt("shedding_level"));
                        information.setSocial_needs(breeds.getInt("social_needs"));
                        information.setStranger_friendly(breeds.getInt("stranger_friendly"));
                        information.setVocalisation(breeds.getInt("vocalisation"));
                        information.setBidability(breeds.getInt("bidability"));
                        information.setExperimental(breeds.getInt("experimental"));
                        information.setHairless(breeds.getInt("hairless"));
                        information.setNatural(breeds.getInt("natural"));
                        information.setRare(breeds.getInt("rare"));
                        information.setRex(breeds.getInt("rex"));
                        information.setSuppressed_tail(breeds.getInt("suppressed_tail"));
                        information.setShort_legs(breeds.getInt("short_legs"));
                        information.setWikipedia_url(breeds.getString("wikipedia_url"));
                        information.setHypoallergenic(breeds.getInt("hypoallergenic"));
                        information.setReference_image_id(breeds.getString("reference_image_id"));

                        lst_INF.add(information);


                    } catch (JSONException e) {
                        tvActivityInformation.setText(e.getMessage());
                    }
                }
                if (lst_INF.size()!=0){
                    tvActivityInformation.setText(lst_INF.size());
                }else {
                    tvActivityInformation.setText("rong");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvActivityInformation.setText(error.getMessage());
            }
        });

        JsonObjectRequest request1 = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject person) {
                Information information = new Information();
                try {
                    information.setId(person.getString("id"));
                    information.setUrl(person.getString("url"));
                    information.setWidth(person.getInt("width"));
                    information.setHeight(person.getInt("height"));
                    JSONArray breeds = person.getJSONArray("breeds");
                    JSONObject breeds1 = breeds.getJSONObject(0);
                    JSONObject weight = breeds1.getJSONObject("weight");
                    information.setWeight_imperial(weight.getString("imperial"));
                    information.setGetWeight_metric(weight.getString("metric"));
                    information.setBreeds_id(breeds1.getString("id"));
                    information.setBreeds_name(breeds1.getString("name"));
                    information.setCfa_url(breeds1.getString("cfa_url"));
                    information.setVetstreet_url(breeds1.getString("vetstreet_url"));
                    information.setVcahospitals_url(breeds1.getString("vcahospitals_url"));
                    information.setTemperament(breeds1.getString("temperament"));
                    information.setOrigin(breeds1.getString("origin"));
                    information.setCountry_code(breeds1.getString("country_code"));
                    information.setCountry_codes(breeds1.getString("country_codes"));
                    information.setDescription(breeds1.getString("description"));
                    information.setLife_span(breeds1.getString("life_span"));
                    information.setIndoor(breeds1.getInt("indoor"));
                    information.setLap(breeds1.getInt("lap"));
                    information.setAdaptability(breeds1.getInt("adaptability"));
                    information.setAffection_level(breeds1.getInt("affection_level"));
                    information.setChild_friendly(breeds1.getInt("child_friendly"));
                    information.setCat_friendly(breeds1.getInt("cat_friendly"));
                    information.setDog_friendly(breeds1.getInt("dog_friendly"));
                    information.setEnergy_level(breeds1.getInt("energy_level"));
                    information.setGrooming(breeds1.getInt("grooming"));
                    information.setHealth_issues(breeds1.getInt("health_issues"));
                    information.setIntelligence(breeds1.getInt("intelligence"));
                    information.setShedding_level(breeds1.getInt("shedding_level"));
                    information.setSocial_needs(breeds1.getInt("social_needs"));
                    information.setStranger_friendly(breeds1.getInt("stranger_friendly"));
                    information.setVocalisation(breeds1.getInt("vocalisation"));
                    information.setBidability(breeds1.getInt("bidability"));
                    information.setExperimental(breeds1.getInt("experimental"));
                    information.setHairless(breeds1.getInt("hairless"));
                    information.setNatural(breeds1.getInt("natural"));
                    information.setRare(breeds1.getInt("rare"));
                    information.setRex(breeds1.getInt("rex"));
                    information.setSuppressed_tail(breeds1.getInt("suppressed_tail"));
                    information.setShort_legs(breeds1.getInt("short_legs"));
                    information.setWikipedia_url(breeds1.getString("wikipedia_url"));
                    information.setHypoallergenic(breeds1.getInt("hypoallergenic"));
                    information.setReference_image_id(breeds1.getString("reference_image_id"));
                } catch (JSONException e) {
                    tvActivityInformation.setText(e.getMessage());
                }

                lst_INF.add(information);
                boolean check =false;
                String idd = null;
                for(int i=0;i<lst_INF.size();i++){
                    Information information1 =lst_INF.get(i);
                    idd=information1.getReference_image_id();
                    if (idd.equals(key_id)){
                        infor_adapter.setData(information1);
                        rcvInfor.setAdapter(infor_adapter);
                        check=true;
                    }
                }
                if (check==false){
                    tvActivityInformation.setText("No Data");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request1);

    }
}