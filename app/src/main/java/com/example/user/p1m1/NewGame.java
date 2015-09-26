package com.example.user.p1m1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class NewGame extends AppCompatActivity {

    Button easy_game;
    Button medium_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame_layout);

        medium_game = (Button) findViewById(R.id.btn_medium);
        easy_game = (Button) findViewById(R.id.btn_easy);

        easy_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easy_game_intent = new Intent(getApplicationContext(), EasyGame.class);
                //final int result = 2;

                startActivity(easy_game_intent);
            }
        });

        medium_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent medium_game_intent = new Intent(getApplicationContext(), MediumGame.class);
                final int result = 1;

                startActivityForResult(medium_game_intent, result);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
