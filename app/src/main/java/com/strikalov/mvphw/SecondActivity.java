package com.strikalov.mvphw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class SecondActivity extends MvpAppCompatActivity implements SecondView {

    @InjectPresenter
    public SecondPresenter presenter;

    private EditText editText;
    private Button addButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init(){
        editText = findViewById(R.id.edit_text);
        addButton = findViewById(R.id.add_button);
        resultText = findViewById(R.id.result_text);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddButtonClicked();
            }
        });
        presenter.onViewCreate();
    }

    @Override
    public void showResult(String result) {
        resultText.setText(result);
    }

    @Override
    public void getUserText() {
        String userText = editText.getText().toString();
        presenter.onGetUserText(userText);
    }

    @Override
    public void showError(int resourceId) {
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resetEditText() {
        editText.setText("");
    }
}
