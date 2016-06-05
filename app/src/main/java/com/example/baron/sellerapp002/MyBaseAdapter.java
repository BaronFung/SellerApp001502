package com.example.baron.sellerapp002;

        import android.content.Context;
        import android.graphics.BitmapFactory;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Filter;
        import android.widget.Filterable;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Map;


        import android.content.Context;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Filter;
        import android.widget.Filterable;
        import android.widget.TextView;

        import com.managerplat.model.DishInfo;
        import com.managerplat.model.OrderInfo;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Map;

/**
 * Created by admin on 2015/12/5.
 * 降低listview的内存消耗，重复利用item的内存资源
 * 用在MainActivity中的listview上
 */
public class MyBaseAdapter extends BaseAdapter{

    private List<OrderInfo> list;

    private Context context;

    private LayoutInflater layoutInflater;


    public MyBaseAdapter(Context context, List<OrderInfo> list) {
        this.list = list;
        this.context = context;
        //this.listBack = this.list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addView(OrderInfo orderInfo) {
        list.add(orderInfo);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public OrderInfo getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewGroup item;
        int orderId = list.get(position).getOrderId();
        int dishId = list.get(position).getDishId();
        String dishName = "UIUI";
        int dishCount = list.get(position).getCount();
        for(DishInfo dishInfo:Resource.dishInfoList){
            if(dishInfo.getDishId() == dishId){
                dishName = dishInfo.getDishName();
                break;
            }
        }
        if (convertView == null) {
            // java.lang.UnsupportedOperationException: addView(View, LayoutParams) is not supported in AdapterView
            //For others who have this problem and have inflated a layout in ArrayAdapter's getView,
            // set the parent parameter to null, as in view = inflater.inflate(R.layout.list_item, null);

            //root	Optional view to be the parent of the generated hierarchy.
            item = (ViewGroup) layoutInflater.inflate(R.layout.orderlist_item, null);
            /** root为null或者attach为false时，inflate只是产生该xml资源文件的view对象
             *  否则将view添加为root view 的子view
             *
             *  在getView中只需要生成view对象即可，不要指定root view 由系统去完成listview的渲染工作
             * */

        } else {
            item = (ViewGroup) convertView;
        }
        TextView orderIdView = (TextView)item.findViewById(R.id.order_id_lyj);
        TextView dishIdView = (TextView)item.findViewById(R.id.dish_id_lyj);
        TextView dishNameView = (TextView)item.findViewById(R.id.dish_name__lyj);
        TextView dishCountView = (TextView)item.findViewById(R.id.dish_count_lyj);
        orderIdView.setText(orderId+"");
        dishIdView.setText(dishId+"");
        dishNameView.setText(dishName+"");
        dishCountView.setText(dishCount+"");
        return item;
    }
}

