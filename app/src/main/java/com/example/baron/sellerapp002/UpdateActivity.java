package com.example.baron.sellerapp002;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateActivity extends AppCompatActivity {
    EditText metName,metDetails;
    ImageView mivThumb;
    int mPhotoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        setOKClickListener();
        setCancelClickListener();
    }

    private void setCancelClickListener() {
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setOKClickListener() {
        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details=metDetails.getText().toString();
                String name=metName.getText().toString();
                GeneralBean2 general=new GeneralBean2(mPhotoId,name,details);
                Intent intent=new Intent(UpdateActivity.this,MenuActivity.class);
                intent.putExtra("general", general);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    private void initData() {
        Intent intent=getIntent();
        GeneralBean2 general= (GeneralBean2) intent.getSerializableExtra("general");
        metDetails.setText(general.getDetail2());
        metName.setText(general.getName2());
        mivThumb.setImageResource(general.getResid2());
        mPhotoId=general.getResid2();
    }

    private void initView() {
        metDetails= (EditText) findViewById(R.id.etDetails);
        metName= (EditText) findViewById(R.id.etName);
        mivThumb= (ImageView) findViewById(R.id.iv_update_thumb);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
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