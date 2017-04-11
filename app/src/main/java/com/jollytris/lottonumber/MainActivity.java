package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkRequester.getInstance().api().getWinNumber("getLottoNumber", 749)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Lotto>() {
                    @Override
                    public void accept(@NonNull Lotto lotto) throws Exception {
                        Log.d("TEST", lotto.toString());
                    }
                });
    }
}
