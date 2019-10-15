package com.example.multipleactivitiesfun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MultipleActivitiesFun";
    static final int LOGIN_REQUEST_CODE = 1; //identifies a request for a result code
    //unique for each request


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //this is called as a result of startActivityWithResult
        //good pracitice
        if(requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("result");
            TextView tv = (TextView) findViewById(R.id.defaultTextView);
            tv.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");

                //intent: a message to the android OS
                //sepecifying the 'intent' to start another activity
                //it intent looks good, android will start that activity
                //explicit intent: we know the name of the class we want to start
                //implicit  intent: let the user choose which activity to start that will
                        //perform our specified action
                //ex. Intent.ACTION_VIEW
                    //Intent.ACTION_SEND
                    //Intent.ACTION_DIAL
                    //Intent.ACTION_WEB_SEARCH
                    //Intent.ACTION....

                //1. explicit intent example
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //explicit requires (the name of the activity).class
                //lets say second activity needs a username, PIN that main Activity collected
                String username = "bob";
                int pin = 1234;
                //we can put extra data into intent as k,v pairs
                //etc python dict/hashmap
                intent.putExtra("username", username);
                intent.putExtra("pin", pin);
                //startActivity(intent);
                startActivityForResult(intent, LOGIN_REQUEST_CODE);

                //Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

        Button viewButton = (Button) findViewById(R.id.viewGUHomepageButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                //4. implicit intent example #1
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri guUri = Uri.parse("https:/www.gonzaga.edu");
                intent.setData(guUri);
                startActivity(intent);
            }
        });
    }


}

//6 things to do today
//1)
//main activity with default text view
    //button start 2nd activity
//second activity
    //background set
    //button to get back to main activity
//2) -- pass data from main -> second
//3) pass result data back from second -> main
//4) add another button viewGUHomepage
    //prompt the user for web browser
    //will start chrome
//5) button to send a message, choose which app to use
//6) define a third activity, share activity
    // single text view
    // this activity  can also be started from the send button
