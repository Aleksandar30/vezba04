package com.example.vezba04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputUsername;
    private EditText inputPassword;
    private Spinner inputFaculty;
    private Switch inputEmployed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        findViewById(R.id.buttonSend).setOnClickListener(this);
    }

    private void initComponents(){
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        inputEmployed = findViewById(R.id.inputEmployed);

        inputFaculty = (Spinner) findViewById(R.id.inputFaculty);
        ArrayList<String> facultyList = new ArrayList<>();
        facultyList.add("Izaberite fakultet");
        facultyList.add("Fakultet za informatiku i racunarstvo");
        facultyList.add("Tehnicki fakultet");
        facultyList.add("Poslovni fakultet");
        facultyList.add("Fakultet za turizam i hotelijerstvo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, facultyList);
        inputFaculty.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSend){
            Intent intent = new Intent(this, ConfirmationActivity.class);


            String username = inputUsername.getText().toString();
            String password = inputPassword.getText().toString();
            String faculty = inputFaculty.getSelectedItem().toString();
            String employed = String.valueOf(inputEmployed.isChecked());
            Bundle extra = new Bundle();
            extra.putString("username", username);
            extra.putString("password", password);
            extra.putString("faculty", faculty);
            extra.putString("employed", employed);
            intent.putExtras(extra);
            startActivity(intent);
        }
    }
}