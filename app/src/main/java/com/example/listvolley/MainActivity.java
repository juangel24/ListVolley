package com.example.listvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.listvolley.adapters.AdaptadorPersonas;
import com.example.listvolley.models.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
    }

    public void click(View view) {
        JsonArrayRequest jsonArray = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/lista", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        TypeToken<List<Persona>> PersonaList = new TypeToken<List<Persona>>() {};

                        List<Persona> personas = new Gson().fromJson(response.toString(), PersonaList.getType());

                        listView.setAdapter(
                                new AdaptadorPersonas(getApplicationContext(), personas)
                        );
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArray);
    }
}
