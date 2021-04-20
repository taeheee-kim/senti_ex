package com.cookandroid.a2021_04_19_layout_ex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginresult);

        TextView_get = findViewById(R.id.TextView_get);

        Intent intent = getIntent();
        //extra에 넣어줬으니까 그 extra들을 bundle에 가지고 와서 하나씩 꺼내줘야 하는구나!!
        Bundle bundle = intent.getExtras();
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        TextView_get.setText(email+" / "+password);
    }
}
