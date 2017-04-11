package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SampleActivity03 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample03);
        textView = (TextView) findViewById(R.id.textView);

        getWinNumber(730)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append(lotto.toString() + "\n\n");
                });

        Observable.zip(getWinNumber(700), getWinNumber(731), (lotto, lotto2) -> lotto.toString() + "\n" + lotto2.toString())
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    textView.append(result + "\n\n");
                });

        Observable.merge(getWinNumber(600), getWinNumber(601))
                .delay(4, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append(lotto + "\n");
                });

    }

    private Observable<Lotto> getWinNumber(int number) {
        return LottoRequester.getInstance().api().getWinNumber("getLottoNumber", number);
    }
}
