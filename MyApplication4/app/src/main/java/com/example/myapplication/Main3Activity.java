package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
Button tttt,ttol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tttt = findViewById(R.id.btntt);
        ttol = findViewById(R.id.btnonl);
        tttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "Bạn vui lòng tới quầy để thanh toán, lịch của bạn đã được ghi lại", Toast.LENGTH_SHORT).show();
            }
        });
        ttol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "Chức năng thanh toán onl chưa phát triển", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
