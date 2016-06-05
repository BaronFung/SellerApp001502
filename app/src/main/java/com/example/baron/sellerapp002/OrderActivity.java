package com.example.baron.sellerapp002;


import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.managerplat.model.OrderInfo;

public class OrderActivity extends Activity {

    private ListView listView;
    private MyBaseAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        listView = (ListView) findViewById(R.id.orderListView);
        LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View headerView = lif.inflate(R.layout.header, null);

        listView.addHeaderView(headerView);
//        OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setSellerId(9);
//        orderInfo.setCount(2);
//        orderInfo.setOrderId(2);
//        orderInfo.setDishId(10);
//        Resource.orderInfoList.add(orderInfo);
        myListAdapter = new MyBaseAdapter(OrderActivity.this,Resource.orderInfoList);
        listView.setAdapter(myListAdapter);
        new Thread(){
            @Override
            public void run() {

                HttpTrans httpTrans = new HttpTrans();
                while(true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i("lyj","whiletrue");
                    int sum = Resource.orderInfoList.size();
                    boolean flag = httpTrans.getNewOrders(Resource.sellers.getSellerId(),0);
                    int sum1 = Resource.orderInfoList.size();
                    Log.i("lyj","whiletrue"+sum+","+sum1);
                    if(flag){
                        for(;sum < sum1;sum++){
                            myListAdapter.addView(Resource.orderInfoList.get(sum));
                        }
                        listView.post(new Runnable() {
                            @Override
                            public void run() {
                                myListAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
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