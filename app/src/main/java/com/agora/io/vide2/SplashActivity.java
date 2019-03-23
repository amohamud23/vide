package com.agora.io.vide2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.agora.io.vide2.ui.MainActivity;
import com.agora.io.vide2.ui.User;

import com.agora.io.vide2.model.ConstantApp;
import com.agora.io.vide2.ui.LiveRoomActivity;


import java.lang.reflect.Array;
import java.util.ArrayList;

import io.agora.rtc.Constants;

public class SplashActivity extends AppCompatActivity {



    @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        Button LiveButton = (Button) findViewById(R.id.push_button3);
        LiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SplashActivity.this, LiveRoomActivity.class);



                i.putExtra(ConstantApp.ACTION_KEY_CROLE, Constants.CLIENT_ROLE_BROADCASTER);
                final String room = MainActivity.username;
                i.putExtra(ConstantApp.ACTION_KEY_ROOM_NAME, room);

                TextView textView1 = (TextView) findViewById(R.id.livefeed1);

                textView1.setText(MainActivity.username);

                startActivity(i);
            }
        });

        TextView livestream1 =(TextView) findViewById(R.id.livefeed1);

        livestream1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String room =  ((TextView) findViewById(R.id.livefeed1)).getText().toString();
                Intent i = new Intent(SplashActivity.this, LiveRoomActivity.class);
                i.putExtra(ConstantApp.ACTION_KEY_CROLE, Constants.CLIENT_ROLE_AUDIENCE);
                i.putExtra(ConstantApp.ACTION_KEY_ROOM_NAME, room);
                startActivity(i);
            }
        });


    }

    public void showstatus(ArrayList<User> liveusers)
    {





    }
}
