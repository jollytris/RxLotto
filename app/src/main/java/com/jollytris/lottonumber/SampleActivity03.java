package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SampleActivity03 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample03);
        textView = (TextView) findViewById(R.id.textView);

        single();
        merge();
        zip();
        filter();
    }

    private void single() {
        getWinNumber(730)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append("single " + lotto.toString() + "\n");
                });
    }

    private void merge() {
        Flowable.merge(getWinNumber(600), getWinNumber(601))
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append("merge : " + lotto + "\n");
                });
    }

    private void zip() {
        Flowable<Integer> l1 = getWinNumber(600).flatMapIterable(l -> l.getDrwtNos());
        Flowable<Integer> l2 = getWinNumber(601).flatMapIterable(l -> l.getDrwtNos());
        Flowable.zip(l1, l2, (n1, n2) -> n1 + n2)
                .delay(4, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(no -> {
                    textView.append("zip : " + no + "\n");
                });
    }

    private void filter() {
        Flowable.range(0, 5)
                .map(no -> getWinNumber(no).blockingFirst())
                .filter(lotto -> lotto.getDrwNo() == 3)
                .delay(6, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append("filter : " + lotto + "\n");
                });
    }

    private Flowable<Lotto> getWinNumber(int number) {
        return LottoRequester.getInstance().api().getWinNumber("getLottoNumber", number);
    }
}
