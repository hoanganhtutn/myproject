package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LienheFragment extends Fragment {
    Button buttonsubmit;
    EditText tenkh,diachi,sdt,email, ghichu,magiamgia;
    String urlInsert = "http://192.168.1.4:8080/android_ttkhachhang/add.php";
    public LienheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_lienhe, container, false);
        tenkh = v.findViewById(R.id.editten);
        diachi = v.findViewById(R.id.editdc);
        sdt = v.findViewById(R.id.editsdt);
        email = v.findViewById(R.id.editemail);
        ghichu = v.findViewById(R.id.edityeucau);
        magiamgia = v.findViewById(R.id.editkm);
        buttonsubmit = v.findViewById(R.id.btnsubmit);
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edten = tenkh.getText().toString().trim();
                String eddiachi = diachi.getText().toString().trim();
                String edsdt = sdt.getText().toString().trim();
                String edmail = email.getText().toString().trim();
                if(edten.isEmpty() || eddiachi.isEmpty() || edsdt.isEmpty() || edmail.isEmpty() ){
                    Toast.makeText(getContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    addTTKH(urlInsert);
                }
            }
        });
        return  v;
    }
    private void addTTKH(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Main2Activity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getActivity(), "Lỗi tùm lum khi thêm", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Lỗi nặng", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>  params = new HashMap<>();
                params.put("tenkh", tenkh.getText().toString().trim());
                params.put("diachikh", diachi.getText().toString().trim());
                params.put("sdtkh", sdt.getText().toString().trim());
                params.put("email", email.getText().toString().trim());
                params.put("ghichu", ghichu.getText().toString().trim());
                params.put("makhuyenmai", magiamgia.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
