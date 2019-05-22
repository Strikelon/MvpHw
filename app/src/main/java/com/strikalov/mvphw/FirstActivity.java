package com.strikalov.mvphw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements FirstView{

    private EditText editText;
    private Button addButton;
    private TextView resultText;

    private FirstPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    private void init(){
        editText = findViewById(R.id.edit_text);
        addButton = findViewById(R.id.add_button);
        resultText = findViewById(R.id.result_text);
        presenter = new FirstPresenter();
        presenter.attachView(this);
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
    public void resetEditText() {
        editText.setText("");
    }

    @Override
    public void showError(int resourceId) {
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show();
    }
}
