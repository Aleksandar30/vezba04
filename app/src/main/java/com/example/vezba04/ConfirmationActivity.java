package com.example.vezba04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView labelMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        initComponents();


        Bundle extra = getIntent().getExtras();
        String username = extra.getString("username");
        String password = extra.getString("password");
        String faculty = extra.getString("faculty");
        String employed = extra.getString("employed");

        labelMessage.setText(username + "\n" + password + "\n" + faculty + "\n" + employed + "\n");
    }


    private void initComponents(){
        labelMessage = findViewById(R.id.labelMessage);
    }
}