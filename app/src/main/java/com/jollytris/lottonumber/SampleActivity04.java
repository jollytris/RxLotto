package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SampleActivity04 extends AppCompatActivity {

    private PublishSubject<Integer> subject;
    private int drawNo = 739;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample04);
        textView = (TextView) findViewById(R.id.textView);
        RxView.clicks(findViewById(R.id.button))
                .subscribe(e -> {
                    subject.onNext(drawNo--);
                });

        subject();
    }

    private void subject() {
        subject = PublishSubject.create();
        subject.subscribe(no -> {
            getWinNumber(no)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(lotto -> lotto.toString() + "\n")
                    .subscribe(textView::append);
        });
    }
    private Flowable<Lotto> getWinNumber(int number) {
        return LottoRequester.getInstance().api().getWinNumber("getLottoNumber", number);
    }
}
