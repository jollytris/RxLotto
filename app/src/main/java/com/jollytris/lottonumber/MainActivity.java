package com.jollytris.lottonumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jakewharton.rxbinding2.view.RxView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxView.clicks(findViewById(R.id.btn_sample01)).subscribe(e -> {
            startActivity(new Intent(this, SampleActivity01.class));
        });

        RxView.clicks(findViewById(R.id.btn_sample02)).subscribe(e -> {
            startActivity(new Intent(this, SampleActivity02.class));
        });

        RxView.clicks(findViewById(R.id.btn_sample03)).subscribe(e -> {
            startActivity(new Intent(this, SampleActivity03.class));
        });

        RxView.clicks(findViewById(R.id.btn_sample04)).subscribe(e -> {
            startActivity(new Intent(this, SampleActivity04.class));
        });

        RxView.clicks(findViewById(R.id.btn_sample05)).subscribe(e -> {
            startActivity(new Intent(this, SampleActivity05.class));
        });
    }
}
