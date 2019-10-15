package com.example.multipleactivitiesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null) {
            //returns null if it doesn't find the username key
            String username = intent.getStringExtra("username");
            //returns default value if it doesn't find "pin"
            int pin = intent.getIntExtra("pin", 0);
            Toast.makeText(this, username+ " " + pin,Toast.LENGTH_LONG).show();
        }

        //call SecondActivity.this.finish();
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                //3. send a result back to main activity
                Intent intent = new Intent();
                intent.putExtra("result", "successful");
                setResult(Activity.RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }
}
