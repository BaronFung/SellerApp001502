package com.example.baron.sellerapp002;

import com.managerplat.model.DishInfo;
import com.managerplat.model.OrderInfo;
import com.managerplat.model.Sellers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baron on 4/24/16.
 */
public class Resource {
    private static String IP = "192.168.10.44";

    //注册
    public static String signin_url = "http://"+IP+":8080/zzDDManagerPlat/sellerRegist";

    //登录
    public static String signup_url = "http://"+IP+":8080/zzDDManagerPlat/sellerLogin";

    //获取订单
    public static String getorder_url = "http://"+IP+":8080/zzDDManagerPlat/getOrders?";


    public static Sellers sellers = new Sellers();

    public static List<DishInfo> dishInfoList = new ArrayList<DishInfo>();

    public static List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();

}
