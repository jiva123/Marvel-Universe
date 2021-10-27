package com.oyelabs.marvel.universe;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class testing_pg_url extends AppCompatActivity {

    String description,name;

    TextView txt_description,nam_txt;
    ImageView img_character_icon;

    JSONObject characterDetailsObject;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_pg);

        nam_txt = findViewById(R.id.name_ch);
        txt_description = findViewById(R.id.description_char);
        img_character_icon = findViewById(R.id.imageView_h);

        final String characterName = getIntent().getStringExtra("characterName");

        final RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        String hashedValue = "360cb48480f00b72756b61dc6a5a2519";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://gateway.marvel.com/v1/public/characters?name="+characterName+"&ts=1&apikey=cce69940ffb1664469c16c02ced56b8b&hash=" + hashedValue, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject object1 = response.getJSONObject("data");
                    JSONArray array1 = object1.getJSONArray("results");
                    characterDetailsObject = array1.getJSONObject(0);
//
                    name = characterDetailsObject.getString("name");
//
                    nam_txt.setText(name);

                    description = characterDetailsObject.getString("description");
//
                    txt_description.setText(description);

                    assert characterName != null;
                    if (characterName.equals("Iron man")){
                        img_character_icon.setImageResource(R.drawable.iron_man_icon);
                    }

                    if (characterName.equals("Hulk")){
                        img_character_icon.setImageResource(R.drawable.hulk_icon);
                    }

                    if (characterName.equals("Black widow")){
                        img_character_icon.setImageResource(R.drawable.black_widow_icon);
                    }

                    if (characterName.equals("Black panther")){
                        img_character_icon.setImageResource(R.drawable.black_panther_icon);
                    }

                    if (characterName.equals("Bucky")){
                        img_character_icon.setImageResource(R.drawable.bucky_icon);
                    }

                    if (characterName.equals("captain america")){
                        img_character_icon.setImageResource(R.drawable.captain_america_icon);
                    }

                    if (characterName.equals("Deadpool")){
                        img_character_icon.setImageResource(R.drawable.deadpool_icon);
                    }

                    if (characterName.equals("Drax")){
                        img_character_icon.setImageResource(R.drawable.drax_icon);
                    }

                    if (characterName.equals("Falcon")){
                        img_character_icon.setImageResource(R.drawable.falcon_icon);
                    }

                    if (characterName.equals("Groot")){
                        img_character_icon.setImageResource(R.drawable.groot_icon);
                    }

                    if (characterName.equals("Hawkeye")){
                        img_character_icon.setImageResource(R.drawable.hawkeye_icon);
                    }

                    if (characterName.equals("Loki")){
                        img_character_icon.setImageResource(R.drawable.loki_icon);
                    }

                    if (characterName.equals("Mantis")){
                        img_character_icon.setImageResource(R.drawable.mantic_icon);
                    }

                    if (characterName.equals("Nebula")){
                        img_character_icon.setImageResource(R.drawable.nebula_icon);
                    }

                    if (characterName.equals("Korg")){
                        img_character_icon.setImageResource(R.drawable.korg_icon);
                    }

                    if (characterName.equals("Nick fury")){
                        img_character_icon.setImageResource(R.drawable.nick_fury_icon);
                    }

                    if (characterName.equals("Okoye")){
                        img_character_icon.setImageResource(R.drawable.okoye_icon);
                    }

                    if (characterName.equals("Scarlet witch")){
                        img_character_icon.setImageResource(R.drawable.scarlet_witch_icon);
                    }

                    if (characterName.equals("Thanos")){
                        img_character_icon.setImageResource(R.drawable.thanos_icon);
                    }

                    if (characterName.equals("Thor")){
                        img_character_icon.setImageResource(R.drawable.thor_icon);
                    }

                    if (characterName.equals("wasp")){
                        img_character_icon.setImageResource(R.drawable.wasp_icon);
                    }

                    if (characterName.equals("Vision")){
                        img_character_icon.setImageResource(R.drawable.vision_icon);
                    }

                    if (characterName.equals("wolverine")){
                        img_character_icon.setImageResource(R.drawable.wolverine_icon);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("marvel", "Something went wrong");

            }
        });

        requestQueue.add(jsonObjectRequest);


    }

}
