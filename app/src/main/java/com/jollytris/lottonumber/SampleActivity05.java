package com.jollytris.lottonumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;

public class SampleActivity05 extends AppCompatActivity {

    private EditText number01;
    private EditText number02;
    private EditText number03;
    private EditText number04;
    private EditText number05;
    private EditText number06;
    private TextView stateTextView;
    private Button requestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample05);

        number01 = (EditText) findViewById(R.id.number01);
        number02 = (EditText) findViewById(R.id.number02);
        number03 = (EditText) findViewById(R.id.number03);
        number04 = (EditText) findViewById(R.id.number04);
        number05 = (EditText) findViewById(R.id.number05);
        number06 = (EditText) findViewById(R.id.number06);
        stateTextView = (TextView) findViewById(R.id.stateTextView);
        requestButton = (Button) findViewById(R.id.requestButton);

        binding();
    }

    private void binding() {
        Observable<Boolean> ob1 = RxTextView.textChanges(number01).map(c -> !TextUtils.isEmpty(c.toString())).share();
        Observable<Boolean> ob2 = RxTextView.textChanges(number02).map(c -> !TextUtils.isEmpty(c.toString())).share();
        Observable<Boolean> ob3 = RxTextView.textChanges(number03).map(c -> !TextUtils.isEmpty(c.toString())).share();
        Observable<Boolean> ob4 = RxTextView.textChanges(number04).map(c -> !TextUtils.isEmpty(c.toString())).share();
        Observable<Boolean> ob5 = RxTextView.textChanges(number05).map(c -> !TextUtils.isEmpty(c.toString())).share();
        Observable<Boolean> ob6 = RxTextView.textChanges(number06).map(c -> !TextUtils.isEmpty(c.toString())).share();

        Observable.combineLatest(ob1, ob2, ob3, ob4, ob5, ob6,
                (b1, b2, b3, b4, b5, b6) -> b1 && b2 && b3 && b4 && b5 && b6)
                .subscribe(b -> {
                    RxView.enabled(requestButton).accept(b);
                });
    }
}
