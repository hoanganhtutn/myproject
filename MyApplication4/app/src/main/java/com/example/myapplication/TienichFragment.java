package com.example.myapplication;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TienichFragment extends Fragment {
    public static CustomAdapter customAdapter;
    RecyclerView recyclerView;

    public static ArrayList<Item> arrayList;
    public TienichFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tienich, container, false);
        recyclerView = v.findViewById(R.id.recycletienich);
        arrayList = new ArrayList<>() ;
        customAdapter = new CustomAdapter(arrayList, (Main2Activity) getContext());
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(customAdapter);
        ReadJSON("http://192.168.1.4:8080/android_btlon/getdata.php");

        return v;
    }

    private void ReadJSON(String s) {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, s, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Log.d("kt", String.valueOf(response));
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrayList.add(new Item(
                                jsonObject.getInt("id"),
                                jsonObject.getInt("gia"),
                                jsonObject.getInt("time"),
                                jsonObject.getString("thongtin")
                        ));
                        customAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("kt", String.valueOf(error));
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }


}
