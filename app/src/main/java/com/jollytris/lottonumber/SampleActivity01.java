package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SampleActivity01 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample01);
        textView = (TextView) findViewById(R.id.textView);

        create();
        createWithLambda();
        fromIterable();
        blockSubscribe();
        asyncSubscribe();
    }

    private void create() {
        Flowable<String> f = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {

            }
        }, BackpressureStrategy.DROP);

        f.subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        });
    }

    private void createWithLambda() {
        Observable.create(text -> {

        }).subscribe(text -> {

        }, error -> {

        }, () -> {

        });
    }

    private void fromIterable() {
        Flowable.fromIterable(getLottoList())
                .take(3)
                .subscribe(lotto -> {
                    textView.append("fromIterable " + lotto.toString() + "\n\n");
                });
    }

    private void blockSubscribe() {
        Flowable.fromIterable(getLottoList())
                .filter(lottos -> lottos.getDrwNo() == 4000)
                .subscribe(lotto -> {
                    textView.append("blockSubscribe " + lotto.toString() + "\n\n");
                });
        textView.append("blockSubscribe!!\n\n");
    }

    private void asyncSubscribe() {
        Flowable.fromIterable(getLottoList())
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
