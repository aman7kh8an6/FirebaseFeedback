package com.example.firebasefeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register, login, result, giveFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        result = findViewById(R.id.result);
        giveFeedback = findViewById(R.id.giveFeedback);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerhere();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginhere();
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeResult();
            }
        });
        giveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givefeedback();
            }
        });
    }

    public void registerhere(){
        Intent registerIntent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(registerIntent);
    }
    public void loginhere(){
        Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(loginIntent);
    }
    public void seeResult() {
        Intent resultIntent = new Intent(getApplicationContext(), FeedbackResultActivity.class);
        startActivity(resultIntent);
    }
    public void givefeedback(){
        Intent giveFeed = new Intent(getApplicationContext(), GiveFeedback.class);
        startActivity(giveFeed);
    }
}