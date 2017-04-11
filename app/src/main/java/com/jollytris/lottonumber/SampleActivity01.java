package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SampleActivity01 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample01);
        textView = (TextView) findViewById(R.id.textView);

        fromIterable();
        blockSubscribe();
        asyncSubscribe();
    }

    private void fromIterable() {
        Observable.fromIterable(getLottoList())
                .take(3)
                .subscribe(lotto -> {
                    textView.append("fromIterable " + lotto.toString() + "\n\n");
                });
    }

    private void blockSubscribe() {
        Observable.fromIterable(getLottoList())
                .filter(lottos -> lottos.getDrwNo() == 4000)
                .subscribe(lotto -> {
                    textView.append("blockSubscribe " + lotto.toString() + "\n\n");
                });
        textView.append("blockSubscribe!!\n\n");
    }

    private void asyncSubscribe() {
        Observable.fromIterable(getLottoList())
                .filter(lottos -> lottos.getDrwNo() == 4000)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lotto -> {
                    textView.append("asyncSubscribe " + lotto.toString() + "\n\n");
                });
        textView.append("asyncSubscribe!!\n\n");
    }

    private List<Lotto> getLottoList() {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(getLotto(i));
        }
        return list;
    }

    private Lotto getLotto(int drwNo) {
        Lotto lotto = new Lotto();
        lotto.setDrwNo(drwNo);
        return lotto;
    }
}
