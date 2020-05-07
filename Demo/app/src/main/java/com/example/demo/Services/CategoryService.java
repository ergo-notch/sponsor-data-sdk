package com.example.demo.Services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.Fragments.JSONFragment;
import com.example.demo.Model.Category;
import com.example.demo.Utils.Constants;
import com.example.sponsordata.EncapURL;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryService {

    private static CategoryService instance = new CategoryService();
    public static CategoryService getInstance() {return instance;}
    private RequestQueue requestQueue;

    private CategoryService(){
    }

    public ArrayList<Category> getCategories(final Context context, final JSONFragment.categoriesDL listener){
        String url = "http://200.57.179.163:3008/api/category";


        final ArrayList<Category> categoriesLista = new ArrayList<>();
        final JsonArrayRequest getCategories = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray users = response;
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = users.getJSONObject(i);
                        String nombre = user.getString("name");


                        Category nuevaCategoria = new Category(nombre);
                        categoriesLista.add(nuevaCategoria);

                        Toast.makeText(context,"GET Successful",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    Log.v("JSON", "EXC" + e.getLocalizedMessage());

                }
                listener.success(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"GET Unccessful",Toast.LENGTH_SHORT).show();
                Log.v("Intern","Error"+error.getLocalizedMessage());
            }
        });
        Volley.newRequestQueue(context, new EncapURL(Constants.Companion.getDATA_SPONSOR_KEY())).add(getCategories);
        Log.i("asd","**********************************************");
        return categoriesLista;
    }
}

