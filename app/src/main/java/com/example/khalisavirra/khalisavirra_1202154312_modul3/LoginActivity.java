package com.example.khalisavirra.khalisavirra_1202154312_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private ImageView mlogo;
    private EditText musername;
    private EditText mpassword;
    public static final String EXTRA_MESSAGE = "resii";
    //public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mlogo = (ImageView) findViewById(R.id.image_logo);
        musername = (EditText) findViewById(R.id.username);
        mpassword = (EditText) findViewById(R.id.password);
    }

    public void login(View view) {
        String user = musername.getText().toString();
        String pass = mpassword.getText().toString();
        if (user.equals("EAD") && pass.equals("MOBILE")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(EXTRA_MESSAGE, user);
            startActivity(intent);
            Toast.makeText(this, "Selamat anda Berhasil Login", Toast.LENGTH_LONG).show();
        } else {
            Toast toast = Toast.makeText(this, "Maaf Usermame atau Password yang anda masukkan salah", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
 }
