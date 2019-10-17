package com.example.multipleactivitiesfun;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        if(intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if(action.equals(Intent.ACTION_SEND) && type.equals("text/plain")) {
                //safe to get a message
                String message = intent.getStringExtra(Intent.EXTRA_TEXT);
                TextView tv = (TextView) findViewById(R.id.shareTextView);
                tv.setText(message);
            }
        }

    }

}
