package com.agora.io.vide2.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import com.agora.io.vide2.R;
import com.agora.io.vide2.SplashActivity;
import com.agora.io.vide2.model.ConstantApp;
import com.agora.io.vide2.utils.Constant;

import io.agora.rtc.Constants;

public class MainActivity extends BaseActivity {

    ArrayList<User> users  = new ArrayList<>();
    public static User liveuser;
    public static String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void initUIandEvent() {
        final EditText textRoomName = (EditText) findViewById(R.id.room_name);
        textRoomName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean isEmpty = s.toString().isEmpty();
                findViewById(R.id.button_join).setEnabled(!isEmpty);


            }

        });


    }

    @Override
    protected void deInitUIandEvent() {
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                forwardToSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickJoin(View view) {
//        // show dialog to choose role
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.msg_choose_role);
//        builder.setNegativeButton(R.string.label_audience, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                MainActivity.this.forwardtoFeed(Constants.CLIENT_ROLE_AUDIENCE);
//            }
//        });
//        builder.setPositiveButton(R.string.label_broadcaster, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                MainActivity.this.forwardtoFeed(Constants.CLIENT_ROLE_BROADCASTER);
//                users.add(new User(R.drawable.btn_request_broadcast, username, "Live"));
//
//
//
//            }
//
//        });
//        AlertDialog dialog = builder.create();
//
//        dialog.show();
        Button join = (Button) findViewById(R.id.button_join);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SplashActivity.class);

                final EditText v_room = (EditText) findViewById(R.id.room_name);
                username = v_room.getText().toString();

                startActivity(i);




            }
        });

    }

    public void forwardToLiveRoom(int cRole) {
        final EditText v_room = (EditText) findViewById(R.id.room_name);

        String room = v_room.getText().toString();

        Intent i = new Intent(MainActivity.this, LiveRoomActivity.class);
        i.putExtra(ConstantApp.ACTION_KEY_CROLE, cRole);
        i.putExtra(ConstantApp.ACTION_KEY_ROOM_NAME, room);

        startActivity(i);
    }

    public void forwardtoFeed(int CRole){
        Intent i = new Intent(MainActivity.this, SplashActivity.class);

        startActivity(i);
    }

    public void forwardToSettings() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
}
