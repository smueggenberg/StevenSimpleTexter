package edu.css.smueggenberg.stevensimpletexter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btnMatt;
    Button btnBrian;
    Button btnTayler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMatt = (Button) findViewById(R.id.btnMatt);
        btnBrian = (Button) findViewById(R.id.btnBrian);
        btnTayler = (Button) findViewById(R.id.btnTayler);

        btnMatt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changeScreen(0);
            }
        });

        btnBrian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changeScreen(1);
            }
        });

        btnTayler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changeScreen(2);
            }
        });
    }


    public void changeScreen(int senderId){
        Intent i = new Intent(getApplicationContext(), TextActivity.class);
        i.putExtra("senderId", senderId);

        startActivity(i);
    }
}
