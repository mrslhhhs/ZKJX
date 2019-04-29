package com.zkjx.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zkjx.myapplication.MainActivity;
import com.zkjx.myapplication.MyApplication;
import com.zkjx.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUserPhone;
    private EditText mUserPass;
    private Button mLoginButton;
    private Button mRegsButton;
    private TextView mForgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        mUserPhone = (EditText) findViewById(R.id.user_phone);
        mUserPass = (EditText) findViewById(R.id.user_pass);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mRegsButton = (Button) findViewById(R.id.regs_button);
        mForgetPass = (TextView) findViewById(R.id.forget_pass);

        mLoginButton.setOnClickListener(this);
        mRegsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.regs_button:
                Intent intent1=new Intent(this, HomeActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private void submit() {
        // validate
        String phone = mUserPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }

        String pass = mUserPass.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "pass不能为空", Toast.LENGTH_SHORT).show();
            return ;
        }

        // TODO validate success, do something


    }
}
