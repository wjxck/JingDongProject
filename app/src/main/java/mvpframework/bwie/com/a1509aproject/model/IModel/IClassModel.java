package mvpframework.bwie.com.a1509aproject.model.IModel;

import mvpframework.bwie.com.a1509aproject.bean.Catagory;
import mvpframework.bwie.com.a1509aproject.bean.ProductCatagoryBean;
import mvpframework.bwie.com.a1509aproject.net.OnNetListener;

/**
 * Created by peng on 2017/11/7.
 */

public interface IClassModel {
    public void getCatagory(OnNetListener<Catagory> onNetListener);

    public void getProductCatagory(String cid, OnNetListener<ProductCatagoryBean> onNetListener);
}
