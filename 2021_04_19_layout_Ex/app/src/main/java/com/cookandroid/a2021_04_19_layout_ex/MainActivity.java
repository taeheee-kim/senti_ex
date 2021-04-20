package com.cookandroid.a2021_04_19_layout_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    LinearLayout LinearLayout_login, LinearLayout_GoogleLogin;
    String emailOK = "123@gmail.com";
    String passwordOK = "1234";
    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        LinearLayout_login = findViewById(R.id.LinearLayout_login);
        LinearLayout_GoogleLogin = findViewById(R.id.LinearLayout_GoogleLogin);

        //1. 값을 가져온다 - 검사(email==123@gmail.com / password==1234)
        //2. 클릭을 감지한다
        //3. 1번의 값을 다음 액티비티로 넘긴다

        LinearLayout_login.setClickable(false);
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    Log.d("SENTI",s.toString());
                    inputEmail = s.toString();
                    //LinearLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    Log.d("SENTI",s.toString());
                    inputPassword = s.toString();
                    //LinearLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        LinearLayout_login.setClickable(true);//click가 가능하도록 설정
        LinearLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()) {
                    String email = inputEmail;
                    String password = inputPassword;

                    Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });

    }

    public boolean validation(){
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}
