package mvpframework.bwie.com.a1509aproject.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;
import mvpframework.bwie.com.a1509aproject.model.IModel.IClassModel;
import mvpframework.bwie.com.a1509aproject.net.Api;
import mvpframework.bwie.com.a1509aproject.net.HttpUtils;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by peng on 2017/11/7.
 * 获取分类的model
 */

public class ClassModel extends BaseModel implements IClassModel {

    @Override
    public void getCatagory(final OnNetListener<Catagory> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.CLASS, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Catagory catagory = new Gson().fromJson(string, Catagory.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(catagory);
                    }
                });
            }
        });
    }

    @Override
    public void getProductCatagory(String cid, final OnNetListener<ProductCatagoryBean> onNetListener) {
        Map<String, String> params = new HashMap<>();
        params.put("cid", cid);
        HttpUtils.getHttpUtils().doPost(Api.PRODUCT_CATAGORY, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final ProductCatagoryBean productCatagoryBean = new Gson().fromJson(string, ProductCatagoryBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(productCatagoryBean);
                    }
                });
            }
        });
    }


}
