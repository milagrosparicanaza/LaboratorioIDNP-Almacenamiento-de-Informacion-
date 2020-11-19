package com.example.sharepreferents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mNameTv, mArtistTv;
    Button mLogoutBtn;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        mNameTv = findViewById(R.id.nameTv);
        mArtistTv = findViewById(R.id.artistTv);
        mLogoutBtn = findViewById(R.id.logout);

        preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        String name = preferences.getString("NAME", "");
        mNameTv.setText(name);
        String artist = preferences.getString("ARTIST", "");
        mNameTv.setText(artist);

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}