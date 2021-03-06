package com.example.baron.sellerapp002;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button) findViewById(R.id.signUp);
        TextView textview = (TextView) findViewById(R.id.signintext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userNameView = (EditText)findViewById(R.id.userName);
                EditText userPasswdView = (EditText)findViewById(R.id.userPasswd);
                final String userNameStr = userNameView.getText().toString();
                final String userPassword = userPasswdView.getText().toString();
                new AsyncTask<String, String, String>()  {

                    @Override
                    protected String doInBackground(String... strings) {


                        Log.i("lyj","hjsljflkasjdflkjasdlkjfl----login"+userNameStr+"   "+userNameStr);
                        HttpTrans httpTrans = new HttpTrans();
                        httpTrans.signup(userNameStr, userPassword);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, SignUpActivity.class);
                        Log.i("shawn", "gggggg");
                        startActivity(intent);
                    }
                }.execute();

            }
        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SignInActivity.class);
                Log.i("shawn", "gg");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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