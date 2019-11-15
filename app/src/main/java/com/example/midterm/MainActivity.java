package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername,edtPassword;
    private Button btnLogin;
    private String uName="RJ",uPass="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListen();
    }
    public void findViews(){
        edtUsername=findViewById(R.id.uName);
        edtPassword=findViewById(R.id.uPass);
        btnLogin=findViewById(R.id.login);
    }

    private void setListen(){
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String inputUsername=edtUsername.getText().toString();
                String inputPassword=edtPassword.getText().toString();

                if(inputUsername.equals(uName) && inputPassword.equals(uPass)){

                    Toast.makeText(MainActivity.this, "Login Sucessfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Display.class);
                    startActivity(i);
                    //finish();

                }else{
                    Toast.makeText(MainActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();

                }
            }

        });



    }
}
