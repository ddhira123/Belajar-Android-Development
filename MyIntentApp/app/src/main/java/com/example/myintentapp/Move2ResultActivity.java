package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Move2ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnChoose;
    private RadioGroup rgNumber;

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE = 110;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move2_result);

        btnChoose = findViewById(R.id.pilihangka);
        rgNumber = findViewById(R.id.rg_numbers);

        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.pilihangka){
            if (rgNumber.getCheckedRadioButtonId() != 0){
                int val = 0;
                switch (rgNumber.getCheckedRadioButtonId()){
                    case R.id.rb_10:
                        val = 10;
                        break;
                    case R.id.rb_20:
                        val = 20;
                        break;
                    case R.id.rb_30:
                        val = 30;
                        break;
                    case R.id.rb_50:
                        val = 50;
                        break;
                    case R.id.rb_60:
                        val = 60;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, val);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}