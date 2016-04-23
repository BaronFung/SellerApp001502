package com.example.baron.sellerapp002;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MenuActivity extends Activity {
    ListView mlvGeneral;
    List<GeneralBean> mGenerals;
    GeneralAdapter mAdapter;
    int[] resid={
            R.drawable.kunshanspicedduck,
            R.drawable.kungpaochicken,R.drawable.mapo,
            R.drawable.premeat,R.drawable.bouilli,R.drawable.saltedduck,
            R.drawable.ribs,R.drawable.shrimpmeat,R.drawable.xiaochaorou

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initData();
        initView();
        setListener();

    }

    private void setListener() {
        setOnItemClickListener();
        setOnItemLongClickListener();

    }

    private void setOnItemLongClickListener() {
        mlvGeneral.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(MenuActivity.this, mGenerals.get(position).getName()+"bb", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setOnItemClickListener() {
        mlvGeneral.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MenuActivity.this, mGenerals.get(position).getName() + "bbb", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mlvGeneral=(ListView) findViewById(R.id.lGeneral);
        mAdapter=new GeneralAdapter();
        mlvGeneral.setAdapter(mAdapter);
    }

    private void initData() {

        String[] names=getResources().getStringArray(R.array.generals);
        mGenerals=new ArrayList<GeneralBean>();
        for (int i = 0; i < names.length; i++) {
            GeneralBean bean=new GeneralBean(resid[i], names[i]);
            mGenerals.add(bean);
        }
    }


    class GeneralAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mGenerals.size();
        }

        @Override
        public GeneralBean getItem(int position) {
            return mGenerals.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View layout=View.inflate(MenuActivity.this, R.layout.list_item_cut, null);

            ImageView ivThumb=(ImageView) layout.findViewById(R.id.iThumb);
            TextView tvName=(TextView) layout.findViewById(R.id.iName);
            GeneralBean bean=mGenerals.get(position);
            ivThumb.setImageResource(bean.getResid());
            tvName.setText(bean.getName());

            return layout;
        }

    }
}
