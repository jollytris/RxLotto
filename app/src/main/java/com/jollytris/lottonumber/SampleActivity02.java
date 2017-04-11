package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SampleActivity02 extends AppCompatActivity {

    private static final String TAG = SampleActivity02.class.getSimpleName();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample02);
        textView = (TextView) findViewById(R.id.textView);

        interval();
        timer();
        backgroundInterval();
    }

    private void interval() {
        textView.append("interval()\n");
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    textView.append("interval " + aLong + "\n");
                });
    }

    private void timer() {
        textView.append("timer()\n");
        Observable.timer(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    textView.append("timer " + aLong + "\n");
                });
    }

    private void backgroundInterval() {
        textView.append("backgroundInterval()\n");
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(aLong -> {
                    Log.d(TAG, "backgroundInterval " + aLong);
                });
    }
}
