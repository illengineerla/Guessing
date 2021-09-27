package com.example.guessing;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editTextTextPersonName2);
        bControl = (Button)findViewById(R.id.button2);

        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void OnClick(View V){
        Integer.parseInt(etInput.getText().toString());
        tvInfo.setText(getResources().getString(R.string.ahead));

        if(!gameFinished){
            int inp = Integer.parseInt(etInput.getText().toString());
            if(inp > guess){
                tvInfo.setText("Перелет!");
            }
            if(inp < guess){
                tvInfo.setText("Недолет!");
            }
            if(inp == guess){
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else{
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение:");
            tvInfo.setText("Попробуйте угадать число (1-100)");
            gameFinished = false;
        }
        etInput.setText("");
    }
}