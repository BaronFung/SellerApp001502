package com.example.baron.sellerapp002;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.managerplat.model.Sellers;

public class Waiting extends Activity {
    private Button exitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        Intent intent = getIntent();
        final Sellers sellers = (Sellers) intent.getSerializableExtra("seller");
        new AsyncTask<String,String,String>(){

            @Override
            protected String doInBackground(String... strings) {
                HttpTrans httpTrans = new HttpTrans();
                httpTrans.signin(sellers);
                return null;
            }
        }.execute();
        exitbtn= (Button) findViewById(R.id.Exitbtn);
       exitbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent();
               intent.setClass(Waiting.this,MainActivity.class);
               startActivity(intent);
           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waiting, menu);
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
