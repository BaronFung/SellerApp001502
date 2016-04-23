package com.example.baron.sellerapp002;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {


    private Button button1;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        button1 = (Button)findViewById(R.id.signin_button);
        et1= (EditText) findViewById(R.id.username_edit);
        et2 = (EditText) findViewById(R.id.login_password_edit);
        et3 = (EditText) findViewById(R.id.confirm_password_edit);
        et4 = (EditText) findViewById(R.id.login_phone_edit);
        Log.i("shawn","dfddggg");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("shawn", "ggghhhg");

                if (!et1.getText().toString().isEmpty()&& !et2.getText().toString().isEmpty() && !et3.getText().toString().isEmpty() && !et4.getText().toString().isEmpty()) {
                    if (et2.getText().toString().equals(et3.getText().toString())) {
                        Intent intent = new Intent();
                        intent.setClass(SignInActivity.this, Login2.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "前后不同密码", Toast.LENGTH_SHORT).show();
                    }
                }else

                Toast.makeText(getApplicationContext(), "不能为空", Toast.LENGTH_SHORT).show();
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

