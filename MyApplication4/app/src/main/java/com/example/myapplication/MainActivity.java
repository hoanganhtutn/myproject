package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editTextuser, editTextpass;
    Button btndki, btndangnhap, btnthoat;
    String ten,mk;
    public static ArrayList<login> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        ControlButton();
//        ReadJSON("http://192.168.141.1:8080/baitaplon/getdata.php");

    }

    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc chắn muốn thoát khỏi app không?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhân !");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btndki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại xử lí đăng kí");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edtk = (EditText) dialog.findViewById(R.id.edtk);
                final EditText edmk = (EditText) dialog.findViewById(R.id.edmk);
                Button btnok = (Button) dialog.findViewById(R.id.btnok);
                Button btnhuy = (Button) dialog.findViewById(R.id.btnhuy);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edtk.getText().toString().trim();
                        mk = edmk.getText().toString().trim();

                        editTextuser.setText(ten);
                        editTextpass.setText(mk);
                        DKI(ten,mk);
                        dialog.cancel();
                    }
                });
           btnhuy.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   dialog.cancel();
               }
           });
           dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextuser.getText().length() != 0 && editTextpass.getText().length() != 0) {
                    String url = "http://192.168.141.1:8080/baitaplon/login.php";
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.trim().equals("success")){
                                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(MainActivity.this,"Sai", Toast.LENGTH_SHORT).show();
                            }

                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }
                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String>  params = new HashMap<>();
                            params.put("username",editTextuser.getText().toString());
                            params.put("password", editTextpass.getText().toString());
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void Anhxa() {
        editTextuser = findViewById(R.id.eduser);
        editTextpass = findViewById(R.id.edpass);
        btndki = findViewById(R.id.btndki);
        btndangnhap = findViewById(R.id.btndangnhap);
        btnthoat = findViewById(R.id.btnthoat);
    }
    private void DKI(final String ten , final String mk){
        String url = "http://192.168.141.1:8080/baitaplon/insert.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();


                }else {
                    Toast.makeText(MainActivity.this,"Tài khoản không được trùng hoặc sai", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>  params = new HashMap<>();
                params.put("username",ten);
                params.put("password", mk);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
//    private void ReadJSON(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("kiemtra", String.valueOf(response));
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//                        arrayList.add(new login(
//                                jsonObject.getInt("id"),
//                                jsonObject.getString("username"),
//                                jsonObject.getString("password")
//                        ));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
//                        Log.e("kiemtra", String.valueOf(error));
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//    }
}
