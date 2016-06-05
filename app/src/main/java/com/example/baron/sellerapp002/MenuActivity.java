package com.example.baron.sellerapp002;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {
    ListView mlvGeneral;
    List<GeneralBean2> mGenerals;
    GeneralAdapter mAdapter;
    private static final int ACTION_DETAILS=0;
    private static final int ACTION_ADD=1;
    private static final int ACTION_DELETE=2;
    private static final int ACTION_UPDATE=3;

    int mPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initData();
        initView();
        setListener();
    }

    private void setListener() {
        mlvGeneral.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("选择以下操作")
                        .setItems(new String[]{"查看详情", "添加数据", "删除数据", "修改数据"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case ACTION_DETAILS:
                                        showDetails(position);
                                        break;
                                    case ACTION_ADD:
                                        break;
                                    case ACTION_DELETE:
                                        mAdapter.remove(position);
                                        break;
                                    case ACTION_UPDATE:
                                        Intent intent=new Intent(MenuActivity.this,UpdateActivity.class);
                                        intent.putExtra("general",mGenerals.get(position));
                                        mPosition=position;
                                        startActivityForResult(intent,ACTION_UPDATE);
                                        break;
                                }
                            }

                            private void showDetails(int position) {
                                GeneralBean2 general = mGenerals.get(position);
                                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                                builder.setTitle(general.getName2())
                                        .setMessage(general.getDetail2())
                                        .setPositiveButton("返回", null);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }

    private void initView() {
        mlvGeneral= (ListView) findViewById(R.id.lvGeneral);
        mAdapter=new GeneralAdapter(mGenerals,this);
        mlvGeneral.setAdapter(mAdapter);
    }

    private void initData() {
        String[] names=getResources().getStringArray(R.array.generals);
        String[] details=getResources().getStringArray(R.array.details);
        int[] resid={
                R.drawable.kunshanspicedduck,
                R.drawable.kungpaochicken,R.drawable.mapo,
                R.drawable.premeat,R.drawable.bouilli,R.drawable.saltedduck,
                R.drawable.ribs,R.drawable.shrimpmeat
        };
        mGenerals=new ArrayList<GeneralBean2>();
        for (int i=0;i<resid.length;i++){
            GeneralBean2 general=new GeneralBean2(resid[i],names[i],details[i]);
            //GeneralBean2 general=new GeneralBean2(resid[i],names[i],details[i]);
            mGenerals.add(general);
        }
    }

    class GeneralAdapter extends BaseAdapter{
        List<GeneralBean2> generals;
        MenuActivity context;
        public void remove(int position){
            generals.remove(position);
            notifyDataSetChanged();
        }
        public void add(GeneralBean2 general){
            mGenerals.add(general);
            notifyDataSetChanged();
        }
        public void update(int position,GeneralBean2 general){
            mGenerals.set(position,general);
            notifyDataSetChanged();
        }

        public GeneralAdapter(List<GeneralBean2> generals, MenuActivity context) {
            this.generals = generals;
            this.context = context;
        }



        @Override
        public int getCount() {
            return generals.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if (convertView==null){
                convertView=View.inflate(context,R.layout.list_item,null);
                holder=new ViewHolder();
                holder.ivThumb= (ImageView) convertView.findViewById(R.id.iThumb);
                holder.tvName= (TextView) convertView.findViewById(R.id.iName);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            GeneralBean2 general=generals.get(position);
            holder.ivThumb.setImageResource(general.getResid2());
            holder.tvName.setText(general.getName2());
            return convertView;
        }
        class ViewHolder{
            ImageView ivThumb;
            TextView tvName;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!=RESULT_OK){
            return;
        }
        switch (requestCode){
            case ACTION_UPDATE:
                GeneralBean2 general= (GeneralBean2) data.getSerializableExtra("general");
                mAdapter.update(mPosition,general);
                break;
            case ACTION_ADD:
                break;
        }
    }
}
