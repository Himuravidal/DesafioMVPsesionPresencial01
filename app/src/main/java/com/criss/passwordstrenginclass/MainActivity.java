package com.criss.passwordstrenginclass;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.criss.passwordstrenginclass.presenter.IVerifierView;
import com.criss.passwordstrenginclass.presenter.VerifierPresenter;

public class MainActivity extends AppCompatActivity implements IVerifierView {

    private EditText editText;
    private TextView textView;

    private VerifierPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        presenter = new VerifierPresenter(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.evaluatePass(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }

    private void initializeView() {
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }


    // Implemented methods
    @Override
    public void showWeekPassword() {
        textView.setBackgroundColor(Color.RED);
        textView.setText(R.string.weak);
    }

    @Override
    public void showMediumPassword() {
        textView.setBackgroundColor(getColor(R.color.orange));
        textView.setText(R.string.medium);
    }

    @Override
    public void showStrongPassword() {
        textView.setBackgroundColor(Color.YELLOW);
        textView.setText(R.string.Strong);
    }

    @Override
    public void showVeryStrongPassword() {
        textView.setBackgroundColor(Color.GREEN);
        textView.setText(R.string.Very_strong);
    }
}
