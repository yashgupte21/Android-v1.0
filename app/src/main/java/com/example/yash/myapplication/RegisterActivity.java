package com.example.yash.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etFullName = (EditText) findViewById(R.id.etFullName);
        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        final EditText etConatctNo = (EditText) findViewById(R.id.etContactNo);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        AddData();



    }


    public void AddData(){
        View bRegister;
        bRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatabaseHelper userDb;
                      boolean isInserted = userDb.insertData(etFullName.getText().toString(),
                                etUserName.getText().toString(),
                                etConatctNo.getText().toString(),
                                etPassword.getText().toString() );
                      if(isInserted = true)
                          Toast.makeText(RegisterActivity.this , "Sign up successfull" , Toast.LENGTH_LONG).show();

                      else
                          Toast.makeText(RegisterActivity.this , "Sign up Unsuccessfull" , Toast.LENGTH_LONG).show();
                    }
                }


        );
    }



}
