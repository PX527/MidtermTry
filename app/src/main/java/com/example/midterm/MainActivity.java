package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername,edtPassword;
    private Button btnLogin;
    String uName = "jason@gmail.com";
    String uPass = "abc12345";

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

                    Toast.makeText(MainActivity.this, "Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Display.class);
                    startActivity(i);
                    //finish();

                }else{
                    Toast.makeText(MainActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();

                }
            }

        });

        /*private String SHA(String x){
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(x.getBytes());

                byte[] digest = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest){
                    sb.append(String.format("%02x", b & 0xff));
                }
                return sb.toString();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }*/


    }
}
