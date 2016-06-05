package com.example.baron.sellerapp002;

import android.util.Log;
import android.widget.EditText;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.managerplat.model.DishInfo;
import com.managerplat.model.OrderInfo;
import com.managerplat.model.SellerInfo;
import com.managerplat.model.Sellers;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baron on 4/24/16.
 */
public class HttpTrans {
    private BasicCookieStore cookieStore;
    private static CloseableHttpClient httpclient;

    public HttpTrans() {
        cookieStore = new BasicCookieStore();
        httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }


    public void signin(Sellers sellers) {
        try {
            Gson gson = new Gson();

            JSONObject jsonObject = new JSONObject();

            sellers.setSellerImagePath(gson.toJson(loadFile(sellers.getSellerImagePath())));
            sellers.setSellerLicencePath(gson.toJson(loadFile(sellers.getSellerLicencePath())));
            sellers.setSellerIDCardPath(gson.toJson(loadFile(sellers.getSellerIDCardPath())));

            HttpPost httpPost = new HttpPost(Resource.signin_url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            StringEntity stringEntity = new StringEntity(gson.toJson(sellers), "utf-8");
            stringEntity.setContentType("text/json");
            stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
            String xx = EntityUtils.toString(httpResponse.getEntity());
            Log.i("lyj", "StatusCode" + httpResponse.getStatusLine().getStatusCode() + "back" + xx);
            httpResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<SellerInfo> getRestaurantInfos() {
//        List<SellerInfo> list = new LinkedList<SellerInfo>();
//        try {
//            Gson gson = new Gson();
//            JsonParser parser = new JsonParser();
//            HttpGet httpGet = new HttpGet(Resource.getsellers_url);
//            CloseableHttpResponse httpRespons
// e = httpclient.execute(httpGet);
//            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//            JsonArray jsonArray = parser.parse(bufferReader).getAsJsonArray();
//            for (JsonElement obj : jsonArray) {
//                JsonElement str = obj.getAsJsonObject().get("sellerImage");
//                byte[] tmp = gson.fromJson(str, byte[].class);
//                SellerInfo seller = gson.fromJson(obj, SellerInfo.class);
//                seller.setSellerImage(tmp);
//                list.add(seller);
//            }
//            httpResponse.close();
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return list;
        return null;
    }

//    public void getRestaurantDishInfo(SellerInfo sellerInfo){
//        List<DishInfo> dishInfoList = new ArrayList<DishInfo>();
//        try {
//            Gson gson = new Gson();
//            JsonParser parser = new JsonParser();
//            HttpGet httpGet = new HttpGet(Resource.getsellers_dishlist+sellerInfo.getSellerId());
//            CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
//            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//            JsonArray jsonArray = parser.parse(bufferReader).getAsJsonArray();
//            for (JsonElement obj : jsonArray) {
//                JsonElement str = obj.getAsJsonObject().get("dishImage");
//                byte[] tmp = gson.fromJson(str, byte[].class);
//                DishInfo dish = gson.fromJson(obj, DishInfo.class);
//                dish.setDishImage(tmp);
//                dishInfoList.add(dish);
//            }
//            httpResponse.close();
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        sellerInfo.setSellerDishes(dishInfoList);
//    }
//
//    //发送UserInfo  返回UserInfo  得到UserID
//    public UserInfo signUpUserInfo(UserInfo userInfo){
//        try {
//            userInfo.setUserAddress("");
//            Gson gson = new Gson();
//            String tmp = gson.toJson(userInfo);
//            HttpPost httpPost = new HttpPost(Resource.signup_url);
//            httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
//            StringEntity stringEntity = new StringEntity(tmp,"utf-8");
//            stringEntity.setContentType("text/json");
//            stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//            httpPost.setEntity(stringEntity);
//
//            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
//            int userId = Integer.parseInt(EntityUtils.toString(httpResponse.getEntity()));
//            userInfo.setUserId(userId);
//            httpResponse.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return userInfo;
//    }
//
//    //发送UserInfo  返回UserInfo   得到UserID
//    public UserInfo signInUserInfo(UserInfo userInfo){
//        try {
//            userInfo.setUserAddress("");
//            userInfo.setUserPhone("");
//            Gson gson = new Gson();
//            String tmp = gson.toJson(userInfo);
//            Log.i("lyj",tmp);
//            HttpPost httpPost = new HttpPost(Resource.signin_url);
//            httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
//            StringEntity stringEntity = new StringEntity(tmp,"utf-8");
//            stringEntity.setContentType("text/json");
//            stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//            httpPost.setEntity(stringEntity);
//
//            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
//            int userId = Integer.parseInt(EntityUtils.toString(httpResponse.getEntity()));
//            Log.i("lyj",userId+"");
//            userInfo.setUserId(userId);
//            httpResponse.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return userInfo;
//    }
//
//    public String sendOrderList(List<OrderInfo> orderInfoList) {
//        String xx = "success";
//        try {
//            Gson gson = new Gson();
//            String tmp = gson.toJson(orderInfoList);
//            Log.i("lyj",tmp);
//            HttpPost httpPost = new HttpPost(Resource.sendoeder_url);
//            httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
//            StringEntity stringEntity = new StringEntity(tmp,"utf-8");
//            stringEntity.setContentType("text/json");
//            stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//            httpPost.setEntity(stringEntity);
//
//            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
//            xx = EntityUtils.toString(httpResponse.getEntity());
//            Log.i("lyj","StatusCode"+httpResponse.getStatusLine().getStatusCode()+"back"+xx);
//            httpResponse.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return xx;
//    }

    /**
     * 加载本地文件,并转换为byte数组
     *
     * @return
     */
    public static byte[] loadFile(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] data = null ;

        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream((int) file.length());

            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            data = baos.toByteArray() ;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
                if (baos != null) {
                    baos.close();
                    baos = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data ;
    }

    public void signup(String userName, String userPasswd) {
        try {
            Sellers sellers = new Sellers();
            sellers.setSellerName(userName);
            sellers.setSellerPassword(userPasswd);
            Gson gson = new Gson();

            HttpPost httpPost = new HttpPost(Resource.signup_url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            Log.i("lyj",gson.toJson(sellers));
            StringEntity stringEntity = new StringEntity(gson.toJson(sellers), "utf-8");
            stringEntity.setContentType("text/json");
            stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
            Log.i("lyj", "StatusCode" + httpResponse.getStatusLine().getStatusCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            JsonParser jsonPaser = new JsonParser();
            JsonArray jsonArray = jsonPaser.parse(br).getAsJsonArray();
            Log.i("lyj", jsonArray.size() + "jslkdjfklajsdklfj");
            for (JsonElement obj:jsonArray){
                DishInfo dish = gson.fromJson(obj,DishInfo.class);
                Resource.sellers.setSellerId(dish.getSellerId());
                Resource.dishInfoList.add(dish);
            }
            Resource.sellers.setSellerName(sellers.getSellerName());
            Resource.sellers.setSellerPassword(sellers.getSellerPassword());
            Log.i("lyj","Resource.sellers"+Resource.sellers.getSellerId());
            httpResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getNewOrders(int sellerId, int i) {
        String url = (Resource.getorder_url+"sellerId="+1+"&isSuc="+i);
        Log.i("lyj","getNewOrders:"+url);
        int size = Resource.orderInfoList.size();
        List<OrderInfo> list = new ArrayList<OrderInfo>();
        try {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
            Log.i("lyj","Status"+httpResponse.getStatusLine().getStatusCode()+","+httpResponse.getEntity().toString());
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            JsonArray jsonArray = parser.parse(bufferReader).getAsJsonArray();
            for (JsonElement obj : jsonArray) {

                OrderInfo orderInfo = gson.fromJson(obj, OrderInfo.class);
                list.add(orderInfo);
            }
            httpResponse.close();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(Resource.orderInfoList.size() == list.size()){
            return false;
        }
        Resource.orderInfoList = list;
        return true;
    }
}
