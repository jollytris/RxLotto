package com.jollytris.lottonumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SampleActivity03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample03);
    }

    private io.reactivex.Observable<Lotto> getWinNumber(int number) {
        return LottoRequester.getInstance().api().getWinNumber("getLottoNumber", number);
    }
}
