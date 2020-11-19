package com.example.sharepreferents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mNameEt, mArtistEt;
    CheckBox mRemember;
    Button mBtn;
    SharedPreferences sharedPreferences;
    boolean isRemembered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt = findViewById(R.id.nameEt);
        mArtistEt = findViewById(R.id.artistaEt);
        mRemember = findViewById(R.id.checkBox);
        mBtn = findViewById(R.id.registrar);

        sharedPreferences = getSharedPreferences(  "SHARED_PREF", MODE_PRIVATE);

        isRemembered = sharedPreferences.getBoolean("CHECKBOK", false);

        if(isRemembered){
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            startActivity(intent);
            finish();
        }

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = mNameEt.getText().toString();
                String artist = mArtistEt.getText().toString();
                boolean checked = mRemember.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME", name);
                editor.putString("ARTIST", artist);
                editor.putBoolean("CHECKBOX", checked);
                editor.apply();

                Toast.makeText(MainActivity.this, "Information Save!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}