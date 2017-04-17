package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SampleActivity02 extends AppCompatActivity {

    private static final String TAG = SampleActivity02.class.getSimpleName();
    private TextView textView;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample02);
        textView = (TextView) findViewById(R.id.textView);

        interval();
        timer();
        range();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

    private void interval() {
        textView.append("interval()\n");
        disposable  =Flowable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    textView.append("interval " + aLong + "\n");
                });
    }

    private void timer() {
        textView.append("timer()\n");
        Flowable.timer(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    textView.append("timer " + aLong + "\n");
                });
    }

    private void range() {
        Flowable.range(0, 5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    textView.append("range " + aLong + "\n");
                });

    }
}
